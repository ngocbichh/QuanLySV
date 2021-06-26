package com.example.quanlysinhviensqlite.controller;

import androidx.appcompat.app.AppCompatActivity;
import com.example.quanlysinhviensqlite.R;
import com.example.quanlysinhviensqlite.database.SinhVienLopDAO;
import com.example.quanlysinhviensqlite.model.SinhVienLop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangKy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        Intent intent = getIntent();
        int maLop = intent.getIntExtra("maLop", 0);
        String tenLop = intent.getStringExtra("tenLop");
        String moTa = intent.getStringExtra("moTa");

        EditText nameLop = findViewById(R.id.tenLopHoc);
        nameLop.setText(tenLop);
        nameLop.setEnabled(false);

        EditText txtMSV = findViewById(R.id.txtMaSV);
        EditText txtKyHoc = findViewById(R.id.txtKyHoc);
        EditText txtSTC = findViewById(R.id.txtSoTC);

        Button addSV_L = findViewById(R.id.btnAdd_SV_Lop);
        addSV_L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVienLopDAO svlDAO = new SinhVienLopDAO(getBaseContext());
                int maSV = Integer.parseInt(txtMSV.getText().toString());
                String kyHoc = txtKyHoc.getText().toString();
                int soTC = Integer.parseInt(txtSTC.getText().toString());
                if(svlDAO.addSinhVienLop(new SinhVienLop(maSV, maLop, kyHoc, soTC))){
                    Toast.makeText(getBaseContext(), "Them sinh vien vao lop thanh cong", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                }else {
                    Toast.makeText(getBaseContext(), "Them sinh vien vao lop that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}