package com.example.residencehub.models

import kotlinx.serialization.Serializable

@Serializable
data class StandardPayment(
    val paymentId: Int,
    val tenantId: Int,
    val currentMonthDueId: Int,
    val amountPaid: Double,
    val paymentDate: String,
    val paymentMethod: String = "Cash",
    val referenceNumber: String? = null
)
