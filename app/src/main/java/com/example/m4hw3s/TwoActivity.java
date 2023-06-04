package com.example.m4hw3s;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ImageButton btnEd = findViewById(R.id.btnEd);
        ImageButton btnIned = findViewById(R.id.btnIned);
        btnEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EdibleMushrooms.class);
                startActivity(intent);
            }
        });
        btnIned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InedibleMushrooms.class);
                startActivity(intent);
            }
        });
    }
}