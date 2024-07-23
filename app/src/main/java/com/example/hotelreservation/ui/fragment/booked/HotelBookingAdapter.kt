package com.example.hotelreservation.ui.fragment.booked

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelreservation.ui.interfaces.OnItemClick
import com.example.hotelreservation.data.local.entity.HotelModel
import com.example.hotelreservation.databinding.ItemBookingBinding
import com.example.hotelreservation.ext.loadImage

class HotelBookingAdapter( private val onClick: OnItemClick) :
    ListAdapter<HotelModel, HotelBookingAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBookingBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClick.onClick(item)
        }
    }


    class ViewHolder(private val binding: ItemBookingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hotelModel: HotelModel) {
            binding.apply {
                tvName.text = hotelModel.name
                imgHotel.loadImage(hotelModel.image)
                tvAdress.text = hotelModel.address
                binding.quantityRoom.text = hotelModel.rooms.toString()
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