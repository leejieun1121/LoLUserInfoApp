package com.example.loluserinfoapp.network

import com.example.loluserinfoapp.LeagueInfo
import com.example.loluserinfoapp.model.Summoner
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RequestInterface {
    @GET("summoner/v4/summoners/by-name/{summonerName}")
    suspend fun getSummoner(
        @Path("summonerName") summonerName : String,
        @Query("api_key") api_key : String
        ) : Response<Summoner>

    @GET("league/v4/entries/by-summoner/{encryptedSummonerId}")
    suspend fun getLeagueInfo(
        @Path("encryptedSummonerId") encryptedSummonerId : String,
        @Query("api_key") api_key : String
    ) : Response<List<LeagueInfo>>


}