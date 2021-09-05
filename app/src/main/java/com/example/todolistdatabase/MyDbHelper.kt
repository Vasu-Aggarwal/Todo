package com.example.todolistdatabase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.todolistdatabase.db.TodoTable

class MyDbHelper(context: Context): SQLiteOpenHelper (
    context,                      //context
    "todos.db",             //name of the database
    null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(TodoTable.CMD_CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}