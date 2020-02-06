package com.example.exam.userData

import com.squareup.moshi.Json

data class ItemResponse(
    @Json(name = "status")
    val status: String,
    @Json(name = "response")
    val response: List<Response>
)