package com.example.hotelreservation.ui.fragment.all_hotels

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hotelreservation.ui.interfaces.OnItemClick
import com.example.hotelreservation.data.local.entity.HotelModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.hotelreservation.databinding.FragmentHotelsBinding
import com.example.hotelreservation.ui.base.BaseFragment

class HotelsFragment : BaseFragment<FragmentHotelsBinding>(FragmentHotelsBinding::inflate),
    OnItemClick {

    private lateinit var hotelAdapter: HotelAdapter
    private val viewModel: HotelViewModel by viewModel()

    override fun setupViews() {
        setupRecyclerView()
    }
    override fun setupObservers() {
        super.setupObservers()
        viewModel.getAllHotels().observe(viewLifecycleOwner, Observer { hotels ->
                Log.d("HotelsFragment", "Number of hotels: ${hotels}")
                hotelAdapter.submitList(hotels)
        })
    }

    private fun setupRecyclerView() {

        hotelAdapter = HotelAdapter(this)

        val hotels = listOf(
            HotelModel(
                1,
                "Damas International Hotel",
                "https://cdn.worldota.net/t/1200x616/extranet/35/18/3518abb02db860639cc9825a513131b314f22fc5.JPEG",
                "Ул.Жумабек 107"
            ),
            HotelModel(
                2,
                "Jannat",
                "https://tophotels.ru/icache/hotel_photos/252/2854/62080/2379666_740x550.jpg",
                "ул.Аалы Токомбаева, 21/2"
            ),
            HotelModel(
                3,
                "NOVOTEL",
                "https://www.ahstatic.com/photos/a145_ho_00_p_1024x768.jpg",
                "проспект Манаса, 16"
            ),
            HotelModel(
                4,
                "Hyatt Regency",
                "https://assets.hyatt.com/content/dam/hyatt/hyattdam/images/2017/09/01/1205/Hyatt-Regency-Bishkek-P068-Exterior.jpg/Hyatt-Regency-Bishkek-P068-Exterior.16x9.jpg",
                "ул.Абдрахманова, 191"
            ),
            HotelModel(
                5,
                "Sofia International Hotel",
                "https://www.webbishkek.com/data/Photos/OriginalPhoto/14700/1470093/1470093797/photo-bishkek-1.JPEG",
                "ул.Медерова,117"
            ),
            HotelModel(
                6,
                "Sheraton",
                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1a/08/3c/d6/sheraton-bishkek.jpg?w=700&h=-1&s=1",
                "148B Kievskaya Str"
            ),
            HotelModel(
                7,
                "Plaza Hotel",
                "https://cf.bstatic.com/xdata/images/hotel/max500/43006880.jpg?k=49f34a0a1ee8288507d81e2468a6e37563552d55202cc522edfdaacfaec3cac9&o=&hp=1",
                "ул.Тоголок Молдо, 52"
            ),
            HotelModel(
                8,
                "Orion Hotel",
                "https://www.orionbishkek.com/uploads/bcbc96e7bc49d78a2f98c1863e2c96e62c3db8cb.jpeg?method=fit&width=576&height=576",
                "Бульвар Эркиндик 21"
            ),
            HotelModel(
                9,
                "Ambassador",
                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/10/6b/4d/5d/caption.jpg?w=700&h=-1&s=1",
                "ул.Орозбекова 32"
            ),
            HotelModel(
                10,
                "Bagu Hotel",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/151165255.jpg?k=bfd8d635602c3fe42fb93af40093eda9e71edbdf99a306d07e9db05dc3e95d9b&o=&hp=1",
                "ул.Уметалиева, 98"
            ),
        )

        hotels.forEach {
            Log.d("HotelsFragment", "Inserting hotel: ${it.name}")
            viewModel.insertHotel(it)
        }
        binding.rvHotels.adapter = hotelAdapter
    }

    override fun onClick(hotelModel: HotelModel) {
        val action = HotelsFragmentDirections.actionHotelsFragmentToBookingDetailFragment(
            hotelModel.id,
            hotelModel.name,
            hotelModel.image,
            hotelModel.address
        )
        findNavController().navigate(action)
    }
}