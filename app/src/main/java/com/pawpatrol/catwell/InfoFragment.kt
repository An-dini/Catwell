package com.pawpatrol.catwell

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.pawpatrol.catwell.databinding.ActivityInfoVetPswBinding

class InfoFragment : Fragment() {

    private lateinit var binding: ActivityInfoVetPswBinding
    private lateinit var imgbtn1: ImageButton
    private lateinit var imgbtn2: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityInfoVetPswBinding.inflate(inflater, container, false)
        val view = binding.root

        imgbtn1 = binding.imgEvn1
        imgbtn2 = binding.imgEvn2

        imgbtn1.setOnClickListener {
            val intent = Intent(requireActivity(), Detail_Event::class.java)
            startActivity(intent)
        }
        imgbtn2.setOnClickListener {
            val intent = Intent(requireActivity(), Detail_Event::class.java)
            startActivity(intent)
        }

        if (savedInstanceState == null) {
            replaceFragment(VetFragment())
        }

        binding.btnVet.setOnClickListener { replaceFragment(VetFragment()) }
        binding.btnPsw.setOnClickListener { replaceFragment(PswFragment()) }

        return view
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_info, fragment)
        fragmentTransaction.commit()
    }
}