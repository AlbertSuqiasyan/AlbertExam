package com.example.exam.userData

data class DefaultResponse(
    val default_profile_pic: Boolean,
    val email: String,
    val id: Long,
    val name: String,
    val photo: String,
    val status: String,
    val username: String
)
