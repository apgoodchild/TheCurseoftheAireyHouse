package com.goodchild.al_ro.thecurseoftheaireyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //Load in the mani text box on the about page
        TextView scroller = (TextView) findViewById(R.id.textViewAbout);
        //Save the text which will be shown in the text box on about page
        String insideText = "Welcome to the Curse of the Airey house! thank you for your support to this game. This game was made to show you some elements of taking text files and their contents, and usnig that information to randomly generate the map. In this game, this happens by randomly selecting a description when entering a room. \n \nThis game never goes into the definition of what an airey house is. During World War 2 after the war ended, there were many soldiers coming home to no homes who needed affordable housing. During this time, the government subsidised a housing initiative which allowed for buildings to be made via a new prefabricated method. Using this method, they were able to make housing cheaper and available to the soldiers who came home. This game starts at the end of WW2 when a man decides to come home to his newly made home, only to find the house haunted and is locked in the house with the only way to get out is to find the key. To find the key you have to go from room to room discovering items and seeing what is unique about this room.\n \nThe menus in the game are quite simple. On the main menu you have 4 buttons. Play game, takes you to play game. About takes you to this page, which considering you reading this, you already know. To go back simply scroll down the text window until you see a button which says back. Reload game simply starts a new game but with the same statistics you would have used in a previous game. Lastly the Rules button takes you to a age which briefly describes the rules of the game and explains what each option in the game does. Once you have selected to play a game, you are then taken to the character selection page where you can choose from 3 characters or to generate a random one. The difference between the characters is simply the level of stats in each category. For more about the categories, go to the Rules page. Once you have selected a character, you will be taken to the main game page where the text will display for the room, your stats and other choice you have through the game. The objective of the game is simple, get out before the horrible figure lurking inside the house comes out to kill you. The games can end in two ways, you find the key, or you kill the monster. The key has a small chance of appearing in each room, but is likely never going to appear. \n\nThis game is designed to be played over many game sessions, each game will be different as the items and rooms are randomly selected from a large pool. Thank you for the playing my game. Kind Regards, Alexander. \n\nDone as part of a university project at Deakin University, for SIT305.   ";
        //enables the text view to scroll freely
        scroller.setText(insideText);
        //load in the single button that is on the about page
        Button home = (Button) findViewById(R.id.aboutToHome);

        //create a on click listener to perform an action whel click. The action takes the user from about page to main activity.
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(about.this, MainActivity.class));
            }
        });
    }
}
