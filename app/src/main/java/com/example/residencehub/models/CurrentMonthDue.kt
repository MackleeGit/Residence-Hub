package com.example.residencehub.models



import kotlinx.serialization.Serializable

@Serializable
data class CurrentMonthDue(
    val currentmonthdueid: Int,
    val tenantid: Int,
    val waterbill: Double,
    val garbagebill: Double,
    val amountpaid: Double,
    val monthdue: String
)
