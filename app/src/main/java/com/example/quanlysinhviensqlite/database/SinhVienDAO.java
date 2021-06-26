package com.example.quanlysinhviensqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysinhviensqlite.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    static DatabaseHelper databaseHelper;

    public SinhVienDAO(Context context){
        this.databaseHelper = new DatabaseHelper(context);
    }

    public List<SinhVien> getAllSV(){
        List<SinhVien> svs = new ArrayList<SinhVien>();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM sinhvien",null);
        if(cursor.moveToFirst()){
            do {
                SinhVien sv = new SinhVien();
                sv.setMaSV(cursor.getInt(0));
                sv.setTenSV(cursor.getString(1));
                sv.setNamsinh(cursor.getInt(2));
                sv.setQuequan(cursor.getString(3));
                sv.setNamhoc(cursor.getString(4));
                svs.add(sv);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return svs;
    }

    public SinhVien findSinhVienById(int maSV){
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query("sinhvien", new String[] {"maSV","tenSV","namSinh","queQ","namHoc"},"maSV = ?", new String[]{String.valueOf(maSV)},null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        SinhVien sv = new SinhVien(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getString(4));
        cursor.close();
        return sv;
    }

    public Boolean addSV(SinhVien sv){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenSV", sv.getTenSV());
        values.put("namSinh", sv.getNamsinh());
        values.put("queQ", sv.getQuequan());
        values.put("namHoc", sv.getNamhoc());
        long check = db.insert("sinhvien", null, values);
        if (check>0) return true;
        else return false;
    }
}
