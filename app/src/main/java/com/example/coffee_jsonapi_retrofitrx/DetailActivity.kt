package com.example.coffee_jsonapi_retrofitrx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    var showTitle: TextView? = null
    var showContent: TextView? = null
    var showImage: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        showTitle = findViewById<TextView>(R.id.showTitle)
        showContent = findViewById<TextView>(R.id.showContent)
        showImage = findViewById<ImageView>(R.id.showImage)

        var intent = intent
        showTitle!!.text = "" + (intent.getStringExtra("TITLE"))
        showContent!!.text = "" + (intent.getStringExtra("CONTENT"))
        //showImage!!.setImageResource(intent.getIntExtra("THUMBNAIL",0))
        Picasso.get()
            .load(intent.getStringExtra("THUMBNAIL"))
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(showImage)
    }
}
