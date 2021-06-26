package com.example.quanlysinhviensqlite.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quanlysinhviensqlite.R;
import com.example.quanlysinhviensqlite.database.SinhVienDAO;
import com.example.quanlysinhviensqlite.model.SinhVien;

public class AddSinhVien extends AppCompatActivity {
    EditText txtName, txtYB, txtHometown;
    Spinner spinnerYear;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);

        txtName = findViewById(R.id.txtNameLop);
        txtYB = findViewById(R.id.txtDes);
        txtHometown = findViewById(R.id.txtTown);
        spinnerYear = findViewById(R.id.spinYear);
        btnAdd = findViewById(R.id.btnAddLop);

        final String [] years = {"Năm nhất", "Năm hai", "Năm ba", "Năm tư"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, years);
        spinnerYear.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                int yob = Integer.parseInt(txtYB.getText().toString());
                String homeTown = txtHometown.getText().toString();
                String year = spinnerYear.getSelectedItem().toString();
                SinhVien sv = new SinhVien(name, yob, homeTown, year);
                SinhVienDAO db = new SinhVienDAO(getBaseContext());
                if(db.addSV(sv)){
                    Toast.makeText(getBaseContext(), "add OK", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                }else {
                    Toast.makeText(getBaseContext(), "Add fail", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}