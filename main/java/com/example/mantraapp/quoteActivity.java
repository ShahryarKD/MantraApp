package com.example.mantraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class quoteActivity extends AppCompatActivity implements View.OnClickListener{

    TextView quoteView;
    Button nextButton;
    String line = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        nextButton = findViewById(R.id.nextBtn);
        nextButton.setOnClickListener(this);



        quoteView = findViewById(R.id.quoteView);



        InputStream myInput = null;
        Scanner in = null;

        quoteView.setText(EmotionActivity.emotionVar);



        if(EmotionActivity.emotionVar.trim().equals("happiness") || EmotionActivity.emotionVar.trim().equals("neutral")){
            quoteView.setText("Just keep smiling");
            try {
                myInput = getAssets().open("happy.txt");

                BufferedReader input = new BufferedReader(new InputStreamReader(myInput));


                    nextButton = findViewById(R.id.nextBtn);
                    nextButton.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v){
                            try {
                                line = input.readLine();
                                quoteView.setText(line);

                            } catch (IOException e) {
                                e.printStackTrace();

                            }
                        }
                    });

            } catch (Exception e) {
                e.getMessage();
            }
        }
        else if (EmotionActivity.emotionVar.trim().equals("sadness")){
            quoteView.setText("Don’t look back! You’re not going that way.");
            try {
                myInput = getAssets().open("sadness.txt");

                BufferedReader input = new BufferedReader(new InputStreamReader(myInput));


                nextButton = findViewById(R.id.nextBtn);
                nextButton.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v){
                        try {
                            line = input.readLine();
                            quoteView.setText(line);

                        } catch (IOException e) {
                            e.printStackTrace();

                        }
                    }
                });

            } catch (Exception e) {
                e.getMessage();
            }
        }
        else {
            quoteView.setText("Anger makes you smaller, while forgiveness forces you to grow beyond what you are.");
            try {
                myInput = getAssets().open("angry.txt");

                BufferedReader input = new BufferedReader(new InputStreamReader(myInput));


                nextButton = findViewById(R.id.nextBtn);
                nextButton.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v){
                        try {
                            line = input.readLine();
                            quoteView.setText(line);

                        } catch (IOException e) {
                            e.printStackTrace();

                        }
                    }
                });

            } catch (Exception e) {
                e.getMessage();
            }
        }


    }


    public void onClick(View view){
        quoteView.setText(line);
    }


}