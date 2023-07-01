package com.example.coffee_jsonapi_retrofitrx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.internal.schedulers.IoScheduler
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        var url = "https://antchatbot.firebaseio.com/"
        val retrofit = Retrofit.Builder().addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create()
            )
        ).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).baseUrl(url).build()
        val postCoffeeAPI = retrofit.create(NetAPI::class.java)
        val response = postCoffeeAPI.getAllData()
        response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe(){
            recyclerView!!.adapter = MyAdapter(it,this)
        }

    }
}