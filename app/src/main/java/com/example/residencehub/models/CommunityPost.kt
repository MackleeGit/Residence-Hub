package com.example.residencehub.models

import kotlinx.serialization.Serializable

@Serializable
data class CommunityPost(
    val postId: Int,
    val tenantId: Int,
    val title: String,
    val content: String,
    val datePosted: String,
    val likes: Int = 0,
    val commentCount: Int = 0,
    val authorName: String? = null,
    val attachmentUrl: String? = null
)
