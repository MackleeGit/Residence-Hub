package com.example.residencehub.models

import kotlinx.serialization.Serializable

@Serializable
data class Message(
        val id: Int,
        val senderId: Int,
        val recipientId: Int,
        val content: String,
        val dateAdded: String,
        val isPayment: Boolean = false,
        val overduePayId: Int? = null,
        val currentMonthDueId: Int? = null,
        val messageType: String = "text",
        val isRead: Boolean = false
)
