package com.pawpatrol.catwell

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.pawpatrol.catwell.adapter.ImageSliderAdapter
import com.pawpatrol.catwell.databinding.FragmentBerandaBinding

class BerandaFragment : Fragment() {

    private lateinit var binding: FragmentBerandaBinding
    private lateinit var adapter: ImageSliderAdapter
    private val list = ArrayList<SliderData>()
    private lateinit var dots: ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar

        binding = FragmentBerandaBinding.inflate(inflater, container, false)



        list.add(
            SliderData(
                "https://media.istockphoto.com/id/1340809493/id/vektor/spanduk-perawatan-hewan-peliharaan-barang-barang-perawatan-kucing-dan-mainan.jpg?s=1024x1024&w=is&k=20&c=8hlRn-OHu2i4CFH1QeVqt9pljfJrdzSkF0mIDSQU2P0="
            )
        )

        list.add(
            SliderData(
                "https://animation.binus.ac.id/files/2014/08/kuc1.jpg"
            )
        )

        list.add(
            SliderData(
                "https://marketplace.canva.com/EAFuGjUykfw/1/0/800w/canva-jingga-ilustrasi-pecinta-binatang-facebook-cover-UI1oB_iJvJI.jpg"
            )
        )

        list.add(
            SliderData(
                "https://cdn.vectorstock.com/i/1000x1000/15/04/pet-care-grooming-banner-vector-27931504.webp"
            )
        )

        adapter = ImageSliderAdapter(list)
        binding.viewPager.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })


//        Artikel

        binding.article1.setOnClickListener {
            startActivity(Intent(requireContext(), DetailArtikel::class.java))
        }

        binding.article2.setOnClickListener {
            startActivity(Intent(requireContext(), DetailArtikel::class.java))
        }

        binding.article3.setOnClickListener {
            startActivity(Intent(requireContext(), DetailArtikel::class.java))
        }

        binding.article4.setOnClickListener {
            startActivity(Intent(requireContext(), DetailArtikel::class.java))
        }

        binding.article5.setOnClickListener {
            startActivity(Intent(requireContext(), DetailArtikel::class.java))
        }

        binding.article6.setOnClickListener {
            startActivity(Intent(requireContext(), DetailArtikel::class.java))
        }

        binding.article7.setOnClickListener {
            startActivity(Intent(requireContext(), DetailArtikel::class.java))
        }


//        Produk

        binding.produk1.setOnClickListener {
            val uri = Uri.parse("https://shopee.co.id/product/326441654/6659182921") // Gantilah URL dengan URL produk Tokopedia yang sesuai
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.produk2.setOnClickListener {
            val uri = Uri.parse("https://shopee.co.id/product/75911202/1320846879") // Gantilah URL dengan URL produk Tokopedia yang sesuai
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.produk3.setOnClickListener {
            val uri = Uri.parse("https://shopee.co.id/product/53852489/16165863544") // Gantilah URL dengan URL produk Tokopedia yang sesuai
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.produk4.setOnClickListener {
            val uri = Uri.parse("https://shopee.co.id/product/90470305/2173970068") // Gantilah URL dengan URL produk Tokopedia yang sesuai
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        return binding.root
    }

    private fun selectedDot(position: Int) {
        for(i in 0 until list.size){
            if(i == position)
                dots[i].setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_orange_dark))
            else
                dots[i].setTextColor(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))

        }

    }

    private fun setIndicator() {
        for(i in 0 until list.size){
            dots.add(TextView(requireContext()))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
            } else {
                dots[i].text = Html.fromHtml("&#9679")
            }
            dots[i].textSize = 16f
            binding.dotsIndicator.addView(dots[i])
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity).supportActionBar?.apply {

            setDisplayShowCustomEnabled(true)
            setLogo(R.drawable.img_2)
            setDisplayUseLogoEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_notifikasi -> {
                startActivity(Intent(requireContext(), notifikasi::class.java)) //intent
                true
            }
            R.id.action_bookmark -> {
                startActivity(Intent(requireContext(), Bookmark::class.java))
                true
            }
            R.id.action_profile -> {
                startActivity(Intent(requireContext(), Profile::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
