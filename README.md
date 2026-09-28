# MK-PBO-Sistem-Pengelolaan-Jasa-Make-Up
Nama : Sabrina Azhmalia Nisa

NIM : 2509116051

Kelas : Sistem Informasi B

---

## 1. Deskripsi Proyek

### Ringkasan Program

Program ini merupakan program berbasis konsol atau _command line_ yang mensimulasikan seorang Make Up Artist (MUA) untuk memanajemen usaha jasa make up mereka, mulai dari pencatatan data klien atau pelanggan, pemilihan kategori layanan, hingga perhitungan total biaya secara otomatis. Program ini berfokus pada jenis make up yang paling sering dipesan oleh masyarakat. Umumnya seorang MUA menawarkan lebih dari satu jenis layanan make up, seperti pada program ini yang menawarkan jenis layanan make up wisuda dan make up pengantin. 

### Kegunaan Program
Pada kedua jenis layanan tersebut memiliki karakteristik yang berbeda, baik dari segi harga dasar, cara perhitungan biaya, maupun detail tambahan yang ditawarkan. Pengelolaan pesanan secara manual akan menyulitkan MUA dalam mencatat data klien maupun menghitung total biaya secara konsisten. Maka dari itu, dibuatlah sistem ini agar menyelesaikan permasalahan tersebut. Adapun detail dari jenis make up tersebut pada program ini, antara lain:
|Kategori	| Harga Dasar |	Rumus Perhitungan Biaya |	Detail Tambahan|
|-----------|-----------|-----------|-----------|
|Make Up Wisuda |	Rp250.000 / orang	| Harga Dasar × Jumlah Orang + (Retouch Kit)	| Jumlah orang dirias, opsi Retouch Kit (+Rp50.000)|
|Make Up Pengantin |	Rp1.000.000 / sesi	| Harga Dasar × Jumlah Sesi + (Sanggul/Hairdo)	| Jumlah sesi rias, opsi Sanggul/Hairdo (+Rp200.000)|

---

## 2. Hierarki Class

Program ini terdiri dari lima class: empat class utama yang berkaitan, ditambah satu class pendukung untuk validasi input.

```mermaid
classDiagram
    class LayananMakeUp {
        #String namaKlien
        #String noHPKlien
        #String jenisLayanan
        #String makeupLook
        #String tanggalPemesanan
        #double hargaAwal
        +hitungTotalBiaya() double
        +tampilkanDetailPesanan()
    }
    class MakeUpWisuda {
        -int jumlahOrangDirias
        -boolean adaRetouchKit
        +hitungTotalBiaya() double
        +tampilkanDetailPesanan()
    }
    class MakeUpPengantin {
        -int jumlahSesiRias
        -boolean includeSanggul
        +hitungTotalBiaya() double
        +tampilkanDetailPesanan()
    }
    LayananMakeUp <|-- MakeUpWisuda : extends
    LayananMakeUp <|-- MakeUpPengantin : extends
```

Class `SistemJasaMUA` dan `LayananValidator` tidak dimasukkan ke dalam diagram karena keduanya bukan bagian dari hierarki pewarisan. Adapun penjelasan tiap class adalah sebagai berikut:

| Class | Peran |
|---|---|
| `SistemJasaMUA` (Main Class) | Program utama yang menjalankan menu interaktif. Menangani input pengguna, membuat objek `MakeUpWisuda` atau `MakeUpPengantin` sesuai pilihan, dan menampilkan hasilnya. |
| `LayananValidator` | Class pendukung yang berisi method validasi input seperti `inputAngka`, `inputTanggal`, `inputNomorHp`, `inputYesNo`. |
| `LayananMakeUp` (Superclass) | Class induk yang menyimpan atribut umum semua layanan seperti nama klien, nomor HP, tanggal pengerjaan, dan tampilan make up atau _make up look_. |
| `MakeUpWisuda` (Subclass) | Mewarisi `LayananMakeUp`, dengan penambahan atribut jumlah orang yang dirias dan opsi Retouch Kit atau set make up kecil untuk merapikan riasan agar tetap terlihat *fresh*. |
| `MakeUpPengantin` (Subclass) | Mewarisi `LayananMakeUp`, dengan penambahan atribut jumlah sesi rias seperti sesi akad atau sesi resepsi, dan opsi Sanggul/Hairdo. |

---

