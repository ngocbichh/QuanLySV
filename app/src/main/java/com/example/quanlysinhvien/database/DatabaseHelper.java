package com.example.quanlysinhvien.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "SinhvienManagement", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateSV = "CREATE TABLE sinhvien (maSV integer PRIMARY KEY AUTOINCREMENT, tenSV TEXT, namSinh integer, queQ TEXT, namHoc TEXT )";
        db.execSQL(sqlCreateSV);

        String sqlCreateLop = "CREATE TABLE lop (maLop integer PRIMARY KEY AUTOINCREMENT, tenLop TEXT, moTa TEXT )";
        db.execSQL(sqlCreateLop);

        String sqlCreateSVLop = "CREATE TABLE sinhvienLop (id integer PRIMARY KEY AUTOINCREMENT, maSV interger, maLop integer, kyHoc TEXT, soTC TEXT," +
                "FOREIGN KEY (maLop) REFERENCES sanpham (lop), " +
                "FOREIGN KEY (maSV) REFERENCES sanpham (sinhvien))";
        db.execSQL(sqlCreateSVLop);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
