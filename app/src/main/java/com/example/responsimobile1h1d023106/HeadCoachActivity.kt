package com.example.responsimobile1h1d023106

import android.os.Bundle
import android.view.View // Untuk mengatur visibility
import androidx.activity.viewModels // Untuk 'by viewModels()'
import androidx.appcompat.app.AppCompatActivity
// Import ViewBinding untuk layout ini
import com.example.responsimobile1h1d023106.databinding.ActivityHeadCoachBinding
// Import ViewModel kita
import com.example.responsimobile1h1d023106.ui.viewmodel.TeamViewModel

class HeadCoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeadCoachBinding

    private val viewModel: TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeadCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.title = "Head Coach"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        observeViewModel()


        viewModel.fetchData()
    }


    private fun observeViewModel() {

        viewModel.teamData.observe(this) { teamResponse ->

            if (teamResponse != null) {

                teamResponse.coach?.let { coach ->

                    binding.tvCoachName.text = coach.name ?: "N/A"
                    binding.tvCoachDob.text = coach.dateOfBirth ?: "N/A"
                    binding.tvCoachNationality.text = coach.nationality ?: "N/A"
                }
            } else {

                binding.tvCoachName.text = "Failed to load data"
                binding.tvCoachDob.visibility = View.GONE
                binding.tvCoachNationality.visibility = View.GONE
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}