package com.pawpatrol.catwell.data

var vetList = mutableListOf<VetData>()

val VET_ID_EXTRA = "vetExtra"
data class VetData(
    val image: Int,
    val namavet: String,
    val deskripsi: String,

)
