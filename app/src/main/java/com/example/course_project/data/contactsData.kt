package com.example.course_project.data

import android.util.Log
import com.example.course_project.R
import com.example.course_project.model.Contacts

class contactsData {

    fun loadContacts(): MutableList<Contacts> {
        return mutableListOf(
            Contacts(R.drawable.woman, "Елена", "+7 945 999 99 99"),
            Contacts(R.drawable.woman, "Алена", "+7 951 988 88 98"),
            Contacts(R.drawable.man, "Максим", "+7 924 789 90 39"),
            Contacts(R.drawable.woman, "Юля", "+7 914 856 96 40"),
            Contacts(R.drawable.man, "Алексей", "+7 955 123 45 67"),
            Contacts(R.drawable.woman, "Ксения", "+7 932 453 11 00"),
            Contacts(R.drawable.man, "Богдан", "+7 999 950 10 10"),
            Contacts(R.drawable.woman, "Ольга", "+7 914 980 54 46"),
            Contacts(R.drawable.man, "Тарас", "+7 999 950 10 10"),
            Contacts(R.drawable.woman, "Кристина", "+7 964 342 30 26"),
            Contacts(R.drawable.company, "Водоканал", "+7 999 671 35 50"),
            Contacts(R.drawable.man, "Магомед", "+7 924 671 32 33"),
            Contacts(R.drawable.woman, "Олеся", "+7 914 789 90 13"),
        )
    }
}


