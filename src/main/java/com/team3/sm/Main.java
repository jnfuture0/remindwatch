package com.team3.sm;

import java.io.IOException;

class Main {
    public static void main(String[] args) {
        testAlarm();
        testCurrentTime();
    }

    private static void testCurrentTime(){
        Controller currentTime = new CurrentTime();

        try {
            currentTime.loadData();
        } catch (IOException e) {
            System.out.print("No file");
        }

        currentTime.printElement();
        for(int i = 0; i<200; i++){ // seconds
            currentTime.increaseValue();
        }
        currentTime.printElement();
        currentTime.moveCursor();
        for(int i = 0; i<200; i++){ // minutes
            currentTime.increaseValue();
        }
        currentTime.printElement();
        currentTime.moveCursor();
        for(int i = 0; i<200; i++){ // hours
            currentTime.increaseValue();
        }
        currentTime.printElement();
        currentTime.moveCursor();
        for(int i = 0; i<21; i++){ // date
            currentTime.increaseValue();
            currentTime.printElement();
        }
        currentTime.printElement();
        for(int i = 0; i<21; i++){ // date
            currentTime.increaseValue();
            currentTime.printElement();
        }
        currentTime.printElement();
        currentTime.moveCursor();
        for(int i = 0; i<200; i++){ // month
            currentTime.increaseValue();
        }
        currentTime.printElement();
        currentTime.moveCursor();
        for(int i = 0; i<200; i++){ // year
            currentTime.increaseValue();
        }
        currentTime.printElement();

        currentTime.clearData();
        try {
            currentTime.saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testAlarm(){
        Controller alarm = new Alarm();

        try {
            alarm.loadData();
        } catch (IOException e) {
            System.out.print("No file");
        }
        alarm.increaseValue();
        alarm.increaseValue();
        alarm.printElement();
        alarm.moveCursor();
        alarm.printElement();
        alarm.increaseValue();
        alarm.printElement();
        alarm.moveCursor();
        alarm.moveCursor();
        alarm.increaseValue();
        alarm.printElement();

        alarm.clearData();
        try {
            alarm.saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
