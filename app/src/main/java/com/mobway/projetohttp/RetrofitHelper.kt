package com.mobway.projetohttp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    companion object {

        lateinit var retrofit: Retrofit

        fun initRetrofit() {
            retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getServices(): EndPoints {
            return retrofit.create(EndPoints::class.java)
        }


//        https://jsonplaceholder.typicode.com/todos/1

    }

}