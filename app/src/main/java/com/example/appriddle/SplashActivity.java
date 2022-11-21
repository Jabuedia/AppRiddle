package com.example.appriddle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.TimerTask;
import java.util.Timer;
import android.content.Intent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        //getSupportActionBar().hide(); // Esconder la action bar asquerosa

        //Animaciones

        Animation animacion1 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);


        TextView riddleTextView = findViewById(R.id.riddleTextView);
        TextView deTextView = findViewById(R.id.deTextView);
        ImageView splashImageView = findViewById(R.id.splashImageView);

        deTextView.setAnimation(animacion2);
        riddleTextView.setAnimation(animacion1);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            };
            Timer tiempo = new Timer();

            tiempo.schedule(tarea,5000);


        }
}