package com.example.wecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    TextView time;
    Switch switch1;

    TextView monday1;
    TextView tuesday1;
    TextView wednesday1;
    TextView thursday1;
    TextView friday1;
    TextView satturday1;
    TextView sunday1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AUfgabe 10
        time= findViewById(R.id.textView);
        switch1 = findViewById(R.id.switch1);
        monday1= findViewById(R.id.textView2);
        tuesday1=findViewById(R.id.textView3);
        wednesday1= findViewById(R.id.textView9);
        thursday1=findViewById(R.id.textView5);
        friday1=findViewById(R.id.textView4);
        satturday1=findViewById(R.id.textView6);
        sunday1=findViewById(R.id.textView8);
        ReadService readService = new ReadService();
        AlarmClock alarmClock1 = new AlarmClock(06, 00, false);
        TextView timeView;

        Object obj = readService.readObject(MainActivity.this);
        if(obj !=null){
            if(obj instanceof AlarmClock){
                alarmClock1 = (AlarmClock) obj;
                //Aufgabe 11
                Log.i("Test2", alarmClock1.toString());
                time.setText((String.format("%02d", alarmClock1.getHour()))+":"+(String.format("%02d", alarmClock1.getMinute())));
                switch1.setChecked(alarmClock1.getOn());

                // "SetBlue" für main days (this is a totally retarded way to do this but yea... it works)
                if (alarmClock1.getDays(0)) {
                    monday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.blue));
                } else {
                   monday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.grey));
                }
                if (alarmClock1.getDays(1)) {
                   tuesday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.blue));
                } else {
                    tuesday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.grey));
                }
                if (alarmClock1.getDays(2)) {
                    wednesday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.blue));
                } else {
                    wednesday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.grey));
                }
                if (alarmClock1.getDays(3)) {
                    thursday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.blue));
                } else {
                    thursday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.grey));
                }
                if (alarmClock1.getDays(4)) {
                    friday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.blue));
                } else {
                    friday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.grey));
                }
                if (alarmClock1.getDays(5)) {
                    satturday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.blue));
                } else {
                    satturday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.grey));
                }
                if (alarmClock1.getDays(6)) {
                    sunday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.blue));
                } else {
                    sunday1.setTextColor(ContextCompat.getColor(MainActivity.this
                            , R.color.grey));
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
