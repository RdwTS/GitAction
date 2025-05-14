# GitAction

This repository contains a sample GitHub Actions setup for CI/CD automation.

## 🔧 Tools & Technology
| Teknologi            | Versi | Keterangan                                 |
|----------------------|-------|--------------------------------------------|
| Java                 | 21    | Bahasa pemrograman utama                   |
| Gradle               | 8.5   | Build automation tool                      |

- **GitHub Actions**: CI/CD automation
- **YAML**: Workflow configuration
- **Gradle** – sebagai build tool


## 🚀 Features

- Automated build and test pipeline
- CI trigger on push and pull request
- Simple and extensible workflow design

## ▶️ Cara Menggunakan

1. Fork atau clone repositori ini
2. Lakukan push atau buat pull request
3. Workflow akan berjalan secara otomatis melalui GitHub Actions


## ⚙️ Langkah-langkah (Pengaturan Gradle di IntelliJ IDEA)

Untuk menghindari error saat menjalankan test di IntelliJ IDEA:

1. Buka **Preferences / Settings**:
    - **Windows/Linux**: `File > Settings`
    - **macOS**: `IntelliJ IDEA > Preferences`
2. Navigasi ke:  
   `Build, Execution, Deployment > Build Tools > Gradle`
3. Pada bagian **Run tests using**, ubah dari `Gradle` menjadi `IntelliJ IDEA`
4. Klik **OK** atau **Apply**

## 🧪 Menjalankan Project dengan Gradle

Berikut beberapa perintah yang dapat digunakan untuk membangun dan menjalankan pengujian pada proyek ini:

| Perintah | Keterangan |
|---------|------------|
| `gradle build` | Melakukan build proyek secara keseluruhan |
| `gradle test` | Menjalankan semua unit test |
| `gradle cucumber` | Menjalankan semua skenario Cucumber |
| `gradle cucumber -Ptags="@valid-login"` | Menjalankan Cucumber berdasarkan tag tertentu |
| `gradle cucumberJUnit` | Menjalankan skenario Cucumber dalam format JUnit |

> **Catatan:** Pastikan Anda sudah menginstall Gradle dan JDK yang sesuai sebelum menjalankan perintah di atas.

## 📌 Catatan

- Pastikan konfigurasi `ci.yml` sesuai dengan kebutuhan proyek Anda
- Workflow ini hanya sebagai contoh dasar dan dapat dikembangkan lebih lanjut

---

Dibuat oleh [RdwTS](https://github.com/RdwTS)