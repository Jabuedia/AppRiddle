package com.example.appriddle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SudokuActivity extends AppCompatActivity {
    TextView nose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);
        getSupportActionBar().hide(); // Esconder la action bar asquerosa

        nose = findViewById(R.id.regresar);
    }

    private void atras(){
        Intent intent = new Intent(SudokuActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}