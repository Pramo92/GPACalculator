package com.example.gpacalculator

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context): SQLiteOpenHelper(context,"University2",null,1){
    companion object{
        const val TABLE_NAME = "Result"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME(index_no TEXT,"+" course_code1 TEXT, credit1 INTEGER, grade1 TEXT,course_code2 TEXT, credit2 INTEGER, grade2 TEXT,course_code3 TEXT, credit3 INTEGER, grade3 TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(indexNo: String?,course_code1:String?,credit1:Int?,grade1:String?,course_code2:String?,credit2:Int?,grade2:String?,course_code3:String?,credit3:Int?,grade3:String?){
        val values = ContentValues()
        values.put("index_no",indexNo)
        values.put("course_code1",course_code1)
        values.put("credit1",credit1)
        values.put("grade1",grade1)
        values.put("course_code2",course_code2)
        values.put("credit2",credit2)
        values.put("grade2",grade2)
        values.put("course_code3",course_code3)
        values.put("credit3",credit3)
        values.put("grade3",grade3)

        val db=this.writableDatabase
        db.insert(TABLE_NAME,null,values)


    }


}


