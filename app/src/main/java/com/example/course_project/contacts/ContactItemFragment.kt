package com.example.course_project.contacts


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.course_project.R


class contactItemFragment : Fragment() {

    val args: contactItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val personName = view.findViewById<TextView>(R.id.contact_item_name)
        val personPhone = view.findViewById<TextView>(R.id.contact_item_phone)
        val personImage = view.findViewById<ImageView>(R.id.contact_item_photo)

        personName.text = args.contactName
        personPhone.text = args.contactPhone
        personImage.setImageResource(args.contactPhoto)

    }
}