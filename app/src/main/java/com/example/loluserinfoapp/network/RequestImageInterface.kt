package com.example.loluserinfoapp.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RequestImageInterface {
    @GET("profileicon/{profileicon_id}")
    fun getProfileImage(
        @Path("profileicon_id") profileIconId : String
    ): Call<ResponseBody>
}