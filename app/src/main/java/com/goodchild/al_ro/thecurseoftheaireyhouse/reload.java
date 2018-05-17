package com.goodchild.al_ro.thecurseoftheaireyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class reload extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reload);
        //load the reload butten as a variable for access
        Button reload = findViewById(R.id.loaderbtn);
        //created a string which will be used to send infromation to the next page to aid in the choosing of stats
        final String confirm = "5";
        //A listner for when the reload button is pressed
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a new file directory where a you will look for save file. txt
                File file1 = new File(getApplicationContext().getFilesDir(),"save.txt");
                // check if the file exists
                if(file1.exists()){
                    //create a new intent to go to a game.class page
                    Intent intent = new Intent(getBaseContext(), game.class);
                    //place the choice varibale which we created before to help in stat allocation
                    intent.putExtra("choice", confirm);
                    // set the length of the game to 4 so the game page knows how long to choose
                    intent.putExtra("length", "4");
                    // start the activity having sent the information
                    startActivity(intent);
                }else {// only goes to this option if a save file doesnt exisit yet
                    // new intent to go to main activity
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    //this creates a small widget called a toast which says why you were taken back to the main activity
                    Toast.makeText(getApplicationContext(), "No Save file detected. Going back to home",
                            Toast.LENGTH_SHORT).show();
                    // start the activity.
                    startActivity(intent);
                }



            }
        });
    }
}
