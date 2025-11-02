package com.example.residencehub.repositories

import com.example.residencehub.models.Tenant
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.decodeList
import io.github.jan.supabase.postgrest.query.decodeSingle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TenantRepository(private val supabase: SupabaseClient) {

    suspend fun getTenantById(tenantId: Int): Tenant? = withContext(Dispatchers.IO) {
        try {
            supabase.postgrest
                .from("tenants")
                .select()
                .eq("tenantid", tenantId)
                .limit(1)
                .decodeSingle<Tenant>()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getAllTenants(): List<Tenant> = withContext(Dispatchers.IO) {
        try {
            supabase.postgrest
                .from("tenants")
                .select()
                .decodeList<Tenant>()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    suspend fun updateTenantPhone(tenantId: Int, phone: String): Boolean = withContext(Dispatchers.IO) {
        try {
            supabase.postgrest
                .from("tenants")
                .update { set("phone", phone) }
                .eq("tenantid", tenantId)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
