package com.example.infopswvet.Data


var pswlist = mutableListOf<VetData>()

val PSW_ID_EXTRA = "pswExtra"
data class PswData(
    val image: Int,
    val namapsw: String,
    val deskripsi: String,
)
