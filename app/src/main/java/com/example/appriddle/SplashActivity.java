package com.example.appriddle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.TimerTask;
import java.util.Timer;
import android.content.Intent;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide(); // Esconder la action bar asquerosa

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            };
            Timer tiempo = new Timer();

            tiempo.schedule(tarea,3000);


        }
}