package ir.vahidmohammadisan.basic_feature.data.remote.api

import ir.vahidmohammadisan.basic_feature.data.remote.model.CoinListResponse
import retrofit2.http.GET

interface CoinApi {

    @GET("/api/tickers/")
    suspend fun getCoins(): CoinListResponse
}