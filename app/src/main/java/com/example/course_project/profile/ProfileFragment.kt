package com.example.course_project.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.course_project.R


class profileFragment : Fragment() {

    val args: profileFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myName = view.findViewById<TextView>(R.id.myName)
        val myPhone = view.findViewById<TextView>(R.id.myPhone)
        val myPhoto = view.findViewById<ImageView>(R.id.myPhoto)
        myName.text = args.myName

        myPhone.text = view.context.getString(R.string.my_phone)
        myPhoto.setImageResource(R.drawable.myphoto)
    }

}