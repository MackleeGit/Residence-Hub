package com.example.residencehub.repositories

import com.example.residencehub.models.CommunityPost
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CommunityRepository(private val supabase: SupabaseClient) {


    suspend fun getCommunityPosts(): List<CommunityPost> = withContext(Dispatchers.IO) {
        try {
            supabase.from("community_posts")
                .select()
                .decodeList<CommunityPost>()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    /**
     * (Future) Add a new community post (caretaker/admin side)
     */
    suspend fun addPost(tenantId: Int, title: String, content: String): Boolean = withContext(Dispatchers.IO) {
        try {
            supabase.from("community_posts").insert(
                mapOf(
                    "tenantid" to tenantId,
                    "title" to title,
                    "content" to content
                )
            )
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
