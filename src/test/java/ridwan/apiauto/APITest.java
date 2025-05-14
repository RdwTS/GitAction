package ridwan.apiauto;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APITest {

    String URL = "api/users/";
    String baseURL= "https://reqres.in/";

    @Test
    public void getUser() {
        //baseURL
        RestAssured.baseURI = baseURL;

        // id user
        int userId     =  5 ;

//      user perpage
        given().header("x-api-key", "reqres-free-v1")
                .when().get(URL+userId)
                .then()
                .log().all()
//                .header("x-api-key","reqres-free-v1")
                .assertThat().statusCode(200)
                .assertThat().body("data.id", Matchers.equalTo(5)); // validasi output

    }

    @Test
    public void getUserNegative() {
        //baseURL
        RestAssured.baseURI = baseURL;

        // id user
        String userId     = "A";

        // user perpage
        given().header("x-api-key", "reqres-free-v1")
                .when().get(URL+userId)
                .then()
                .log().all()
                .assertThat().statusCode(404);

    }

    @Test
    public void getListUser(){
        //baseURL
        RestAssured.baseURI = baseURL;
        // user perpage
        given().header("x-api-key", "reqres-free-v1")
                .when().get(URL +"?page=1")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("page", Matchers.equalTo(1)) // validasi output
                .assertThat().body("data.id",Matchers.hasSize(6));
    }

    @Test
    public void createNewUser(){
        //baseURL
        RestAssured.baseURI = baseURL;
        // parameter Json
        String nama      = "Jayjay";
        String pekerjaan = "student";

        JSONObject fieldJson = new JSONObject();
        fieldJson.put("name",nama       );
        fieldJson.put("job" ,pekerjaan  );
        //include header Json format
        given().log().all() // for print entire request to console
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .body(fieldJson.toString())
                .post("api/users")
                .then()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(nama))
                .assertThat().body("job",Matchers.equalTo(pekerjaan))
                .assertThat().body("$",Matchers.hasKey("id"))
                .assertThat().body("$",Matchers.hasKey("createdAt"));
    }

    @Test
    public void updateUserPUT(){
        //baseURL
        RestAssured.baseURI = baseURL;
        // data update
        int userId     = 2;
        String newName = "updateUser";

        // get data before update
        String firstName = given().when().get(URL + userId).getBody().jsonPath().get("data.first_name");
        String lastName  = given().when().get(URL + userId).getBody().jsonPath().get("data.last_name" );
        String avatar    = given().when().get(URL + userId).getBody().jsonPath().get("data.avatar"    );
        String email     = given().when().get(URL + userId).getBody().jsonPath().get("data.email"     );
        System.out.println("First name before change :" + firstName );
        System.out.println("Last name before change :"  + lastName  );
        System.out.println("avatar before change :"     + avatar    );
        System.out.println("email before change :"      + email     );

        //change data & create body request
        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id"            ,userId     );
        bodyMap.put("first_name"    ,newName    );
        bodyMap.put("last_name"     ,lastName   );
        bodyMap.put("avatar"        ,avatar     );
        bodyMap.put("email"         ,email      );
        System.out.println(bodyMap);
        JSONObject fieldJson = new JSONObject(bodyMap);

        //include header Json format
        given().log().all() // for print entire request to console
                .header("x-api-key","reqres-free-v1")
                .header("Content-Type","application/json")
//                .header("Accept","application/json")
                .body(fieldJson.toString())
                .put(URL + userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));
//                .assertThat().body("job",Matchers.equalTo(pekerjaan))
//                .assertThat().body("$",Matchers.hasKey("id"))
//                .assertThat().body("$",Matchers.hasKey("createdAt"));
    }

    @Test
    public void updateUserPATCH() {
        //baseURL
        RestAssured.baseURI = baseURL;

        // id user
        int userId     = 3;
        String newName = "updateUser";
        String firstName = given().when().get(URL + userId).getBody().jsonPath().get("data.first_name");
        System.out.println("First name before change :" + firstName );

        // change name
        HashMap<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("first_name",newName);
        JSONObject fieldJson = new JSONObject (bodyMap);


        given().log().all()
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type","application/json")
                .body(fieldJson.toString())
                .put(URL + userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));

    }

    @Test
    public void deleteUser() {
        //baseURL
        RestAssured.baseURI = baseURL;

        // dataDelete
        int userToDelete     = 4;

        given().log().all()
                .header("x-api-key", "reqres-free-v1")
                .when().delete(URL + userToDelete)
                .then().log().all()
                .assertThat().statusCode(204);

    }

    @Test
    public void validateJsonSchemaGetSingleUser() {
        //baseURL
        RestAssured.baseURI = baseURL;

        // id user
        int userToGet     = 5;

        //file Path Json Schema
        File pathFile = new File("src/test/resources/jsonSchema/getSingleUserJsonSchema.json");

//      Test Get API
        given().log().all()
                .header("x-api-key", "reqres-free-v1")
                .when().get(URL+userToGet)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(pathFile)); // validasi output

    }

}
