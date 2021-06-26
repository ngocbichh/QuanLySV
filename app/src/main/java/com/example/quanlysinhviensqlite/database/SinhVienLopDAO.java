package com.example.quanlysinhviensqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysinhviensqlite.model.SinhVien;
import com.example.quanlysinhviensqlite.model.SinhVienLop;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class SinhVienLopDAO {
    static DatabaseHelper databaseHelper;

    public SinhVienLopDAO(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public boolean addSinhVienLop(SinhVienLop svl){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maSV", svl.getIdSV());
        values.put("maLop", svl.getIdLop());
        values.put("kyHoc", svl.getKyHoc());
        values.put("soTC", svl.getSoTC());
        long check = db.insert("sinhvienLop", null, values);
        if(check>0) return true;
        else return false;
    }

    public List<SinhVienLop> getAllSVLop(int maLop){
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        List<SinhVienLop> listSV = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM sinhvienLop WHERE maLop="+maLop+" ORDER BY maSV", null);
        if(cursor.moveToFirst()){
            do{
                SinhVienLop svl = new SinhVienLop(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2),cursor.getString(3), cursor.getInt(4));
                listSV.add(svl);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listSV;
    }
}
