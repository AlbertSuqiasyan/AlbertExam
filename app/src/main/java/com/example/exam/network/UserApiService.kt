package com.example.exam.network



import com.example.exam.userData.DefaultResponse
import com.example.exam.userData.ItemResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL = "https://api.picsart.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface UserApiService {

    @FormUrlEncoded
    @POST("users/signin.json")
    fun createUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<DefaultResponse>

    @GET("stage/photos/freetoedit/search.json?q=")
    fun getProperties():
            Deferred<ItemResponse>
}

object UserApi {
    val retrofitService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}