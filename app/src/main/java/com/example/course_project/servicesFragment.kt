package com.example.course_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment


class servicesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment val appsFragment =

        return inflater.inflate(R.layout.fragment_services, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = NavHostFragment.findNavController(this)

        view.findViewById<Button>(R.id.news_btn).setOnClickListener{ navController.navigate(R.id.newsFragment) }
        view.findViewById<Button>(R.id.steps_btn).setOnClickListener{ navController.navigate(R.id.stepsFragment) }
    }

}