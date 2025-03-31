package com.example.studentviewsapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val inputName = findViewById<EditText>(R.id.nameInput)
        val inputId = findViewById<EditText>(R.id.idInput)
        val inputButton = findViewById<Button>(R.id.button)
        val listView = findViewById<ListView>(R.id.listView)

        val studentList = mutableListOf<StudentModel>()

        for(i in 1..27) {
            studentList.add(StudentModel("Student $i", "$i"))
        }

        inputButton.setOnClickListener {
            val name = inputName.text.toString()
            val id = inputId.text.toString()

            if (name.isNotEmpty() &&  id.isNotEmpty()) {
                studentList.add(StudentModel(name, id))

                inputName.text.clear()
                inputId.text.clear()
            } else {
                inputName.error = "Input"
                inputId.error = "Input"
            }
        }

    }
}