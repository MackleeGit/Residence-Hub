package com.example.residencehub

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.ktor.client.engine.okhttp.OkHttp



object SupabaseClientProvider {


    private const val SUPABASE_URL = "https://huaymbspbcghnzulahnv.supabase.co"
    private const val SUPABASE_ANON_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imh1YXltYnNwYmNnaG56dWxhaG52Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjE5NzE5MTgsImV4cCI6MjA3NzU0NzkxOH0.6Lvypesglnhqwy4R5tN4MExFpIKkVBGk65WnNwAHHWE"


    val client = createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
        install(Auth)
        httpEngine = OkHttp.create()
    }

}
