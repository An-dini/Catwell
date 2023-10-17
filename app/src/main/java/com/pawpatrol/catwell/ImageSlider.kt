package com.pawpatrol.catwell

//import android.os.Build
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.text.Html
//import android.widget.TextView
//import androidx.core.content.ContextCompat
//import androidx.viewpager2.widget.ViewPager2
//import com.pawpatrol.catwell.adapter.ImageSliderAdapter
//import com.pawpatrol.catwell.databinding.ActivityImageSliderBinding
//
//class ImageSlider : AppCompatActivity() {
//
//    private lateinit var binding: ActivityImageSliderBinding
//    private lateinit var adapter: ImageSliderAdapter
//    private val list = ArrayList<SliderData>()
//    private lateinit var dots: ArrayList<TextView>
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityImageSliderBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        list.add(
//            SliderData(
//                "https://media.istockphoto.com/id/1340809493/id/vektor/spanduk-perawatan-hewan-peliharaan-barang-barang-perawatan-kucing-dan-mainan.jpg?s=1024x1024&w=is&k=20&c=8hlRn-OHu2i4CFH1QeVqt9pljfJrdzSkF0mIDSQU2P0="
//            )
//        )
//
//        list.add(
//            SliderData(
//                "https://animation.binus.ac.id/files/2014/08/kuc1.jpg"
//            )
//        )
//
//        list.add(
//            SliderData(
//                "https://marketplace.canva.com/EAFuGjUykfw/1/0/800w/canva-jingga-ilustrasi-pecinta-binatang-facebook-cover-UI1oB_iJvJI.jpg"
//            )
//        )
//
//        list.add(
//            SliderData(
//                "https://cdn.vectorstock.com/i/1000x1000/15/04/pet-care-grooming-banner-vector-27931504.webp"
//            )
//        )
//
//        adapter = ImageSliderAdapter(list)
//        binding.viewPager.adapter = adapter
//        dots = ArrayList()
//        setIndicator()
//
//        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//                selectedDot(position)
//                super.onPageSelected(position)
//            }
//        })
//    }
//
//    private fun selectedDot(position: Int) {
//        for(i in 0 until list.size){
//            if(i == position)
//                dots[i].setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_primary))
//            else
//                dots[i].setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_secondary))
//
//        }
//
//    }
//
//    private fun setIndicator() {
//        for(i in 0 until list.size){
//            dots.add(TextView(this))
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
//            } else {
//                dots[i].text = Html.fromHtml("&#9679")
//            }
//            dots[i].textSize = 16f
//            binding.dotsIndicator.addView(dots[i])
//        }
//    }
//}
