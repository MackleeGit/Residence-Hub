package com.example.residencehub.models


import kotlinx.serialization.Serializable

@Serializable
data class OverduePayInstance(
    val overduepayid: Int,
    val tenantid: Int,
    val waterbill: Double,
    val garbagebill: Double,
    val amountpaiddelay: Double,
    val amountpaid: Double,
    val monthdue: String,
    val date_added: String
)
