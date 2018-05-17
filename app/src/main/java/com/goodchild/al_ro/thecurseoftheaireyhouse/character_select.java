package com.goodchild.al_ro.thecurseoftheaireyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class character_select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);


        //Load all buttons on page into local variables to they are accessable.
        Button char1 = (Button) findViewById(R.id.char1);
        Button char2 = (Button) findViewById(R.id.char2);
        Button char3 = (Button) findViewById(R.id.char3);
        Button charRan = (Button) findViewById(R.id.charRan);

        //Set an on click listener for character 1, if selected, to sends the value 1 and the player to the difficulty page.
        char1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice = "1";
                Intent intent = new Intent(getBaseContext(), difficultySelect.class);
                intent.putExtra("choice", choice);
                startActivity(intent);
            }
        });
        //Set an on click listener for character 2, if selected, to sends the value 1 and the player to the difficulty page.
        char2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice = "2";
                Intent intent = new Intent(getBaseContext(), difficultySelect.class);
                intent.putExtra("choice", choice);
                startActivity(intent);
            }
        });
        //Set an on click listener for character 3, if selected, to sends the value 1 and the player to the difficulty page.
        char3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice = "3";
                Intent intent = new Intent(getBaseContext(), difficultySelect.class);
                intent.putExtra("choice", choice);
                startActivity(intent);
            }
        });
        //Set an on click listener for character 4, if selected, to sends the value 1 and the player to the difficulty page.
        charRan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice = "4";
                Intent intent = new Intent(getBaseContext(), difficultySelect.class);
                intent.putExtra("choice", choice);
                startActivity(intent);
            }
        });
// These listeners and intents are needed to let the game know what player stats the player has chosen.
    }
}
