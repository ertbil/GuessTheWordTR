package com.examples.kelimebil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class StartScreen extends AppCompatActivity {



    int score;
    public void exit(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);

    }

    @Override
    public void onBackPressed() {
        exit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Intent scoreBridge = getIntent();
            score = scoreBridge.getIntExtra("score",0);

        ImageView img = findViewById(R.id.imageView);
        TextView lastScore = findViewById(R.id.lastScore);
        Button normalGame = findViewById(R.id.normalGame);
        Button timeTrialsGame =findViewById(R.id.timeTrialsGame);
        Button exit = findViewById(R.id.exitBtn);
        String s = "Son Oyun Skoru: "+ score;
        lastScore.setText(s);

        normalGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(StartScreen.this,NormalGame.class);
                startActivity(intent1);

            }
        });
        timeTrialsGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(StartScreen.this,TimeTrialsGame.class);
                startActivity(intent2);

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });





    }
}