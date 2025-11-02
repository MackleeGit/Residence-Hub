package com.example.residencehub.repositories

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.user.UserSession
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository(private val supabase: SupabaseClient) {


    suspend fun login(email: String, password: String): UserSession? = withContext(Dispatchers.IO) {
        try {
            val result = supabase.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }

            result.userSession
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    // Register a new user
    suspend fun register(email: String, password: String): Boolean = withContext(Dispatchers.IO) {
        try {
            supabase.auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    // Get current session (already logged in)
    suspend fun getSession(): UserSession? = withContext(Dispatchers.IO) {
        try {
            supabase.auth.currentSessionOrNull() // this is the correct method
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    // Logout
    suspend fun logout() = withContext(Dispatchers.IO) {
        try {
            supabase.auth.signOut()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
