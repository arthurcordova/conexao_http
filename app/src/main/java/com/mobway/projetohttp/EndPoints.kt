package com.mobway.projetohttp

import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {

    @GET("/photos")
    fun getPhotos(): Call<List<UserPhotoModel>>


    @GET("/todos")
    fun getTodos(): Call<List<TodoModel>>

}