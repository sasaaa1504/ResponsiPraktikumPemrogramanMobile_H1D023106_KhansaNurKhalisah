package com.example.responsimobile1h1d023106

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
// Import ViewBinding untuk layout ini
import com.example.responsimobile1h1d023106.databinding.ActivityClubHistoryBinding


class ClubHistoryActivity : AppCompatActivity() {

    // Deklarasi ViewBinding
    private lateinit var binding: ActivityClubHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hubungkan layout XML ke kode Kotlin
        binding = ActivityClubHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root) // Tampilkan layoutnya

        // Tidak perlu kode tambahan karena teks sudah di XML
        // Anda bisa menambahkan judul di ActionBar jika mau:
        supportActionBar?.title = "Club History"
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Tombol kembali
    }

    // Fungsi agar tombol kembali di ActionBar berfungsi
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}