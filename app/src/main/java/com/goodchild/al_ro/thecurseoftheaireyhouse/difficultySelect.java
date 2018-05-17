package com.goodchild.al_ro.thecurseoftheaireyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class difficultySelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_select);

        // get the value from the previous page and save it as a variable.
        final String choice = getIntent().getStringExtra("choice");
        // convert it to a local string so it is editable
        String choice1 = choice;
        // load all buttons on the page as local variables
        Button shortbtn =  findViewById(R.id.shortbtn);
        Button mediumbtn =  findViewById(R.id.medbtn);
        Button longbtn =  findViewById(R.id.longbtn);
        //load text view on page to access it.
        TextView choicing = findViewById(R.id.charChoice);
        String message = "Test";

        // a series of if statments that depending on the value sent from the previous page which is now stored in choice, it selects the apropriate text to dispaly and saves it in a varible. This is done to get context correct.
        if (choice1.equals("1")){
            message = "You have selected The Soldier! Please select the length of game time. This also effects difficulty.";
        }
        else if (choice1.equals("2")){
            message = "You have selected The Engineer! Please select the length of game time. This also effects difficulty.";
        }
        else if (choice1.equals("3")){
            message = "You have selected The Gendarmerie! Please select the length of game time. This also effects difficulty.";
        }
        else if (choice1.equals("4")){
            message = "You have selected a Random character! Please select the length of game time. This also effects difficulty.";
        }
        //set the variable message as the text to be shown in the text box
        choicing.setText(message);

        //an on click listener for the short length button, this idicates the player wants a short game. This creates a new intent and then sends the choice from the previous page + the choice of game length.
        shortbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = "1";
                Intent intent = new Intent(getBaseContext(), game.class);
                intent.putExtra("choice", choice);
                intent.putExtra("length", length);
                startActivity(intent);
            }
        });
        //an on click listener for the medium length button, this idicates the player wants a short game. This creates a new intent and then sends the choice from the previous page + the choice of game length.
        mediumbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = "2";
                Intent intent = new Intent(getBaseContext(), game.class);
                intent.putExtra("choice", choice);
                intent.putExtra("length", length);
                startActivity(intent);
            }
        });
        //an on click listener for the long length button, this idicates the player wants a short game. This creates a new intent and then sends the choice from the previous page + the choice of game length.
        longbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = "3";
                Intent intent = new Intent(getBaseContext(), game.class);
                intent.putExtra("choice", choice);
                intent.putExtra("length", length);
                startActivity(intent);
            }
        });

    }
}
