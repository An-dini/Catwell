package com.pawpatrol.catwell

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pawpatrol.catwell.data.Transaction
import com.pawpatrol.catwell.data.transactionList
import com.pawpatrol.catwell.databinding.FragmentTransactionHistoryDetailBinding



class TransactionHistoryDetail : Fragment() {
    private lateinit var binding: FragmentTransactionHistoryDetailBinding
    private lateinit var btNewSchedule: Button
    private lateinit var btConsultationHistory: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransactionHistoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btNewSchedule = binding.btNewSchedule
        btConsultationHistory = binding.btConsultationHistory
        var btBack: ImageView = binding.navbarUpper.btPrev

        val args: TransactionHistoryDetailArgs by navArgs()
        val transactionID = args.transactionId
        val transaction = getTransactionFromID(transactionID)
        if (transaction != null) {
            binding.cover.setImageResource(transaction.cover)
            binding.name.text = transaction.doctor
            binding.instance.text = transaction.instance
            binding.date.text = transaction.date
            binding.time.text = transaction.time
            binding.price.text = transaction.price.toString()
            binding.ratingBar.rating = transaction.rating
        }
        btNewSchedule.setOnClickListener {
            findNavController().navigate(R.id.doctorFragment)
        }
        btConsultationHistory.setOnClickListener {
            findNavController().navigate(R.id.transactionHistoryFragment)
        }

        btBack.setOnClickListener {
            getActivity()?.onBackPressed();
        }

    }
    private fun getTransactionFromID(transactionID: Int): Transaction? {
        for(transaction in transactionList)
        {
            if(transaction.id == transactionID)
                return transaction
        }
        return null
    }
}
