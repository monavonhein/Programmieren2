package com.example.wecker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    TimePicker timepicker;
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timepicker = findViewById(R.id.timePicker2);
        switch1 = findViewById(R.id.switch1);
        ReadService readService = new ReadService();
        AlarmClock alarmClock1 = new AlarmClock(06, 00, false);
        TextView timeView;

        Object obj = ReadService.readObject(MainActivity.this);
        if(obj !=null){
            if(obj instanceof AlarmClock){
                alarmClock1 = (AlarmClock) obj;
                //Aufgabe 11
                Log.i("Test2", alarmClock1.toString());
                if(alarmClock1.getHour()>23||alarmClock1.getHour()<0||alarmClock1.getMinute()>59||alarmClock1.getMinute()<0){
                    Toast.makeText(MainActivity.this,"Nein, ungültige daten  im objekt, lern uhrzeiten",Toast.LENGTH_LONG).show();
                    timepicker.setHour(alarmClock1.getHour());
                    timepicker.setMinute(alarmClock1.getMinute());
                    if(alarmClock1.getOn()){

                    }
                }else{

                }
            }
        }



        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Want to add a new entry",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,
                        EditAlarmActivity.class);
                startActivity(intent);
            }
        });


        ImageButton flButton = findViewById(R.id.imageButton);
        flButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Want to add a new entry",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, EditAlarmActivity.class);
                startActivity(intent);
            }
        });



    CheckBox checkBox= new CheckBox(this);
    checkBox.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener(){
        @SuppressLint("ResourceAsColor")
        @Override
        public void onCheckedChanged( CompoundButton compoundButton, boolean isChecked){
            if(isChecked){
                compoundButton.setText("i am checked");
            }
        }
    });

    }
}
