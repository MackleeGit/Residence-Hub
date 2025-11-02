package com.example.residencehub.repositories

import com.example.residencehub.models.Message
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.realtime.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext

class MessageRepository(private val supabase: SupabaseClient) {


    suspend fun getMessages(tenantId: Int): List<Message> = withContext(Dispatchers.IO) {
        try {
            supabase.from("messages")
                .select {

                    filter { eq("recipient", tenantId) }
                }
                .decodeList<Message>()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }


    suspend fun sendMessage(
        recipientId: Int,
        content: String,
        isPayment: Boolean = false,
        overdueInvoiceId: Int? = null,
        standardInvoiceId: Int? = null
    ): Boolean = withContext(Dispatchers.IO) {
        try {
            supabase.from("messages").insert(
                mapOf(
                    "recipient" to recipientId, // DB column
                    "content" to content,
                    "ispayment" to isPayment,
                    "overdueinvoiceid" to overdueInvoiceId,
                    "standardinvoiceid" to standardInvoiceId
                )
            )
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }


    suspend fun subscribeToMessages(
        tenantId: Int,
        onNewMessage: (Message) -> Unit
    ) {
        val channel = supabase.channel("messages-realtime")

        channel.postgresChangeFlow<PostgresAction.Insert>(schema = "public") {
            table = "messages"
        }.collect { change ->
            val newMsg = change.decodeRecord<Message>()
            if (newMsg.recipientId == tenantId) {
                onNewMessage(newMsg)
            }
        }

        channel.subscribe()
    }
}
