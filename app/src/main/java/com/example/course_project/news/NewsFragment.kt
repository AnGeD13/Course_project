package com.example.course_project.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import com.example.course_project.R

class newsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = NavHostFragment.findNavController(this)

        view.findViewById<Button>(R.id.our_news_btn).setOnClickListener{ navController.navigate(R.id.newCountryFragment) }
        view.findViewById<Button>(R.id.world_news_btn).setOnClickListener{ navController.navigate(R.id.newsWorldFragment) }
    }
}