package com.goodchild.al_ro.thecurseoftheaireyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class rules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        // load the text view in for access as a local variable
        TextView scroller = findViewById(R.id.rulesTextView);
        //created a variable to save what i wanted scroller to say
        String insideText = "Rules: \n\nRules of this game are simple. Once you start a game you will be greeted by a character selection page. On this page you select a character. The difference between characters is the stats you will start the game off with. The Soldier has a priority towards health where as the engineer is stamina and gendarmerie is Sanity. Random simply generates random stats to help you start the game.\n\nAfter the character selection you had to choose how long you would like to play. While play time is up to you, the game helps lengthen the game by increased the amount of items required to be picked up during the course of the game. Short is the shortest game time while long is the longest game time.\n\nThe next screen you are taken to is the main game screen. Here you can save your current game to come back to later. To resume the game, go to the home screen and select reload a game. You can also get to main menu from this screen. The options you have on this screen are to explore: To go and explore another room, and Make and observation check: This searches the room for objects. Once you have searched for an object in the room the room is considered empty and you will not be able to find any items. Along with you bases stats shown on the screen a key and omen is also mentioned. Key is an object which can be randomly discovered by exploring a room. When you have found one, you finish the game at that time. Chance of finding a key is very small.Omens are a currency which are taken away every time you find an item. Once the counter hits 0 the monster in the house find you. When the monster in the house finds you you are taken to the monster combat page. In this page you have the choice to fight or evade. Evading removes health from the monster. Attacking simply damages the monsters stat. If any of your stats hit 0, you are dead. Likewise for the monster. On failure, you return to the home page, on winning you are taken to the winners page. Thanks for reading! we hope you escape your monster.";
        // set text inside scroller to the text inside the variable inside text.
        scroller.setText(insideText);
        //load the button to go home into a local variable
        Button home = findViewById(R.id.goHome2btn);
        //on click listener so when somone preses the go hom button, they go home.
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(rules.this, MainActivity.class));
            }
        });


    }
}
