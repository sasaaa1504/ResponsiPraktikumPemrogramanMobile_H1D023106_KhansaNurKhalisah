package com.example.responsimobile1h1d023106.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.responsimobile1h1d023106.data.model.Player
import com.example.responsimobile1h1d023106.databinding.ItemPlayerBinding


class PlayerAdapter(
    private var players: List<Player>,
    private val onPlayerClicked: (Player) -> Unit
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {


    inner class PlayerViewHolder(val binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }


    override fun getItemCount() = players.size


    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]

        holder.binding.tvPlayerName.text = player.name ?: "Unknown Name"
        holder.binding.tvPlayerNationality.text = player.nationality ?: "Unknown Nationality"


        val cardColorString = when (player.position) {
            "Goalkeeper" -> "#B8860B"
            "Defence"    -> "#000080"
            "Midfield"   -> "#006400"
            "Offence"    -> "#8B0000"
            else         -> "#FFFFFF"
        }

        val textColor = if (player.position == "Goalkeeper") Color.BLACK else Color.WHITE
        val nationalityColor = if (player.position == "Goalkeeper") Color.DKGRAY else Color.LTGRAY


        holder.binding.cardPlayer.setCardBackgroundColor(Color.parseColor(cardColorString))
        holder.binding.tvPlayerName.setTextColor(textColor)
        holder.binding.tvPlayerNationality.setTextColor(nationalityColor)

        holder.itemView.setOnClickListener {
            onPlayerClicked(player)
        }
    }


    fun updateData(newPlayers: List<Player>) {
        this.players = newPlayers
        notifyDataSetChanged()
    }
}