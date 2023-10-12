package com.pawpatrol.catwell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.pawpatrol.catwell.databinding.HistoryConsultationDetailBinding

class HistoryConsultationDetailActivity : AppCompatActivity() {
    private lateinit var binding: HistoryConsultationDetailBinding
    private lateinit var btNewSchedule: Button
    private lateinit var btConsultationHistory: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HistoryConsultationDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btNewSchedule = findViewById(R.id.bt_newSchedule)
        btConsultationHistory = findViewById(R.id.bt_consultationHistory)

        val transactionID = intent.getIntExtra(TRANSACTION_ID_EXTRA, -1)
        val transaction = transactionFromID(transactionID)

        if (transaction != null) {
            binding.cover.setImageResource(transaction.cover)
            binding.name.text = transaction.doctor
            binding.instance.text = transaction.instance
            binding.date.text = transaction.date
            binding.time.text = transaction.time
            binding.price.text = transaction.price
            binding.ratingBar.rating = transaction.rating
        }

        btNewSchedule.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        btConsultationHistory.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }

    private fun transactionFromID(transactionID: Int): Transaction?
    {
        for(transaction in transactionList)
        {
            if(transaction.id == transactionID)
                return transaction
        }
        return null
    }

}