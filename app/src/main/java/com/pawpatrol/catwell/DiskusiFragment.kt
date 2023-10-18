package com.pawpatrol.catwell

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.pawpatrol.catwell.databinding.FragmentBerandaBinding
import com.pawpatrol.catwell.databinding.FragmentDiskusiBinding

class DiskusiFragment : Fragment() {

    private lateinit var binding: FragmentDiskusiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDiskusiBinding.inflate(inflater, container, false)

        binding.ivText2.setOnClickListener {
            startActivity(Intent(requireContext(), Reply_Diskusi::class.java))
        }

        return binding.root
    }


}