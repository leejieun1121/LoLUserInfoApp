package com.example.loluserinfoapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loluserinfoapp.model.Summoner
import com.example.loluserinfoapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    private var _summoner = MutableLiveData<Summoner>()
    val summonerInfo : LiveData<Summoner>
    get() = _summoner

    private var _summonerImage = MutableLiveData<InputStream>()
    val summonerImage : LiveData<InputStream>
        get() = _summonerImage

    val userName = MutableLiveData<String>()

    fun getSummoner(userName:String){
        viewModelScope.launch {
            //TODO 응답코드에따라 다르게 해주기
            val response = mainRepository.getSummoner(userName)
            _summoner.value = response.body()
        }
    }

    fun getProfileImage(){
        viewModelScope.launch {
            val img = _summoner.value?.profileIconId.toString()
            //TODO 이부분 코루틴 적용하기
            val response = mainRepository.getProfileImage("$img.png")
            response.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>,
                ) {
                    _summonerImage.value = response.body()?.byteStream()
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                    TODO("Not yet implemented")
                }

            })
        }
    }
}