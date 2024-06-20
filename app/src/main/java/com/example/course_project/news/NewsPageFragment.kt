package com.example.course_project.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.course_project.R


class newsPageFragment : Fragment() {

    val args: newsPageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_news_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsTitle = view.findViewById<TextView>(R.id.newsTitle)
        val newsDesc = view.findViewById<TextView>(R.id.newsDesc)

        newsTitle.text = args.newsTitle
        newsDesc.text = args.newDesc
    }
}