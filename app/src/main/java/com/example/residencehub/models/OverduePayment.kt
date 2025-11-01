package com.example.residencehub.models

import kotlinx.serialization.Serializable

@Serializable
data class OverduePayment(
    val ovdpaymentid: Int,
    val overduepayid: Int,
    val tenantid: Int,
    val amountpaid: Double,
    val paymentdate: String
)
