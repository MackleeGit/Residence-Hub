package com.example.residencehub.models

import kotlinx.serialization.Serializable

@Serializable
data class StandardPayment(
    val paymentid: Int,
    val tenantid: Int,
    val amountpaid: Double,
    val paymentdate: String
)
