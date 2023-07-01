package com.example.coffee_jsonapi_retrofitrx

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class MyAdapter(private val postList: List<coffe>,private val context: Context) :RecyclerView.Adapter<viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder  {
        return viewHolder(LayoutInflater.from(context).inflate(R.layout.coffee_item,parent,false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.BindTextValue!!.text = postList[position].title
        holder.BindContentValue!!.text = postList[position].content
        holder.BindCardView!!.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("ID",postList[position].id)
            intent.putExtra("TITLE",postList[position].title)
            intent.putExtra("THUMBNAIL",postList[position].thumbnail)
            intent.putExtra("CONTENT",postList[position].content)
            context!!.startActivities(arrayOf(intent))
        }
        Picasso.get().load(postList[position].thumbnail).error(R.mipmap.ic_launcher)
            .placeholder(R.mipmap.ic_launcher_round)
            .into(holder.BindImageView)
    }
}