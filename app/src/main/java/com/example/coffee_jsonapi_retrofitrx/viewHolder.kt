package com.example.coffee_jsonapi_retrofitrx

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class viewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    val BindTextValue: TextView? = itemView.findViewById(R.id.txtTitle)
    val BindContentValue: TextView? = itemView.findViewById(R.id.txtCotent)
    val BindImageView: ImageView? = itemView.findViewById(R.id.imageView)
    val BindCardView: CardView? = itemView.findViewById(R.id.cardView)
}
