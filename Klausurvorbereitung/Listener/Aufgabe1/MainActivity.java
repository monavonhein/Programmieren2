package com.example.aufgabe2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;





import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import android.os.Bundle;
    public class MainActivity extends AppCompatActivity {

        Button check;
        int geraten;
        EditText zahl;
        TextView text;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            EditText tx = (EditText) findViewById(R.id.zahlfeld);
            int amount = Integer.parseInt(tx.getText().toString());//das hier notieren!
            text=findViewById(R.id.ausgabe);
            check= findViewById(R.id.check);

            check.setOnClickListener((View variable)->{
                if(amount==12){
                    text.setText("Das war die richtige Zahl!");
                }else{
                    text.setText("try again");
                }

            });

        }
    }

