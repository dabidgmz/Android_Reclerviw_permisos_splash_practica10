package com.example.practica10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(5000, 1000) { // 5000 milisegundos = 5 segundos

            public void onTick(long millisUntilFinished) {
                // Puedes realizar alguna acción aquí si lo necesitas durante la cuenta regresiva.
            }

            public void onFinish() {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        }.start();
    }
}
