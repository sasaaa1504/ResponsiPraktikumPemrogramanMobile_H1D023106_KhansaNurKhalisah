# ⚽ Responsi Pemrograman Mobile – H1D023106  
### Toulouse FC App

## 👤 Identitas
- **Nama:** Khansa Nur Khalisah  
- **NIM:** H1D023106  
- **Shift Asal:** B
- **Shift Baru:** F

---

## 📱 Deskripsi Aplikasi
Aplikasi ini merupakan hasil dari **Responsi 1 Pemrograman Mobile**, yang menampilkan informasi lengkap mengenai klub sepak bola **Toulouse FC**.  
Pengguna dapat melihat profil klub, sejarah singkat, daftar pemain, serta pelatih tim secara interaktif.  

Seluruh data pemain dan pelatih diambil **langsung dari API**:
https://api.football-data.org/v4/teams/{id-klub}

yaml
Salin kode

Aplikasi dikembangkan menggunakan **Kotlin**, dan mengimplementasikan berbagai konsep yang telah dipelajari selama praktikum seperti fragment, viewmodel, adapter, dan integrasi API menggunakan Retrofit.

---

## 🧠 Alur Data (Dari API ke Tampilan)
1. **Pemanggilan Data (API Call)**  
   Menggunakan **Retrofit** untuk mengambil data dari endpoint `https://api.football-data.org/v4/teams/77` (ID klub Toulouse FC). Token API dimasukkan ke dalam header request.

2. **Pengolahan Data (Parsing JSON)**  
   Data JSON dari API diubah menjadi **model data Kotlin** seperti `Player` dan `Coach`.

3. **Penyimpanan Data**  
   ViewModel menyimpan data agar tidak hilang saat berpindah antar fragment.

4. **Penyajian di Layar**  
   - Fragment **Pelatih** menampilkan data pelatih dari API.  
   - Fragment **Pemain** menampilkan daftar pemain dengan **warna card sesuai posisi**:
     - 🟡 Goalkeeper – Kuning  
     - 🔵 Defender – Biru  
     - 🟢 Midfielder – Hijau  
     - 🔴 Forward – Merah  

---

## 🎬 Demo Aplikasi
## 🎬 Demo Aplikasi
## 🎬 Demo Aplikasi
[🎥 Tonton atau Unduh Video Demo](https://github.com/sasaaa1504/ResponsiPraktikumPemrogramanMobile_H1D023106_KhansaNurKhalisah/raw/main/demo.mp4)




---

## 💡 Teknologi yang Digunakan
- Kotlin  
- Retrofit  
- ViewModel & LiveData  
- RecyclerView  
- ViewBinding  
- Material Design Components  

---

## 🏆 Tentang Klub: Toulouse FC
**Toulouse Football Club** adalah klub sepak bola profesional asal **Toulouse, Prancis**, yang berdiri pada tahun 1970.  
Klub ini bermarkas di **Stadium de Toulouse** dan dikenal dengan warna ungu khasnya.  
Saat ini Toulouse FC berkompetisi di **Ligue 1** dan memiliki basis penggemar yang kuat di wilayah selatan Prancis.

---



### ✨ Dibuat dengan ❤️ oleh  
**Khansa Nur Khalisah – Informatika, Universitas Jenderal Soedirman**
