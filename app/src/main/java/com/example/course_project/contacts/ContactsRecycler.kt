package com.example.course_project.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_project.R
import com.example.course_project.model.Contacts


class contactsRecycler(private val contacts: MutableList<Contacts>):
    RecyclerView.Adapter<contactsRecycler.MyViewHolder>() {

    private lateinit var contactsListener : onContactClickListenter

    interface onContactClickListenter{

        fun onContactClick(position: Int)
    }

    fun setOnContactClickListener(listenter: onContactClickListenter) {
        contactsListener = listenter

    }

    class MyViewHolder(itemView: View, listener: onContactClickListenter): RecyclerView.ViewHolder(itemView) {
        val personName = itemView.findViewById<TextView>(R.id.personName)
        val personPhone = itemView.findViewById<TextView>(R.id.personPhone)
        val personPhoto = itemView.findViewById<ImageView>(R.id.personPhoto)

        init {
            itemView.setOnClickListener {
                listener.onContactClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_contacts, parent, false)

        return MyViewHolder(itemView, contactsListener)
    }

    override fun getItemCount(): Int {
       return contacts.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val contact = contacts[position]
        holder.personName.text = contact.name
        holder.personPhone.text = contact.phone
        holder.personPhoto.setImageResource(contact.imageId)

    }

}