package com.example.residencehub.models

import kotlinx.serialization.Serializable

@Serializable
data class CommunityPost(
    val postid: Int,
    val tenantid: Int,
    val title: String,
    val content: String,
    val date_posted: String,
    val likes: Int = 0,
    val comment_count: Int = 0
)
