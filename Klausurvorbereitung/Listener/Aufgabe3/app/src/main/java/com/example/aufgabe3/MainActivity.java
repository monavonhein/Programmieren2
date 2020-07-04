package com.example.aufgabe3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    TextView email;
    TextView password;
    Button checkin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Ausgabe:","Start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.textView);
        email=findViewById(R.id.username);
        password=findViewById(R.id.password);
        checkin=findViewById(R.id.checkin);
        String stephi="Stephi";


        checkin.setOnClickListener((View view)->{
            String name= email.getText().toString();
            String passwort= password.getText().toString();
            Log.i("Ausgabe:","onClick");
            Log.i("Ausgabe:",name);
           if(name.equals("Stephi")) {
               if (passwort.equals("androidApp")) {
                   text.setText("Login erfolgreich");
               }else{
                   text.setText("Passwort falsch");
               }
           }else if(name.equals("Frank")){
                if(passwort.equals("Sonne")){
                    text.setText("Login erfolgreich");}else{
                    text.setText("Passwort falsch");
                }
            }else if(name.equals("Mario")){
                if(passwort.equals("d1ggA!")){
                    text.setText("Login erfolgreich");}else{
                    text.setText("Passwort falsch");
                }
            }else if(name.equals("Mia")){
                if(passwort.equals("urLaub")){
                    text.setText("Login erfolgreich");}else{
                    text.setText("Passwort falsch");
                }

            }else{
               text.setText("Login fehlgeschlagen");
           }

        });
    }
}
