package com.example.residencehub.models

import kotlinx.serialization.Serializable

@Serializable
data class CurrentMonthDue(
    val currentMonthDueId: Int,
    val tenantId: Int,
    val waterBill: Double,
    val garbageBill: Double,
    val rent: Double,
    val amountPaid: Double,
    val monthDue: String,
    val dueDate: String,
    val status: String = "Unpaid"
) {
    val totalDue: Double
        get() = waterBill + garbageBill + rent - amountPaid
}
