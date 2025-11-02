package com.example.residencehub.repository

import com.example.residencehub.models.CurrentMonthDue
import com.example.residencehub.models.OverduePayment
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from

class InvoiceRepository(private val client: SupabaseClient) {


    suspend fun getStandardInvoices(tenantId: Int): List<CurrentMonthDue> {
        return try {
            client.from("standardinvoices")
                .select {
                    filter {
                        eq("tenantid", tenantId)
                    }
                }
                .decodeList<CurrentMonthDue>()
        } catch (e: Exception) {
            emptyList()
        }
    }


    suspend fun getOverdueInvoices(tenantId: Int): List<OverduePayment> {
        return try {
            client.from("overdueinvoices")
                .select {
                    filter {
                        eq("tenantid", tenantId)
                    }
                }
                .decodeList<OverduePayment>()
        } catch (e: Exception) {
            emptyList()
        }
    }


    suspend fun getStandardInvoiceById(invoiceId: Int): CurrentMonthDue? {
        return try {
            client.from("standardinvoices")
                .select {
                    filter {
                        eq("standardinvoiceid", invoiceId)
                    }
                    limit(1)
                }
                .decodeSingleOrNull<CurrentMonthDue>()
        } catch (e: Exception) {
            null
        }
    }


    suspend fun getOverdueInvoiceById(invoiceId: Int): OverduePayment? {
        return try {
            client.from("overdueinvoices")
                .select {
                    filter {
                        eq("overdueinvoiceid", invoiceId)
                    }
                    limit(1)
                }
                .decodeSingleOrNull<OverduePayment>()
        } catch (e: Exception) {
            null
        }
    }


    suspend fun markStandardInvoiceAsPaid(invoiceId: Int, amountPaid: Double): Boolean {
        return try {
            client.from("standardinvoices")
                .update(
                    mapOf("amountpaid" to amountPaid)
                ) {
                    filter {
                        eq("standardinvoiceid", invoiceId)
                    }
                }
            true
        } catch (e: Exception) {
            false
        }
    }


    suspend fun markOverdueInvoiceAsPaid(invoiceId: Int, amountPaid: Double): Boolean {
        return try {
            client.from("overdueinvoices")
                .update(
                    mapOf("amountpaid" to amountPaid)
                ) {
                    filter {
                        eq("overdueinvoiceid", invoiceId)
                    }
                }
            true
        } catch (e: Exception) {
            false
        }
    }
}
