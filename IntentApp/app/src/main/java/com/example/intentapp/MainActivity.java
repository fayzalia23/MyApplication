package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PLACE = "extra_place";
    public static final String EXTRA_DATE = "extra_date";

    private TextInputLayout tilTanggal;
    private TextInputEditText tietNama;
    private TextInputEditText tietTempat;
    private TextInputEditText tietTanggal;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_next = findViewById(R.id.btn_intent);

        tilTanggal = findViewById(R.id.textInputLayoutTanggal);
        tietNama = findViewById(R.id.etNama);
        tietTempat = findViewById(R.id.etTempat);
        tietTanggal = findViewById(R.id.etTanggal);

        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("SELECT A DATE");

        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        tilTanggal.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
            }
        });


        materialDatePicker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPositiveButtonClick(Object selection) {

                        tietTanggal.setText(materialDatePicker.getHeaderText());
                    }
                });

        btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_intent){
            Intent intent = new Intent(getApplicationContext(), NextActivity.class);
            intent.putExtra(EXTRA_NAME, tietNama.getText().toString());
            intent.putExtra(EXTRA_PLACE, tietTempat.getText().toString());
            intent.putExtra(EXTRA_DATE, tietTanggal.getText().toString());
            startActivity(intent);
        }
    }
}