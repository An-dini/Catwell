package com.pawpatrol.catwell

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.pawpatrol.catwell.data.VET_ID_EXTRA
import com.pawpatrol.catwell.data.VetData
import com.pawpatrol.catwell.databinding.FragmentVetBinding

class VetFragment : Fragment() {

    private lateinit var binding: FragmentVetBinding
    private lateinit var adapter: VetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val vetDataList = generateVetDataList()
        adapter = VetAdapter(vetDataList) { vetData ->
            val intent = Intent(requireContext(), DoctorDetailActivity::class.java)
            intent.putExtra(VET_ID_EXTRA, vetData.id)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }


    private fun generateVetDataList(): List<VetData> {
        val vetDataList = mutableListOf<VetData>()

        vetDataList.add(VetData(R.drawable.torovet, "Nama Dokter 1", "Deskripsi Dokter 1"))
        vetDataList.add(VetData(R.drawable.bvc, "Nama Dokter 2", "Deskripsi Dokter 2"))
        vetDataList.add(VetData(R.drawable.brunopetclinic, "Nama Dokter 3", "Deskripsi Dokter 3"))

        return vetDataList
    }
}
