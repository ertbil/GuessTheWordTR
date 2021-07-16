package com.examples.kelimebil;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class NormalGame extends AppCompatActivity {
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
        setContentView(R.layout.activity_normal_game);





        //initializing of xml components
        hint = findViewById(R.id.hintText);
        question = findViewById(R.id.question);
        scoreBoard = findViewById(R.id.scoreBoard);
        userAnswer = findViewById(R.id.userSAnswer);
        guess = findViewById(R.id.guess);
        takeALetter = findViewById(R.id.takeALetter);
        goBackToMainMenu = findViewById(R.id.goBackToMMBtn);

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

                    String s = "SKOR: "+ String.valueOf(score);
                    scoreBoard.setText(s);

                    hider();
                    userAnswer.setText("");



                }
                else {

                    Toast.makeText(getApplicationContext(),"Yanlış -100p",Toast.LENGTH_SHORT).show();
                    score -= 100;
                    String s = "SKOR: "+ String.valueOf(score);
                    scoreBoard.setText(s);




                }

            }
        });
        goBackToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(NormalGame.this,StartScreen.class);
                intent.putExtra("score",score);
                finish();
                startActivity(intent);

            }
        });


    }
}