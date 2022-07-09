package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private Button b7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b7 = findViewById(R.id.b7);


    }


    public void OnClickStart(View view) {
        finish();
        startActivity(new Intent(MainActivity.this, Activity2.class));


    }

        }