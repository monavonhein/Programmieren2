package com.example.aufgab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar bar;
    TextView percent;
    View view;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Ausgabe:", "STAAART");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar= findViewById(R.id.seekBar);
        percent=findViewById(R.id.textView2);
        view=findViewById(R.id.view);
       //
        //Log.i("Ausgabe:", Integer.toString(number));

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //percent.setText(progress);
                percent.setText(String.valueOf(progress));
                if(progress==0){
                    view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.zero));
                }
                if(progress==1){
                    view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.one));
                }
                if(progress==2){
                    view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.two));
                }

                if(progress==3){
                view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.three));
                 }

                if(progress==4){
                view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.four));
                }

                if(progress==5){
                 view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.five));
                }
                if(progress==6){
                    view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.six));
                }
                if(progress==7){
                    view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.seven));
                }
                if(progress==8){
                    view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.eight));
                }
                if(progress==9){
                    view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.nine));
                }
                if(progress==10){
                    view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.ten));
                }



                Log.i("Ausgabe:", "onProgressChanged");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
              //  int number = bar.getProgress();
              //  percent.setText(number);
               // Log.i("Ausgabe:", "onStartTracking");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               number = bar.getProgress();
              //  Log.i("Ausgabe:", "onStopTracking");

            }
        } );



    }
}
