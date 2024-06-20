package com.example.course_project.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.course_project.R


class editNameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = view.findViewById<EditText>(R.id.editName)
        val saveBtn = view.findViewById<Button>(R.id.saveName)

        saveBtn.setOnClickListener{
            val textToInsert = editText.text.toString()

            val action = editNameFragmentDirections.actionEditNameFragmentToProfileFragment(
                textToInsert)

            findNavController().navigate(action)
        }

    }
}