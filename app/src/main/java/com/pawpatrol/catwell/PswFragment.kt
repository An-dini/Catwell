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
            val intent = Intent(requireContext(), Detail_Psw::class.java)
            intent.putExtra(PSW_ID_EXTRA, pswData.id)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }


    private fun generatePswDataList(): List<PswData> {
        val pswDataList = mutableListOf<PswData>()

        pswDataList.add(PswData(R.drawable.pswbontang, "Puskeswan Bontang", "Alamat: Kota Bontang, Kalimantan Timur 75321, Kec. Bontang Bar., Gn. Telihan, Jl. Letjen S. Parman gang banjar No.rt 29"))
        pswDataList.add(PswData(R.drawable.pswragunan, "Puskeswan Ragunan", "Alamat:Jl. Harsono RM No.28, RT.9/RW.4, Ragunan, Kec. Ps. Minggu, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12550, Indonesia"))
        pswDataList.add(PswData(R.drawable.pswmagelang, "Puskeswan Magelang", "Alamat: Jl. Pahlawan No.8, Magelang, Magelang Tengah, Magelang City, Central Java 56116"))

        return pswDataList
    }
}