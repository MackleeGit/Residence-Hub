package com.example.residencehub.repositories

import com.residencehub.data.remote.SupabaseClientProvider
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.user.UserSession
import io.github.jan.supabase.gotrue.user.UserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository {

    private val supabase = SupabaseClientProvider.client

    suspend fun signUp(email: String, password: String): UserSession? = withContext(Dispatchers.IO) {
        val session = supabase.gotrue.signUpWith(
            io.github.jan.supabase.gotrue.providers.Email,
        ) {
            this.email = email
            this.password = password
        }
        session
    }

    suspend fun signIn(email: String, password: String): UserSession? = withContext(Dispatchers.IO) {
        val session = supabase.gotrue.signInWith(
            io.github.jan.supabase.gotrue.providers.Email,
        ) {
            this.email = email
            this.password = password
        }
        session
    }

    suspend fun getCurrentUser(): UserInfo? = withContext(Dispatchers.IO) {
        supabase.gotrue.retrieveUserForCurrentSession()
    }

    suspend fun signOut() = withContext(Dispatchers.IO) {
        supabase.gotrue.logout()
    }
}
