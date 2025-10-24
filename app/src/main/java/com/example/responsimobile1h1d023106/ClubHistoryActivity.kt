package com.example.responsimobile1h1d023106

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.responsimobile1h1d023106.databinding.ActivityClubHistoryBinding


class ClubHistoryActivity : AppCompatActivity() {


    private lateinit var binding: ActivityClubHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityClubHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.title = "Club History"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}