package com.example.exam

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exam.network.UserApi
import com.example.exam.userData.DefaultResponse
import com.example.exam.userData.UserRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginUserViewModel : ViewModel() {

    private val _defaultResponse = MutableLiveData<DefaultResponse>()
    val defaultResponse:LiveData<DefaultResponse> = _defaultResponse

    fun createUser(userName: String, password: String, view: View) {
        UserApi.retrofitService.createUser2(userRequest = UserRequest(userName, password))
            .enqueue(object : Callback<DefaultResponse> {
                override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                    Toast.makeText(view.context, t.message.toString(), Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<DefaultResponse>,
                    response: Response<DefaultResponse>
                ) {
                    _defaultResponse.value = response.body()
                }

            })
    }


}