package com.goodchild.al_ro.thecurseoftheaireyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // code below taken from : https://www.youtube.com/watch?v=ND6a4V-xdjI
        // create a thread
        Thread myThread = new Thread(){
            @Override
            public  void run(){
                try {// try in case it causes an error
                    sleep(3000); // stopp current thread for 3 seconds
                    // a new intent to take the person automatically to the main activity
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    // start the activity
                    startActivity(intent);
                    // finish this thread
                    finish();
                } catch (InterruptedException e) {// a catch to see the error deatails should an error occur
                    e.printStackTrace();
                }
            }
        };

        myThread.start();// this starts the my thread function, which simply, when called, executes tasks to make a splash screen for the app.
    }
}
