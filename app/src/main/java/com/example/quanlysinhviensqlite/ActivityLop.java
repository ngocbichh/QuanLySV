package com.example.quanlysinhviensqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.quanlysinhviensqlite.controller.AddLop;
import com.example.quanlysinhviensqlite.controller.ViewAllSinhVien;
import com.example.quanlysinhviensqlite.database.LopDAO;
import com.example.quanlysinhviensqlite.model.Lop;

import java.util.ArrayList;
import java.util.List;

public class ActivityLop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop);

        ListView listViewLop = findViewById(R.id.listLop);
        List<Lop> listLop = new ArrayList<>();
        LopDAO db = new LopDAO(getBaseContext());
        listLop = db.getAllLop();
        ArrayAdapter<Lop> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listLop);
        listViewLop.setAdapter(adapter);

        Button btnAdd = findViewById(R.id.AddLop);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLop.this, AddLop.class);
                startActivityForResult(intent, 1);
            }
        });

        List<Lop> finalListLop = listLop;
        listViewLop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openViewSVTrongLop(finalListLop.get(position).getMaLop(), finalListLop.get(position).getTenLop(), finalListLop.get(position).getMoTa());
            }
        });
    }

    public void openViewSVTrongLop(int maLop, String tenLop, String moTa){
        Intent intent = new Intent(ActivityLop.this, ViewAllSinhVien.class);
        intent.putExtra("maLop", maLop);
        intent.putExtra("tenLop", tenLop);
        intent.putExtra("moTa", moTa);
        startActivity(intent);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK){
            Intent intent = new Intent(this, ActivityLop.class);
            this.finish();
            startActivity(intent);
        }
    }
}