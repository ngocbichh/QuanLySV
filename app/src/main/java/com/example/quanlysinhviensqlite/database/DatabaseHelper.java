package com.example.quanlysinhviensqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "QlySinhVien", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateSV = "CREATE TABLE sinhvien (maSV integer PRIMARY KEY AUTOINCREMENT, tenSV TEXT, namSinh integer, queQ TEXT, namHoc TEXT )";
        db.execSQL(sqlCreateSV);

        String sqlCreateLop = "CREATE TABLE lop (maLop integer PRIMARY KEY AUTOINCREMENT, tenLop TEXT, moTa TEXT )";
        db.execSQL(sqlCreateLop);

        String sqlCreateSVLop = "CREATE TABLE sinhvienLop (id integer PRIMARY KEY AUTOINCREMENT, maSV interger, maLop integer, kyHoc TEXT, soTC integer," +
                "FOREIGN KEY (maLop) REFERENCES lop (malop), " +
                "FOREIGN KEY (maSV) REFERENCES sinhvien (maSV))";
        db.execSQL(sqlCreateSVLop);
        Log.d("Create", "Create DB");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String querySV = "DROP TABLE IF EXISTS sinhvien";
        String queryLop = "DROP TABLE IF EXISTS lop";
        db.execSQL(querySV);
        db.execSQL(queryLop);
    }
}
