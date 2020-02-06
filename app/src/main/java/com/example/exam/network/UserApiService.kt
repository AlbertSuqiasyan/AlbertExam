package com.example.exam.network



import com.example.exam.userData.DefaultResponse
import com.example.exam.userData.ItemResponse
import com.example.exam.userData.UserRequest
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlinx.coroutines.Deferred
import retrofit2.http.*

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


    @POST("users/signin.json")
    fun createUser2(
        @Body
        userRequest: UserRequest
    ): Call<DefaultResponse>

    @GET("stage/photos/freetoedit/search.json?q=&offset=0&limit=50")
    fun getProperties():
            Deferred<ItemResponse>
}

object UserApi {
    val retrofitService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}