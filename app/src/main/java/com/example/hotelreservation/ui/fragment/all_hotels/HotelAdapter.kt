package com.example.hotelreservation.ui.fragment.all_hotels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelreservation.OnItemClick
import com.example.hotelreservation.data.local.entity.HotelModel
import com.example.hotelreservation.databinding.ItemHotelBinding
import com.example.hotelreservation.loadImage

class HotelAdapter( private val onClick: OnItemClick) :
    ListAdapter<HotelModel, HotelAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHotelBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClick.onClick(item)
        }
    }


    class ViewHolder(private val binding: ItemHotelBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hotelModel: HotelModel) {
            binding.apply {
                tvName.text = hotelModel.name
                imgHotel.loadImage(hotelModel.image)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<HotelModel>() {
        override fun areItemsTheSame(oldItem: HotelModel, newItem: HotelModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HotelModel, newItem: HotelModel): Boolean {
            return oldItem == newItem
        }
    }
}