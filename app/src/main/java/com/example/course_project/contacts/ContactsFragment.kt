package com.example.course_project.contacts

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_project.R
import com.example.course_project.data.contactsData
import com.example.course_project.model.Contacts
import com.google.android.material.floatingactionbutton.FloatingActionButton


class contactsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var contactsList = contactsData().loadContacts()
    private lateinit var adapter: contactsRecycler
    private lateinit var floatAddBtn: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerContacts)

        recyclerView.layoutManager = LinearLayoutManager(context)

        floatAddBtn = view.findViewById(R.id.floatAdd)

        adapter = contactsRecycler(contactsList)
        recyclerView.adapter = adapter

        floatAddBtn.setOnClickListener{

            val inflter = LayoutInflater.from(context)
            val v = inflter.inflate(R.layout.add_contact,null)

            val userName = v.findViewById<EditText>(R.id.addUserName)
            val userNo = v.findViewById<EditText>(R.id.addUserNo)
            var userPh = 0
            var checkedItem = 2
            val items = arrayOf("Мужчина", "Женщина", "Неизвестно")

            val addDialog = AlertDialog.Builder(context)

            addDialog.setView(v)

            addDialog.setPositiveButton("Ок"){
                    dialog,_->
                when(checkedItem) {
                    0-> {
                        userPh = R.drawable.man
                    }
                    1-> {
                        userPh = R.drawable.woman
                    }
                    2-> {
                        userPh = R.drawable.company
                    }
                }
                val names = userName.text.toString()
                val number = userNo.text.toString()
                contactsList.add(Contacts(userPh, names,number))

                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            addDialog.setNegativeButton("Назад"){
                    dialog,_->
                dialog.dismiss()
            }

            addDialog.setSingleChoiceItems(items, checkedItem){ _,selectedItemIndex ->
                checkedItem = selectedItemIndex
            }
            addDialog.create()
            addDialog.show()

        }

        adapter.setOnContactClickListener(object : contactsRecycler.onContactClickListenter {
            override fun onContactClick(position: Int) {

                val contact = contactsList[position]
                val name = contact.name
                val phone = contact.phone
                val img = contact.imageId

                val action = contactsFragmentDirections.actionContactsFragmentToContactItemFragment(
                    name, phone, img)

                findNavController().navigate(action)
            }

        })

    }

}