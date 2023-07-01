package com.example.coffee_jsonapi_retrofitrx

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface NetAPI {
    @GET("coffee.json")
    fun getAllData(): Observable<List<coffe>>
}