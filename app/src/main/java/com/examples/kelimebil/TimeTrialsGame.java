package com.examples.kelimebil;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class TimeTrialsGame extends AppCompatActivity {
    String str;
    GameSArrays db;
    String[] array;
    Random random;
    int rNum;
    String selectedStr;
    ArrayList<Character> que;
    TextView question;
    TextView hint;
    TextView scoreBoard;
    TextView userAnswer;
    TextView timer;
    Button guess;
    Button takeALetter;
    Button goBackToMainMenu;
    int score = 0;

    public void hider(){
        db = new GameSArrays();
        array = db.randomGetter();
        random = new Random();
        rNum = random.nextInt(array.length);
        selectedStr = array[rNum];
        selectedStr = selectedStr.toUpperCase(Locale.ROOT);
        str = "";
        System.out.println(selectedStr);

        que = new ArrayList<Character>();
        for (char c : selectedStr.toCharArray()){
            que.add(c);
        }



        for (int i = 0 ; i < que.size(); i++){
            if (i<que.size()-1){
                str += "_ ";

            }
            else {
                str+= "_";

            }
        }

        question.setText(str);

        if (array == db.getCities()){
            String s = "İPUCU: ŞEHİR "+ que.size() +" HARF";
            hint.setText(s);

        }
        else if (array == db.getNames()){
            String s = "İPUCU: İSİM "+ que.size()+" HARF";
            hint.setText(s);
        }





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_trials_game);

        //initializing of xml components
        hint = findViewById(R.id.hintText2);
        question = findViewById(R.id.question2);
        scoreBoard = findViewById(R.id.scoreBoard2);
        userAnswer = findViewById(R.id.userSAnswer2);
        guess = findViewById(R.id.guess2);
        timer = findViewById(R.id.timer);
        takeALetter = findViewById(R.id.takeALetter2);
        goBackToMainMenu = findViewById(R.id.goBackToMMBtn2);

       CountDownTimer downCounter =  new CountDownTimer(181000, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText("KALAN SÜRE "+l/1000);

            }

            @Override
            public void onFinish() {
                timer.setText("KALAN SÜRE: "+ 0);
                hint.setText("SÜRE DOLDU");
                userAnswer.setEnabled(false);
                takeALetter.setEnabled(false);
                guess.setEnabled(false);
                goBackToMainMenu.setAlpha(1);
                goBackToMainMenu.setEnabled(true);

            }
        };

       downCounter.start();


        hider();

        takeALetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (que.size()>0){
                    int h = random.nextInt(que.size());
                    System.out.println(que.get(h));
                    String[] txtLetters = question.getText().toString().split(" ");
                    char[] txtChars = selectedStr.toCharArray();

                    for (int i = 0; i< selectedStr.length() ; i ++){

                        if(txtLetters[i].equals("_") && txtChars[i] == que.get(h)) {

                            txtLetters[i] = String.valueOf(que.get(h));
                            str = "";

                            for (int j = 0 ; j <selectedStr.length(); j++){
                                if(j == i){
                                    str += txtLetters[j] + " ";
                                }
                                else if(j < selectedStr.length()-1) {
                                    str += txtLetters[j] + " ";
                                }
                                else {
                                    str += txtLetters[j];
                                }


                            }
                            break;

                        }
                    }

                    question.setText(str);
                    que.remove(h);
                }

                if (que.size() == 0){
                    hint.setText("TÜM KELİME ORTAYA ÇIKTI");
                    userAnswer.setEnabled(false);
                    takeALetter.setEnabled(false);
                    guess.setEnabled(false);
                    goBackToMainMenu.setAlpha(1);
                    goBackToMainMenu.setEnabled(true);


                }
            }
        });

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userSGuess = userAnswer.getText().toString().toUpperCase(Locale.ROOT);
                if (userSGuess.equals(selectedStr)){
                    int won = que.size()*100;
                    Toast.makeText(getApplicationContext(),"Doğru "+won,Toast.LENGTH_SHORT).show();
                    score += won;

                    String s = "SKOR: "+score;
                    scoreBoard.setText(s);

                    hider();
                    userAnswer.setText("");



                }
                else {

                    Toast.makeText(getApplicationContext(),"Yanlış -100p",Toast.LENGTH_SHORT).show();
                    score -= 100;
                    String s = "SKOR: "+ score;
                    scoreBoard.setText(s);




                }

            }
        });
        goBackToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downCounter.cancel();

                Intent intent =new Intent(TimeTrialsGame.this,StartScreen.class);
                intent.putExtra("score",score);
                finish();
                startActivity(intent);

            }
        });


    }
}

