package com.example.residencehub.models


import kotlinx.serialization.Serializable

@Serializable
data class Tenant(
    val tenantid: Int,
    val firstname: String,
    val lastname: String,
    val email: String,
    val rent: Double,
    val phone: String,
    val house: String
)
