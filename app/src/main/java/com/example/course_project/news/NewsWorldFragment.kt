package com.example.course_project.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_project.R
import com.example.course_project.data.NewsData

class newsWorldFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_news_world, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerWorldNews)

        recyclerView.layoutManager = LinearLayoutManager(context)

        val newsList = NewsData().loadWorldNews()

        val adapter = ourNewsRecycler(newsList)
        recyclerView.adapter = adapter

        adapter.setOnNewsClickListener(object : ourNewsRecycler.onNewsClickListenter {
            override fun onNewsClick(position: Int) {

                val new = newsList[position]
                val title = view.context.getString(new.title)
                val desc = view.context.getString(new.desc)

                val action = newsWorldFragmentDirections.actionNewsWorldFragmentToNewsPageFragment(
                    title, desc)

                findNavController().navigate(action)
            }

        })
    }
}