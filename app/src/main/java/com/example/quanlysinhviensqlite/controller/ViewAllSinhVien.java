package com.example.quanlysinhviensqlite.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlysinhviensqlite.ActivityLop;
import com.example.quanlysinhviensqlite.R;
import com.example.quanlysinhviensqlite.database.SinhVienDAO;
import com.example.quanlysinhviensqlite.database.SinhVienLopDAO;
import com.example.quanlysinhviensqlite.model.SinhVien;
import com.example.quanlysinhviensqlite.model.SinhVienLop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllSinhVien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_sinh_vien);

        Intent intent = getIntent();
        int maLop = intent.getIntExtra("maLop", 0);
        String tenLop = intent.getStringExtra("tenLop");
        String moTa = intent.getStringExtra("moTa");

        TextView txtNameLop = findViewById(R.id.nameLop);
        txtNameLop.setText(tenLop);

        SinhVienLopDAO db = new SinhVienLopDAO(getBaseContext());
        SinhVienDAO svDAO = new SinhVienDAO(getBaseContext());
        ListView listAllSV = findViewById(R.id.listAllSV);

        List<SinhVienLop> listSVL = db.getAllSVLop(maLop);
        Log.d("List SV Lop", listSVL.toString());
        List<SinhVien> listSV = new ArrayList<>();
        for(SinhVienLop x: listSVL){
            SinhVien sv = new SinhVien();
            sv = svDAO.findSinhVienById(x.getIdSV());
            Log.d("Sinh vien: ", sv.toString());
            listSV.add(sv);
        }

        ArrayAdapter<SinhVien> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listSV);
        listAllSV.setAdapter(arrayAdapter);

        Button btnSV_L = findViewById(R.id.btnSVL);
        btnSV_L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAllSinhVien.this, DangKy.class);
                intent.putExtra("maLop", maLop);
                intent.putExtra("tenLop", tenLop);
                intent.putExtra("moTa", moTa);
                startActivityForResult(intent, 3);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==3 && resultCode==RESULT_OK){
            Intent intent = new Intent(this, ViewAllSinhVien.class);
            this.finish();
            startActivity(intent);
        }
    }
}