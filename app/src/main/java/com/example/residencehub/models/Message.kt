package com.example.residencehub.models



import kotlinx.serialization.Serializable

@Serializable
data class Message(
        val id: Int,
        val recipient: Int,
        val content: String,
        val date_added: String,
        val ispayment: Boolean = false,
        val overduepayid: Int? = null,
        val currentmonthdueid: Int? = null
)
