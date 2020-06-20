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
    Button mondaytofriday;
    Switch on;
    Button Ok;// DAS hier ist wichtig, weil sonst müssen die final sein
    boolean on1= false;
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
        mondaytofriday=findViewById(R.id.mondaytofriday);

        Ok = findViewById(R.id.OkButton);
        on = findViewById(R.id.switch2);
        alarmClock.setOn();
        timepicker = findViewById(R.id.timePicker2);
        setTime(timepicker);

        changeColor(monday, 0);
        changeColor(tuesday, 1);
        changeColor(wednesday, 2);
        changeColor(thursday, 3);
        changeColor(friday, 4);
        changeColor(satturday, 5);
        changeColor(sunday, 6);
        changeColorall(mondaytofriday);


//Aufgabe 4

            Ok.setOnClickListener((View variable)->{
                //Aufgabe 8
                Log.i("Ausgabe:", alarmClock.toString());
                WriteService.writeObject(EditAlarmActivity.this, alarmClock);
                //Aufgabe9
                Intent intent = new Intent(EditAlarmActivity.this, MainActivity.class);
                startActivity(intent);


            });





        on.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked)-> {
            if(alarmClock.getAlarm()){
                alarmClock.setAlarm(false);
            }else{
                alarmClock.setAlarm(true);
            }
        });


//Aufgabe 3
    }

    public void setTime(TimePicker timePicker) {
        timePicker.setOnTimeChangedListener((TimePicker view, int hour, int minute) -> {
            alarmClock.setHour(hour);
            alarmClock.setMinute(minute);
        });
    }

    @SuppressLint("ResourceAsColor")
    public void changeColor(Button button, int id){                 //das hier sind anonyme innere KLassen
        button.setOnClickListener(lambda ->{

                alarmClock.toggleDay(id);
                if(alarmClock.getDays(id)){
                    button.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                            R.color.blue));
                }else{
                    button.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                            R.color.grey));

            }
        });
    }

    public void changeColorall(Button button){                 //das hier sind anonyme innere KLassen
        button.setOnClickListener(lambda ->{

            alarmClock.toggleall(on1);

            if(on1==false) {
                monday.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                        R.color.blue));
                tuesday.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                        R.color.blue));
                wednesday.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                        R.color.blue));
                thursday.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                        R.color.blue));
                friday.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                        R.color.blue));

                on1=true;
            }
            if(on1==true) {
                monday.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                        R.color.grey));
                tuesday.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                        R.color.grey));
                wednesday.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                        R.color.grey));
                thursday.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                        R.color.grey));
                friday.setTextColor(ContextCompat.getColor(EditAlarmActivity.this,
                        R.color.grey));

                on1=false;
            }



        });
    }
}
