package com.example.responsimobile1h1d023106

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsimobile1h1d023106.data.model.Player
import com.example.responsimobile1h1d023106.databinding.ActivityTeamSquadBinding
import com.example.responsimobile1h1d023106.ui.adapter.PlayerAdapter
import com.example.responsimobile1h1d023106.ui.fragment.PlayerDetailFragment
import com.example.responsimobile1h1d023106.ui.viewmodel.TeamViewModel

class TeamSquadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeamSquadBinding
    private val viewModel: TeamViewModel by viewModels()
    private lateinit var playerAdapter: PlayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamSquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Team Squad"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        setupRecyclerView()

        observeViewModel()

        viewModel.fetchData()
    }

    private fun setupRecyclerView() {

        playerAdapter = PlayerAdapter(emptyList()) { clickedPlayer ->

            showPlayerDetailFragment(clickedPlayer)
        }


        binding.recyclerViewSquad.apply {
            adapter = playerAdapter

            layoutManager = LinearLayoutManager(this@TeamSquadActivity)
        }
    }

    private fun observeViewModel() {

        viewModel.teamData.observe(this) { teamResponse ->

            val players = teamResponse?.squad ?: emptyList()

            playerAdapter.updateData(players)
        }
    }

    // Fungsi untuk menampilkan BottomSheetFragment (P4)
    private fun showPlayerDetailFragment(player: Player) {
        // Buat instance PlayerDetailFragment dan kirim data 'player'
        val fragment = PlayerDetailFragment(player)
        // Tampilkan fragment menggunakan FragmentManager
        fragment.show(supportFragmentManager, fragment.tag) // 'tag' bisa null atau string unik
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed() // Kembali ke halaman sebelumnya
        return true
    }
}