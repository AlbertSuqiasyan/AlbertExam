package com.example.exam.userData

import com.squareup.moshi.Json

data class Response(
    @Json(name = "id")
    val id: Long,
    @Json(name = "url")
    val url: String,
    @Json(name = "title")
    val title: String
)