package com.example.jetpacktutorial.retrofitwithcoroutines

import com.example.jetpacktutorial.retrofitwithcoroutines.model.Photos
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    suspend fun getPhotos() : Response<List<Photos>>
}