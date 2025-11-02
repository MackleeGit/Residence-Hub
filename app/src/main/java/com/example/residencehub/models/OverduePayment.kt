package com.example.residencehub.models

import kotlinx.serialization.Serializable

@Serializable
data class OverduePaymentRecord(
    val ovdPaymentId: Int,
    val overduePayId: Int,
    val tenantId: Int,
    val amountPaid: Double,
    val paymentDate: String,
    val paymentMethod: String = "Cash",
    val referenceNumber: String? = null
)
