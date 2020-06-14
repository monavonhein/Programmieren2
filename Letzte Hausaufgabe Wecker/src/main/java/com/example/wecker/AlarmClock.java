package com.example.wecker;

import java.io.Serializable;
import java.util.Arrays;

public class AlarmClock implements Serializable {
    public boolean on;
    public int minute;
    public int hour;
    public boolean days[]= new boolean[7];
    public void DaysPrevious (String args[]) {
        for (int i = 0; i < 8; i++) {
            days[i] = false;
        }
    }

/// Konstruktor mit Tagen
    public AlarmClock( int hour, int minute, boolean on, boolean[] days){
        super();
        this.hour=hour;
        this.minute= minute;
        this.on= on;
        this.days= days;
    }
//Konstruktor ohne Tage
public AlarmClock( int hour, int minute, boolean on){
    super();
    this.hour=hour;
    this.minute= minute;
    this.on= on;

}
        public boolean getOn(){
            return on;
        }

        public int getHour () {
            return hour;

        }

        public int getMinute () {
            return minute;

        }
        public boolean getAlarm(){
            return on;
        }

        public void setAlarm (boolean on) {
            this.on = on;
        }

        public void setHour (int hour) {
            this.hour = hour;
        }

        public void setOn(){
            this.on=on;
        }
        public void setDays(){
            this.days=days;
        }
        public void setMinute (int minute) {
            this.minute = minute;
        }

        public void toggleDay(int index){
        days[index]=!days[index];
        }

        public boolean getDays( int index){
            return days[index];
        }

        @Override
        public String toString(){

            return "AlarmClock{" +
                    "alarmHour=" + hour +
                    ", alarmMinute=" + minute+
                    ", alarmDay=" + Arrays.toString(days) +
                    ", alarmOn=" + on +
                    '}';

    }

}
