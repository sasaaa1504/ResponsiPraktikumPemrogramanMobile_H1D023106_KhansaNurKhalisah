package com.example.responsimobile1h1d023106.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.responsimobile1h1d023106.data.model.Player // Import model Player
import com.example.responsimobile1h1d023106.databinding.ItemPlayerBinding // Import ViewBinding

// Adapter ini menerima:
// 1. List awal pemain (bisa kosong)
// 2. Fungsi 'lambda' yang akan dipanggil saat item diklik, membawa data Player yang diklik
class PlayerAdapter(
    private var players: List<Player>,
    private val onPlayerClicked: (Player) -> Unit // Listener untuk klik (P4)
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    // ViewHolder: Memegang referensi ke view di item_player.xml
    inner class PlayerViewHolder(val binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root)

    // Membuat ViewHolder baru saat dibutuhkan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        // Inflate (buat) layout item_player.xml menggunakan ViewBinding
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    // Mendapatkan jumlah total pemain
    override fun getItemCount() = players.size

    // Menghubungkan data pemain ke ViewHolder (tampilan) di posisi tertentu
    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position] // Ambil data pemain di posisi ini

        // Masukkan data ke TextViews
        holder.binding.tvPlayerName.text = player.name ?: "Unknown Name"
        holder.binding.tvPlayerNationality.text = player.nationality ?: "Unknown Nationality"

        // === LOGIKA PEWARNAAN (Permintaan No. 6) ===
        val cardColorString = when (player.position) {
            "Goalkeeper" -> "#B8860B" // Kuning tua (DarkGoldenrod)
            "Defence"    -> "#000080" // Biru tua (Navy)
            "Midfield"   -> "#006400" // Hijau tua (DarkGreen)
            "Offence"    -> "#8B0000" // Merah tua (DarkRed)
            else         -> "#FFFFFF" // Putih (Default)
        }
        // Teks selalu putih, kecuali untuk Goalkeeper
        val textColor = if (player.position == "Goalkeeper") Color.BLACK else Color.WHITE
        val nationalityColor = if (player.position == "Goalkeeper") Color.DKGRAY else Color.LTGRAY


        holder.binding.cardPlayer.setCardBackgroundColor(Color.parseColor(cardColorString))
        holder.binding.tvPlayerName.setTextColor(textColor)
        holder.binding.tvPlayerNationality.setTextColor(nationalityColor)
        // =============================================

        // Atur listener klik pada seluruh item view (CardView)
        holder.itemView.setOnClickListener {
            onPlayerClicked(player) // Panggil lambda 'onPlayerClicked' dan kirim data 'player'
        }
    }

    // Fungsi untuk mengupdate data pemain di adapter (P3)
    fun updateData(newPlayers: List<Player>) {
        this.players = newPlayers
        notifyDataSetChanged() // Beritahu RecyclerView untuk refresh tampilan
    }
}