package com.example.quanlysinhviensqlite.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlysinhviensqlite.R;
import com.example.quanlysinhviensqlite.database.LopDAO;
import com.example.quanlysinhviensqlite.model.Lop;

public class AddLop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lop);

        EditText txtName, txtDes;
        Button btnAddLop;

        txtName = findViewById(R.id.txtNameLop);
        txtDes = findViewById(R.id.txtDes);
        btnAddLop =findViewById(R.id.btnAddLop);

        btnAddLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String des = txtDes.getText().toString();
                Lop lop = new Lop(name, des);
                LopDAO db = new LopDAO(getBaseContext());

                if(db.addLop(lop)){
                    Toast.makeText(getBaseContext(), "Them lop thanh cong", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                }else {
                    Toast.makeText(getBaseContext(), "Them lop that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}