## 3. Alur Program
Adapun struktur packages pada program ini adalah sebagai berikut:
```
src
 ├── Main
 │    └── SistemJasaMUA.java        → Program utama (menu dan alur)
 ├── Model
 │    ├── LayananMakeUp.java        → Superclass
 │    ├── MakeUpWisuda.java         → Subclass
 │    └── MakeUpPengantin.java      → Subclass
 └── controller
      └── LayananValidator.java     → Kumpulan validasi input
```

Berikut merupakan penjelasan alur program:

1. Program dimulai dan menampilkan menu utama, menu ini ditampilkan berulang sampai pengguna memilih Keluar.

   <img height="200" alt="image" src="https://github.com/user-attachments/assets/efb34da6-9e06-4416-91bb-f7cf53c6c226" />

2. Menu 1 (Tambah Pesanan), pengguna mengisi nama, nomor HP, dan tanggal pengerjaan. Nomor HP dan tanggal langsung divalidasi, sehingga pengguna diminta mengulang jika formatnya salah. Pengguna memilih kategori make up. Berdasarkan pilihan itu, program meminta data khusus jumlah orang dan Retouch Kit untuk make up wisuda, atau jumlah sesi dan Sanggul/Hairdo untuk make up pengantin. Program lalu membuat objek `MakeUpWisuda` atau `MakeUpPengantin` sesuai kategori, lalu menyimpannya ke `ArrayList`.

   <img height="500" alt="image" src="https://github.com/user-attachments/assets/87326b83-91a5-4ac4-b645-57602c2ac07d" />

6. Menu 2 (Lihat Semua Pesanan), jika belum ada pesanan, program menampilkan pemberitahuan. Jika sudah ada, program menelusuri seluruh pesanan dengan *loop* dan menampilkan detail serta total biayanya.

   <img height="500" alt="image" src="https://github.com/user-attachments/assets/23b644c1-d6c0-43c1-960d-a80822efafb7" />

8. Menu 3 (Keluar), program berhenti.

   <img width="446" height="251" alt="image" src="https://github.com/user-attachments/assets/a8f22706-adbb-4051-88e8-abfa92045687" />


## 4. Penerapan Inheritance

Inheritance (pewarisan) diterapkan dengan menjadikan `LayananMakeUp` sebagai **superclass**, sedangkan `MakeUpWisuda` dan `MakeUpPengantin` sebagai dua **subclass** yang mewarisinya lewat kata kunci `extends`. Bentuk ini disebut *hierarchical inheritance*, yaitu satu superclass dengan beberapa subclass.


<img width="524" height="86" alt="image" src="https://github.com/user-attachments/assets/cf750b9c-02dc-4db7-ae8d-4305191e3608" />


<img width="498" height="86" alt="image" src="https://github.com/user-attachments/assets/99d37c28-5f81-4c67-a489-3757c8abcc2a" />


Tujuan penerapan inheritance pada program ini:

- **Kode tidak terduplikasi.** Atribut dan method yang bersifat umum cukup ditulis satu kali di `LayananMakeUp`, lalu otomatis dimiliki oleh kedua subclass.
- **Pemanggilan constructor induk melalui `super(...)`.** Setiap subclass memanggil constructor `LayananMakeUp` untuk mengisi data umum, sebelum melanjutkan pengisian atribut khususnya masing-masing.

<img height="200" alt="image" src="https://github.com/user-attachments/assets/437424ab-7e35-4ef1-86bb-4c515cafb3fc" />

<img height="200" alt="image" src="https://github.com/user-attachments/assets/420b6498-9106-4f03-bdd0-aa2f7ce14266" />

---

## 5. Penerapan Polymorphism

Polymorphism pada program ini diterapkan lewat **method overriding**, di mama method milik superclass `LayananMakeUp` ditulis ulang oleh masing-masing subclass dengan isi yang berbeda. Ada dua method yang dioverride, yaiut:

### a. `hitungTotalBiaya()`: rumus berbeda untuk tiap kategori

Di superclass, method ini hanya mengembalikan harga dasar.
Penerapan pada subclass `MakeUpPengantin`.

<img width="496" height="200" alt="image" src="https://github.com/user-attachments/assets/decf178b-f6f9-4134-88b2-160b645b04ba" />

Penerapan pada subclass `MakeUpWisuda`.

<img width="525" height="198" alt="image" src="https://github.com/user-attachments/assets/0424287a-3678-4416-a3e2-502ee4a1d7fe" />


### b. `tampilkanDetailPesanan()`: tampilan berbeda untuk tiap kategori

