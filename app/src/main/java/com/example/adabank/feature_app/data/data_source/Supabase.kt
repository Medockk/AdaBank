package com.example.adabank.feature_app.data.data_source

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object Supabase {

    val client = createSupabaseClient(
        supabaseUrl = "https://uftclonibwagnofwkbtp.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InVmdGNsb25pYndhZ25vZndrYnRwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDI0NjMxNTUsImV4cCI6MjA1ODAzOTE1NX0.Svf2If0KUdeEaPu6Z_YXZZgVf13dsXK2A78v0jSqWb0"
    ){
        install(Postgrest)
        install(Storage)
        install(Auth)
    }
}