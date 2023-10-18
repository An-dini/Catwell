package com.pawpatrol.catwell

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import com.pawpatrol.catwell.adapter.VetAdapter
//import com.example.infopswvet.Data.VetData
import com.pawpatrol.catwell.data.VetData
import java.util.ArrayList

class VetFragment : Fragment() {

    private lateinit var adapter: VetAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var vetdata: List<VetData>

    lateinit var image: List<Int>
    lateinit var namavet: List<String>
    lateinit var deskripsi: List<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vet, container, false)
    }
    private fun dataInitialize(){
        vetdata = listOf<VetData>()
        image = listOf(
            R.drawable.torovet,
            R.drawable.bvc,
            R.drawable.brunopetclinic,
        )
//        namavet = listOf(
//            getString(R.string.lorem_ipsum)
//        )
    }

}