package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private TextView tvNama;
    private TextView tvTempat;
    private TextView tvTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        tvNama = findViewById(R.id.tvNama);
        tvTempat = findViewById(R.id.tvTempat);
        tvTanggal = findViewById(R.id.tvTanggal);

        String name = getIntent().getStringExtra(MainActivity.EXTRA_NAME);
        String tempat = getIntent().getStringExtra(MainActivity.EXTRA_PLACE);
        String tanggal = getIntent().getStringExtra(MainActivity.EXTRA_DATE);

        if(name != null){
            tvNama.setText(name);
        }
        if(tempat != null){
            tvTempat.setText(tempat);
        }
        if(tanggal != null){
            tvTanggal.setText(tanggal);
        }
    }
}