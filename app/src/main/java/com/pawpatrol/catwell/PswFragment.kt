package com.pawpatrol.catwell

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pawpatrol.catwell.adapter.PswAdapter
import com.pawpatrol.catwell.data.PSW_ID_EXTRA
import com.pawpatrol.catwell.data.PswData
import com.pawpatrol.catwell.data.VET_ID_EXTRA
import com.pawpatrol.catwell.data.VetData
import com.pawpatrol.catwell.databinding.FragmentPswBinding
import com.pawpatrol.catwell.databinding.FragmentVetBinding

class PswFragment : Fragment() {

    private lateinit var binding: FragmentPswBinding
    private lateinit var adapter: PswAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPswBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val pswDataList = generatePswDataList()
        adapter = PswAdapter(pswDataList) { pswData ->
            val intent = Intent(requireContext(), DoctorDetailActivity::class.java)
            intent.putExtra(PSW_ID_EXTRA, pswData.id)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }


    private fun generatePswDataList(): List<PswData> {
        val pswDataList = mutableListOf<PswData>()

        pswDataList.add(PswData(R.drawable.torovet, "Nama Dokter 1", "Deskripsi Dokter 1"))
        pswDataList.add(PswData(R.drawable.bvc, "Nama Dokter 2", "Deskripsi Dokter 2"))
        pswDataList.add(PswData(R.drawable.brunopetclinic, "Nama Dokter 3", "Deskripsi Dokter 3"))

        return pswDataList
    }
}