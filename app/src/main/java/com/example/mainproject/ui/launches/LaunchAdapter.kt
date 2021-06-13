package com.example.mainproject.ui.launches

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mainproject.data.network.models.SpaceXLaunch
import com.example.mainproject.databinding.ItemLaunchBinding

class LaunchAdapter(val listener: ItemListener) : RecyclerView.Adapter<LaunchAdapter.LaunchViewHolder>() {

    var data = listOf<SpaceXLaunch>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val binding = ItemLaunchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return LaunchViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.onBind()
    }

    inner class LaunchViewHolder(private val binding: ItemLaunchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            binding.launch = data[adapterPosition]

            binding.btnWikipedia.setOnClickListener {
                listener.onClickWikipedia(data[adapterPosition])
            }

            binding.btnArticle.setOnClickListener {
                listener.onClickArticle(data[adapterPosition])
            }
        }
    }

    fun updateData(list: List<SpaceXLaunch>) {
        data = list
        notifyDataSetChanged()
    }

}