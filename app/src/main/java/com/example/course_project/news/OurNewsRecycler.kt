package com.example.course_project.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_project.R
import com.example.course_project.model.News

class ourNewsRecycler(private val ourNews: List<News>):
    RecyclerView.Adapter<ourNewsRecycler.MyViewHolder>() {

    private lateinit var newsListener : onNewsClickListenter

    interface onNewsClickListenter{

        fun onNewsClick(position: Int)
    }

    fun setOnNewsClickListener(listenter: onNewsClickListenter) {
        newsListener = listenter

    }

    class MyViewHolder(itemView: View, listener: onNewsClickListenter): RecyclerView.ViewHolder(itemView) {
        val newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)

        init {
            itemView.setOnClickListener {
                listener.onNewsClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_news, parent, false)

        return MyViewHolder(itemView, newsListener)
    }

    override fun getItemCount(): Int {
        return ourNews.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val new = ourNews[position]
        holder.newsTitle.text = holder.itemView.context.getString(new.title)
    }
}