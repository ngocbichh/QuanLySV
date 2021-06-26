package com.example.quanlysinhviensqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysinhviensqlite.model.Lop;

import java.util.ArrayList;
import java.util.List;

public class LopDAO {
    static DatabaseHelper databaseHelper;

    public LopDAO(Context context){
        this.databaseHelper = new DatabaseHelper(context);
    }

    public List<Lop> getAllLop(){
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        List<Lop> lp = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM lop", null);
        if(cursor.moveToNext()){
            do {
                Lop lop = new Lop();
                lop.setMaLop(cursor.getInt(0));
                lop.setTenLop(cursor.getString(1));
                lop.setMoTa(cursor.getString(2));
                lp.add(lop);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return lp;
    }

    public static Lop findLopById(int maLop){
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query("lop", new String[] {"maLop", "tenLop", "moTa"}, "maLop = ?", new String[]{String.valueOf(maLop)},null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        Lop lp = new Lop(cursor.getInt(0), cursor.getString(1), cursor.getString(3));
        cursor.close();
        return lp;
    }

    public boolean addLop(Lop lop){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenLop", lop.getTenLop());
        values.put("moTa", lop.getMoTa());
        long check = db.insert("lop", null, values);
        if(check > 0)
            return true;
        else
            return false;
    }
}
