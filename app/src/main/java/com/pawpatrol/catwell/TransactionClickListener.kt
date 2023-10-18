package com.pawpatrol.catwell

import com.pawpatrol.catwell.data.Transaction

interface TransactionClickListener {
    fun onClick(transaction: Transaction)

}
