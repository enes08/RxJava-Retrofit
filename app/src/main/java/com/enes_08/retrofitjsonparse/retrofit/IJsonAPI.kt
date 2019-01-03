package com.limonist.mykotlin.Retrofit

import com.enes_08.retrofitjsonparse.model.response.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by lenovo on 25.12.2018.
 */
interface IJsonAPI {


    @GET("users")
    abstract fun getUser(): Call<List<User>>



    @GET("users")
     fun getUser2(): Observable<List<User>>

}