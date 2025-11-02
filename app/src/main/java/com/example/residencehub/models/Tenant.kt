package com.example.residencehub.models

import kotlinx.serialization.Serializable

@Serializable
data class Tenant(
    val tenantId: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val rent: Double,
    val phone: String,
    val house: String,
    val leaseStartDate: String? = null,
    val leaseEndDate: String? = null,
    val caretakerId: Int? = null,
    val profileImageUrl: String? = null
) {
    val fullName: String
        get() = "$firstName $lastName"
}
