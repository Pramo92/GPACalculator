package com.example.gpacalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var indexglobal =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = DBHelper(applicationContext)

        val course1 = findViewById<EditText>(R.id.course1)
        val credit1 = findViewById<EditText>(R.id.credit1)
        val grade1 = findViewById<EditText>(R.id.grade1)
        val course2 = findViewById<EditText>(R.id.course2)
        val credit2 = findViewById<EditText>(R.id.credit2)
        val grade2 = findViewById<EditText>(R.id.grade2)
        val course3 = findViewById<EditText>(R.id.course3)
        val credit3 = findViewById<EditText>(R.id.credit3)
        val grade3 = findViewById<EditText>(R.id.grade3)
        val btn = findViewById<Button>(R.id.btn)
        val grade_point :Double

        btn.setOnClickListener{
            var index = ++indexglobal
            helper.insertData(
                index.toString(),
                course1.text?.toString()!!,
                credit1.text.toString().toInt()!!,
                grade1.text?.toString()!!,
                course2.text?.toString()!!,
                credit2.text.toString().toInt()!!,
                grade2.text?.toString()!!,
                course3.text?.toString()!!,
                credit3.text.toString().toInt()!!,
                grade3.text?.toString()!!,
            )


            val bundle = Bundle()
            bundle.putString("indexpara",index.toString())

            val gotoNextScreen = Intent(applicationContext,SecondScreen::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)

        }


    }
}