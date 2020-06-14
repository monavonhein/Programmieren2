package com.example.wecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

public class EditAlarmActivity extends AppCompatActivity {
    AlarmClock alarmClock= new AlarmClock(0, 0, false );
    TimePicker timepicker;
    Button monday;
    Button tuesday;
    Button wednesday;
    Button thursday;
    Button friday;
    Button satturday;
    Button sunday;
    Switch on;
    Button Ok;// DAS hier ist wichtig, weil sonst müssen die final sein

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_alarm);

        monday = findViewById(R.id.monday);
        tuesday = findViewById(R.id.tuesday);
        wednesday = findViewById(R.id.wednesday);
        thursday = findViewById(R.id.thursday);
        friday = findViewById(R.id.friday);
        satturday = findViewById(R.id.satturday);
        sunday = findViewById(R.id.sunday);
        Ok = findViewById(R.id.OkButton);
        on = findViewById(R.id.switch2);
        alarmClock.setOn();
        timepicker = findViewById(R.id.timePicker2);

        changeColor(monday, 0);
        changeColor(tuesday, 1);
        changeColor(wednesday, 2);
        changeColor(thursday, 3);
        changeColor(friday, 4);
        changeColor(satturday, 5);
        changeColor(sunday, 6);


//Aufgabe 4
        public void SafeOptions (Button Ok){
            Ok.setOnClickListener(v -> {
                Log.i("Test1", alarmClock.toString()); //so gibt man wohl die Daten aus dem Objekt aus
                alarmClock.setHour(timepicker.getHour());
                alarmClock.setMinute(timepicker.getMinute());
                //Aufgabe 8
                WriteService.writeObject(EditAlarmActivity.this, alarmClock);
                //Aufgabe9
                Intent intent = new Intent(EditAlarmActivity.this, MainActivity.class);
                startActivity(intent);


            });
        }



    public void setOn(Switch on){
        on.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked)-> {
            if(alarmClock.getAlarm()){
                alarmClock.setAlarm(false);
            }else{
                alarmClock.setAlarm(true);
            }
        });
        }

//Aufgabe 3
    } @SuppressLint("ResourceAsColor")
    public void changeColor(Button button, int id){                 //das hier sind anonyme innere KLassen
        button.setOnClickListener(lambda ->{

                alarmClock.toggleDay(id);
                if(alarmClock.getDays(id)){
                    button.setBackgroundColor(R.color.blue);
                }else{
                    button.setBackgroundColor(R.color.white);

            }
        });
    }
}