Setiap subclass memanggil versi superclass dulu lewat `super.tampilkanDetailPesanan()` untuk mencetak data umum, lalu menambahkan informasi khususnya sendiri:

<img width="1018" height="192" alt="image" src="https://github.com/user-attachments/assets/7fad31ad-92a2-45b2-84d6-f1f4f5d97e73" />


## 6. Penerapan Condition (If-Else)

Percabangan digunakan untuk menentukan langkah program berdasarkan pilihan atau kondisi data. Berikut merupakan penerapan condition.

**1. Menentukan kategori make up** 

<img width="1102" height="426" alt="image" src="https://github.com/user-attachments/assets/594f23e7-29de-417f-a51b-84ee177fc83c" />


**2. Menentukan *make up look* dari pilihan pengguna:**

<img width="828" height="308" alt="image" src="https://github.com/user-attachments/assets/c73ee094-41d6-4a94-8e3d-7f17cdaffcb9" />


## 7. Penerapan Looping

Perulangan digunakan agar program dapat berjalan terus-menerus dan memproses data yang jumlahnya tidak tetap. Ada tiga jenis perulangan yang dipakai.

**1. `do-while`: menu utama yang berulang.** 

Menu ditampilkan minimal satu kali dan terus berulang sampai pengguna memilih Keluar (3):

<img width="765" height="197" alt="image" src="https://github.com/user-attachments/assets/beb824ff-f7d8-463f-9c8b-7a3ad3a5a00a" />


**2. `for`: menampilkan seluruh pesanan.** 

Perulangan menelusuri `ArrayList` dari pesanan pertama sampai terakhir, sehingga jumlah pesanan yang tampil menyesuaikan data yang ada:

<img width="812" height="272" alt="image" src="https://github.com/user-attachments/assets/85efc867-c346-4dfc-803f-6fac6accfcc6" />


**3. `while (true)`: mengulang permintaan input sampai valid.** 

Pada `LayananValidator`, program terus meminta input ulang sampai pengguna memasukkan data yang benar. Perulangan baru berhenti saat `return` dijalankan:

<img width="675" height="231" alt="image" src="https://github.com/user-attachments/assets/c0d1bbe1-72d3-45f6-a3e5-8cfba375b4c0" />

---

## 8. Dokumentasi Program

### 1. Menu Utama
<img height="150" alt="image" src="https://github.com/user-attachments/assets/4c24f455-d892-45f6-96bf-678f1d85e0e2" />

### 2. Pilihan 1, Menambahkan Data Pemesanan Klien atau Pelanggan Baru
<img height="500" alt="image" src="https://github.com/user-attachments/assets/0e49f793-0e9a-4ec5-acee-07fe9aee57c4" />

### 3. Pilihan 2, Melihat Semua Daftar Pemesanan
<img height="400" alt="image" src="https://github.com/user-attachments/assets/03af910a-65a4-4411-a442-2aaf67c3f6ae" />

### 4. Pilihan 3, Keluar dari Program
<img height="200" alt="image" src="https://github.com/user-attachments/assets/f69eeea1-b809-457f-957e-0f7966693bec" />

---

## 9. Validasi Input

Aturan validasi yang diterapkan:

| Input | Aturan |
|---|---|
| Pilihan menu, kategori, look, jumlah orang/sesi | Harus berupa angka bulat |
| Nomor HP | Hanya angka (boleh diawali `+`), panjang 10-15 digit |
| Tanggal pengerjaan | Format `tanggal/bulan/tahun` dan harus tanggal yang benar-benar ada di kalender (misalnya `31/02/2026` ditolak) |
| Retouch Kit dan Sanggul/Hairdo | Hanya menerima Ya/Tidak |

### 1. Menu Utama
<img height="300" alt="image" src="https://github.com/user-attachments/assets/764efb94-f7e0-49d3-949d-21e8455e5e3c" />

### 2. Input Nomor _Handphone_ Klien atau Pelanggan
<img height="300" alt="image" src="https://github.com/user-attachments/assets/6c7e487f-5dd7-442b-a59f-7d36ecb73a80" />

### 3. Input Tanggal Pengerjaan
<img height="300" alt="image" src="https://github.com/user-attachments/assets/fdecadcd-9cbe-41c9-8109-550b0f5b3234" />

### 4. Input Kategori Make Up
<img height="300" alt="image" src="https://github.com/user-attachments/assets/70955cb4-717d-451b-87f7-01462ccfe68f" />

