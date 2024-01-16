package com.bitc.android_team3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "android_team3_db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE user (\n" +
                    "id TEXT PRIMARY KEY,\n" +
                    "pw TEXT NOT NULL,\n" +
                    "name TEXT NOT NULL,\n" +
                    "email TEXT,\n" +
                    "phone TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    //    회원가입
    fun userInsert(db: SQLiteDatabase?, user: UserInfoData) {
        var sql = "INSERT INTO user (id, pw, name, email, phone) "
        sql += "VALUES ('${user.id}', '${user.pw}', '${user.name}', '${user.email}', '${user.phone}') "

        db?.execSQL(sql)
    }

    //    아이디 중복 확인 (아이디가 중복되면 1 반환)
    fun userIdCheck(db: SQLiteDatabase, id: String): Int {
        var sql = "SELECT COUNT(*) AS cnt FROM user WHERE id = '$id' "
        var dataSet = db?.rawQuery(sql, null)

        var result = 0

        if(dataSet!!.moveToNext()){
            result += dataSet.getInt(0)
        }

        return result
    }

//    로그인

//    회원 정보 가져오기
}