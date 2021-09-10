package com.example.loluserinfoapp.repository

import com.example.loluserinfoapp.network.RequestImageInterface
import com.example.loluserinfoapp.network.RequestInterface
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val userInterface : RequestInterface,
    private val userImageInterface: RequestImageInterface
) {

    suspend fun getSummoner(userName:String)= userInterface.getSummoner(userName, "RGAPI-b70709f8-cb61-4c96-9f3d-08cd8ff5bcea")
    fun getProfileImage(userId: String) = userImageInterface.getProfileImage(userId)

}