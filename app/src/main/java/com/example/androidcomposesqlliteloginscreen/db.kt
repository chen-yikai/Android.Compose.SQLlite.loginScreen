package com.example.androidcomposesqlliteloginscreen

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "mydatabase"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable =
            ("CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_EMAIL TEXT, $COLUMN_PASSWORD TEXT)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addData(email: String, password: String) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_EMAIL, email)
            put(COLUMN_PASSWORD, password)
        }
        db.insert(TABLE_NAME, null, values)
    }

    fun closeDatabase() {
        val db = this.writableDatabase
        db.close()
    }
}
