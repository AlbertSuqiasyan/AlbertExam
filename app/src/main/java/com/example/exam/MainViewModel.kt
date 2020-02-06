package com.example.exam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exam.network.UserApi
import com.example.exam.userData.ItemResponse
import kotlinx.coroutines.launch


class MainViewModel : ViewModel(){

    private val _itemResponse = MutableLiveData<ItemResponse>()
    val itemResponse: LiveData<ItemResponse> = _itemResponse

    val _error = MutableLiveData<String>()

    init {
        getItemProperties()
    }

    private fun getItemProperties(){
        viewModelScope.launch {
            var getPropertiesDeferred = UserApi.retrofitService.getProperties()
            try {
                var item = getPropertiesDeferred.await()
                _itemResponse.value = item
            } catch (t: Throwable){
                _error.value = t.message
            }
        }
    }

}