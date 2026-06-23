package com.example.wanderlens.data.remote

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface CloudinaryApi {
    @Multipart
    @POST("v1_1/{cloud_name}/image/upload")
    suspend fun uploadImage(
        @Path("cloud_name") cloudName: String,
        @Part file: MultipartBody.Part,
        @Part("timestamp") timestamp: okhttp3.RequestBody,
        @Part("api_key") apiKey: okhttp3.RequestBody,
        @Part("signature") signature: okhttp3.RequestBody
    ): CloudinaryResponse

    @Multipart
    @POST("v1_1/{cloud_name}/image/destroy")
    suspend fun destroyImage(
        @Path("cloud_name") cloudName: String,
        @Part("public_id") publicId: okhttp3.RequestBody,
        @Part("timestamp") timestamp: okhttp3.RequestBody,
        @Part("api_key") apiKey: okhttp3.RequestBody,
        @Part("signature") signature: okhttp3.RequestBody
    ): CloudinaryDeleteResponse
}

data class CloudinaryResponse(
    val secure_url: String,
    val public_id: String
)

data class CloudinaryDeleteResponse(
    val result: String
)
