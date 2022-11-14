package com.example.mantraapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.welcomeButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                openActivity();
            }
        });
    }
    public void openActivity() {
        Intent intent = new Intent(this, instructions.class);
        startActivity(intent);
    }
}