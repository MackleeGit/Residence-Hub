package com.example.residencehub.remote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.residencehub.remote.SupabaseClientProvider
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            try {
                val client = SupabaseInstance.client
                val response = client.postgrest["tenants"].select()
                println("✅ Supabase connection OK: ${response.body}")
            } catch (e: Exception) {
                e.printStackTrace()
                println("❌ Supabase connection failed: ${e.message}")
            }
        }

        setContent {
            // your normal UI content here
        }
    }
}
