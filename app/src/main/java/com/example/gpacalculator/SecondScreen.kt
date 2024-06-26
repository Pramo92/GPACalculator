package com.example.gpacalculator

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView


class SecondScreen : AppCompatActivity() {
    fun getGradePoint(grade:String):Double{
        var gradePoint = when (grade){
            "A+" -> 4.0
            "A" -> 4.0
            "A-" -> 3.7
            "B+" -> 3.3
            "B" -> 3.0
            "B-" -> 2.7
            "C+" -> 2.3
            "C" -> 2.0
            "C-"-> 1.7
            "D+" -> 1.3
            "D" -> 1.0
            else -> 0.0
        }
        return gradePoint
    }
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        val helper = DBHelper(applicationContext)

        val i = intent
        val index = i.getStringExtra("indexpara")

        val db = helper.readableDatabase
        val res = db.rawQuery("SELECT * from Result WHERE index_no ='$index'",null)

        val course1 = findViewById<TextView>(R.id.course1)
        val credit1 = findViewById<TextView>(R.id.credit1)
        val grade1 = findViewById<TextView>(R.id.grade1)
        val course2 = findViewById<TextView>(R.id.course2)
        val credit2 = findViewById<TextView>(R.id.credit2)
        val grade2 = findViewById<TextView>(R.id.grade2)
        val course3 = findViewById<TextView>(R.id.course3)
        val credit3 = findViewById<TextView>(R.id.credit3)
        val grade3 = findViewById<TextView>(R.id.grade3)
        val gpa = findViewById<TextView>(R.id.gpa)

        while(res.moveToNext()){
            val c1 = res.getString(res.getColumnIndex("course_code1"))
            val cr1 = res.getString(res.getColumnIndex("credit1"))
            val g1 = res.getString(res.getColumnIndex("grade1"))
            val c2 = res.getString(res.getColumnIndex("course_code2"))
            val cr2 = res.getString(res.getColumnIndex("credit2"))
            val g2 = res.getString(res.getColumnIndex("grade2"))
            val c3 = res.getString(res.getColumnIndex("course_code3"))
            val cr3 = res.getString(res.getColumnIndex("credit3"))
            val g3 = res.getString(res.getColumnIndex("grade3"))

            var gp1 = getGradePoint(g1)
            var gp2 = getGradePoint(g2)
            var gp3 = getGradePoint(g3)

            var Toatlgpa= ((cr1.toInt()*gp1)+(cr2.toInt()*gp2)+(cr3.toInt()*gp3))/(cr1.toInt()+cr2.toInt()+cr3.toInt())

            course1.text = c1
            credit1.text = cr1
            grade1.text = g1
            course2.text = c2
            credit2.text = cr2
            grade2.text = g2
            course3.text = c3
            credit3.text = cr3
            grade3.text = g3
            gpa.text= Toatlgpa.toString()

        }
    }
}