package com.example.hotelreservation.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelreservation.data.local.entity.HotelModel
import com.example.hotelreservation.databinding.ItemHotelBinding

class HotelAdapter(private val dataList: List<HotelModel>) :
    ListAdapter<HotelModel, HotelAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHotelBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
        val item = getItem(position)
        holder.bind(item)
    }


    class ViewHolder(private val binding: ItemHotelBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hotelModel: HotelModel) {
            binding.apply {
                tvName.text = hotelModel.name
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<HotelModel>() {
        override fun areItemsTheSame(oldItem: HotelModel, newItem: HotelModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: HotelModel, newItem: HotelModel): Boolean {
            return oldItem.id == newItem.id
        }
    }
}