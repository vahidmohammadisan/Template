package ir.vahidmohammadisan.basic_feature.data.remote.api

import ir.vahidmohammadisan.basic_feature.data.remote.model.RocketResponse
import retrofit2.http.GET

interface RocketApi {

    @GET("rockets")
    suspend fun getRockets(): List<RocketResponse>
}
