package com.example.exam.userData

import com.squareup.moshi.Json


data class UserRequest(
    @Json(name = "username")
    val username: String,
    @Json(name = "password")
    val password: String
)