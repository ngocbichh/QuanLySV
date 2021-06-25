package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLop = findViewById(R.id.btnLop);
        Button btnSv = findViewById(R.id.btnSV);
        Button btnSearch = findViewById(R.id.btnSearch);

        btnLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LopManagement.class);
                startActivity(intent);
            }
        });

        btnSv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SinhVienManagement.class);
                startActivity(intent);
            }
        });

        btnLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimKiem.class);
                startActivity(intent);
            }
        });
    }
}