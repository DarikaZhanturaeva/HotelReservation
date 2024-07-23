package com.example.hotelreservation.ui.fragment.hotel_detail

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hotelreservation.databinding.FragmentBookingDetailBinding
import com.example.hotelreservation.ui.base.BaseFragment
import androidx.navigation.fragment.navArgs
import com.example.hotelreservation.data.local.entity.HotelModel
import com.example.hotelreservation.ext.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.hotelreservation.ui.fragment.booked.HotelBookingViewModel

class BookingDetailFragment :
    BaseFragment<FragmentBookingDetailBinding>(FragmentBookingDetailBinding::inflate) {

    private val args: BookingDetailFragmentArgs by navArgs()
    private val viewModel: HotelBookingViewModel by viewModel()

    override fun setupViews() {
        super.setupViews()
        getData()
    }

    override fun initClickListeners() {
        initClickBook()
        initClickBack()
    }


    private fun initClickBook() {
        binding.btnBook.setOnClickListener {

            val roomQuantityString = binding.etQuantityRoom.text.toString()
            if (roomQuantityString.isEmpty()) {
                binding.etQuantityRoom.error = "Введите количество комнат"
                return@setOnClickListener
            }

            val roomQuantity = binding.etQuantityRoom.text.toString().toInt()
            val hotel = HotelModel(
                id = args.hotelId,
                name = args.hotelName,
                image = args.hotelImage,
                address = args.hotelAddress,
                rooms = roomQuantity
            )
            viewModel.updateHotel(hotel)
            findNavController().navigate(
                BookingDetailFragmentDirections.actionBookingDetailFragmentToHotelBookingFragment(
                    args.hotelId,
                    args.hotelName,
                    args.hotelImage,
                    args.hotelAddress
                )
            )
        }
    }

    private fun initClickBack() {
        binding.btnBack.setOnClickListener {
            viewModel.getHotelById(args.hotelId).observe(viewLifecycleOwner, Observer { hotel ->
                hotel?.let {
                    viewModel.deleteHotel(it)
                    findNavController().navigateUp()
                }
            })
        }
    }

    private fun getData() {
        binding.tvName.text = args.hotelName
        binding.imgHotel.loadImage(args.hotelImage)
        binding.tvAdress.text = args.hotelAddress
    }
}