package com.example.residencehub.models

import kotlinx.serialization.Serializable

@Serializable
data class OverduePayment(
    val overduePayId: Int,
    val tenantId: Int,
    val waterBill: Double,
    val garbageBill: Double,
    val rent: Double = 0.0,
    val amountPaidDelay: Double,
    val amountPaid: Double,
    val monthDue: String,
    val dateAdded: String,
    val status: String = "Overdue",
    val dueDate: String? = null
) {
    val totalDue: Double
        get() = waterBill + garbageBill + rent + amountPaidDelay - amountPaid
}
