package com.alimardon.hasan.RetrofitFile

import com.alimardon.hasan.model.UserItemItem
import retrofit2.Call
import retrofit2.http.GET

interface networkApi {
    @GET("users")
    fun getUsers(): Call<List<UserItemItem>>
}