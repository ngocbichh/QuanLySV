package com.example.quanlysinhviensqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.quanlysinhviensqlite.controller.AddSinhVien;
import com.example.quanlysinhviensqlite.database.SinhVienDAO;
import com.example.quanlysinhviensqlite.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class ActivitySinhVien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien);
        ListView listView = findViewById(R.id.listSV);
        Button btnAdd = findViewById(R.id.AddLop);

        SinhVienDAO db = new SinhVienDAO(getBaseContext());
        List<SinhVien> svs = db.getAllSV();

        ArrayAdapter<SinhVien> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, svs);
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySinhVien.this, AddSinhVien.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK){
            Intent intent = new Intent(this, ActivitySinhVien.class);
            this.finish();
            startActivity(intent);
        }
    }
}