package com.example.exam.userData

import com.squareup.moshi.Json

data class DefaultResponse(
    @Json(name = "status")
    val status: String,
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String,
    @Json(name = "username")
    val username: String,
    @Json(name = "photo")
    val photo: String,
    @Json(name = "default_profile_pic")
    val defaultProfilePic: Boolean,
    @Json(name = "email")
    val email: String
)