package com.pawpatrol.catwell.data

data class PaymentMethodModel(
    val logoResource: Int,
    val mitraName: String,
    var isVisible: Boolean = true
)

