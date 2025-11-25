# CRUD Mahasiswa – Java Hibernate + MySQL

Proyek ini merupakan aplikasi desktop berbasis Java Swing yang menggunakan Hibernate sebagai ORM untuk melakukan operasi CRUD (Create, Read, Update, Delete) pada data Mahasiswa di database MySQL.

## ✨ Fitur Aplikasi

* Menampilkan seluruh data mahasiswa dalam JTable
* Menambahkan data mahasiswa baru
* Mengupdate data mahasiswa
* Menghapus data mahasiswa
* Membersihkan input form
* Refresh data dari database
* Auto-load data saat program berjalan

---

## 🏛 Teknologi yang Digunakan

* Java JDK 8+
* NetBeans IDE
* Hibernate ORM
* MySQL
* MySQL Connector/J
* Java Swing (GUI)

---

## 🗄 Struktur Database

Database: `db_mahasiswa`
Tabel: `mahasiswa`

Kolom:

* `id` (INT, auto increment, primary key)
* `npm/nim` (VARCHAR)
* `nama` (VARCHAR)
* `jurusan` (VARCHAR)

---

## Konfigurasi Hibernate

File: `hibernate.cfg.xml`

Contoh konfigurasi:

```xml
<hibernate-configuration>
  <session-factory>
    <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/db_mahasiswa?zeroDateTimeBehavior=convertToNull</property>
    <property name="hibernate.connection.username">root</property>
    <property name="hibernate.connection.password"></property>
    <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
    <property name="hibernate.show_sql">true</property>
    <property name="hibernate.format_sql">true</property>
  </session-factory>
</hibernate-configuration>
```

---

## Cara Menjalankan Aplikasi

1. Start MySQL (via XAMPP / langsung service)
2. Buat database `db_mahasiswa`
3. Import tabel mahasiswa (jika diperlukan)
4. Pastikan file `mysql-connector-j-x.x.x.jar` terdapat di Libraries
5. Build project di NetBeans
6. Jalankan aplikasi

---

## 🛠 Troubleshooting

### Error: `Session cannot be resolved`

Solusi: Pastikan ada import

```java
import org.hibernate.Session;
import org.hibernate.Transaction;
```

---

### Error: `Communications link failure`

Solusi:

* MySQL belum dinyalakan
* Port MySQL bukan 3306
* Database `db_mahasiswa` tidak ada
* Username/password MySQL salah

---

## Tentang Aplikasi

Aplikasi ini dibuat sebagai latihan / tugas akademik untuk memahami:

* Penerapan Hibernate ORM pada Java
* Interaksi GUI dengan database
* Implementasi fungsi CRUD
* Manajemen koneksi database melalui Session Hibernate

---
