package com.goodchild.al_ro.thecurseoftheaireyhouse;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//code for saving text file taken from : https://stackoverflow.com/questions/17100886/how-to-write-an-array-to-a-text-file-on-internal-storage?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
        // create a variable that you want the text files name to be
        String filename = "house.txt";
        //create the content you want to bein in that text file and save it as a variable
        String[] numbers = new String[] {"This room is drenched in some sought of liquid. There is a faint light in the corner which seems to be illuminating a door with a handle shaped like a crow. There is a stool on which you can sit, but otherwise the room seems pretty bare.\n The room is filled with light. So much so its almost blinding. There are a lot of objects in the room but you can't quite seem to make out what they are.\n This room is filled with a strange orange glow. It seems like its coming from the centre of the room. As you get closer, you find a pentagram carved into the floor.\nOut of all the rooms you come across in this place... you wouldn't think to find a cemetary inside the house.\n You open the door to find yourself standing on a beach. A door seems to be stuck in the middle of the ocean. You swim to it.\n This room seems normal. Should Check it out., This room is filled with what looks like a little girls possessions. Not the best place to be when inside a haunted house.\n This room has ornate carvings everywhere. It seems once upon a time... this room was used as a carpentry workshop.\n hey! hey! over here! you want to by something? you find a shop but refuse to go in because the price of entrance is your life.\n As you walk in... Gravity seems to shift. All of a sudden you find yourself on the roof. You are now quite confused.\n This Room is christmas themed. How jolly.\n This room smells bad. You can tell something has been rotting in here.\nThis is an easter egg. Thanks for playing!\n You walk into a kitchen but everything that would normally be there like utensils... aren't!\n As you enter this room you smell gas. You feel sleepy but you must continue.\n As you enter, the room groans around you, it seems to be shrinking, better get out quick! \n You open the door and walk very casually, this room is filled with manikins. You walk past one, but hear a noise behind you. It seems they move every time you stop looking.\n Not many houses have a cinema, but apparently this one does. You can't help but think that if this house wasn't so haunted, it might have made for a pretty cool place. \n As you nervously plant both feet on the ground, you see a large shadowy figure coming towards you. You have no idea what to do, suddenly it vanishes.\n The door to this room says, What happens in Airey house stays here. You shrug and move on. Hard one you are.\n You enter the room to the smell of chicken, you are very hungry.\n You walk in and see a small pool in the middle, as you peer in, you see a murmaid but you cant touch her\n you find yourself in a library full of exquisite books about different spells, enchantments and of course, daemonic possession.\n You find yourself in the school yard with the guy who used to bully you, you punch him and he falls to the ground.\n you find yourself in an empty broom closet, similar to the one in harry potter\n You enter into a trance and fall to the floor, next thing you know your awake but you feel like something hit you on the head\n you find yourself in a kareoke bar with a whole heap of waiters who are willing to please\n you find yourself in a old style american diner, but no one is inside\n You come to a room with a door which has a whole, you peer though and see death traps set for you on the other side. Well i guess you gotta go through the other door.\n This room has a number on it, it seems like it could be leading you somewhere but your not sure.\n You walk into this room to find a whole heap of caged monsters, some with 6 arms, some with things implanted in there head. Oooo look zombies.\n Updon arriving at this specific courtyard, you look up and see a moon so large it looks bigger than the earth.\nA sign saying only the weak will get through this test, so you continue walking.\n a voice from behind you asks if your human, you quickly turn around but nothing is there\n this house seems to be taking a tole on you sanity, your not sure but you think someone has been following you for the past few rooms\n In the corridor you soo a bride, dressed in a huge dress. She stairs at you as he face slowly starts to melt.\n Wow you have come this far already! you are such a brave soul\n You walk in and all there is in this room is a bed.\n In the middle of the room is a board saying delssss\n A samll statue is in the middle of the room, it seems to be crying blood\n A small cave area appear before you, you decide not to go in and just continue searching.\n There is nothing here?\n You enter a mine but all the worker who are busy are skeletons. ONe looks and you and runs away'\n You can do it Keep going! You see a fountain with lots of coins in it.\n In the corner is a small shrine to a woman you dont know.\n you find yourself surounded by bugs, you must wade through to get to the next room\n In the corner is a nice silk gown hanging on the wall\n in the ceiling, you see priceless are which should never really have been here\n In te middle you find a checkers board, you play a little but then you keep moving\n you find a human sized chess set, you want to be like harry potter but you must continue\n In the centre of the room, you see a fish tank, inside hols something, maybe you should search it.\n Half of the room is painted pink, the other half black. How odd"};
        // create a new file output stream
        FileOutputStream outputStream;
        //Create a new directory and save it for later use, getfilesdir gets the directory directly from system and then add the name of the file on the end
        File file1 = new File(getApplicationContext().getFilesDir(),"house.txt");
        // check if the file exists
        if(file1.exists()){
            // print to system that file is safe
            System.out.println("File is there All is good.");
        }
        else{// if file is not there try and create it

            try {// placed in case of error
                //create new output stream with conetext private so it overwrites any files of the same name
                outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                // for each byte in numbers write it to the file
                for (String s : numbers) {
                    outputStream.write(s.getBytes());
                }
                // close the stream
                outputStream.close();
            } catch (Exception e) { // catch any errors that may arise
                e.printStackTrace();
            }

            System.out.println("File has been created");// confirm file has been created by printing out on system
        }


        // save a new filename called items.txt
        String filename1 = "items.txt";
        // save into a variable what you want the file to say
        String[] numbers1 = new String[] {"candle\n knife\nhuman hand\nsafety pin\n bread roll\n a shoe\n blue end of an eraser\n a keybaord\n pencap\n gun\n mini gun\n cork\n tennis racket\n beer\n a pair of tongs\n flame thrower\n cable ties\n rubber bands\n some keys\n a coin\n a towel\n a phone with no cell service\nA lawyer\n a speaker\n a knife\n cheese grater\n android programmer! Yay\n An old pocket watch in the shape of a love heart\n socks\n machine gun\n machete\n a necklace with the words all will perish on it\n quire a weired tunic which looks like its out of something like the Witcher games\n flowers\n A Vase\n someones foot\n a glass eye\n an oculus\n a jackhammer\n movie real\n a wrench\n plasma cutter\n portal gun\n a whip\n a steel sword\n a silver sword\n hidden blade\n a chain\n pulse rifle\n a smart pistol\n pipe bomb\nhellfire missile\na spade\n jetpack\na glaive\na morter\n cross bow\nshotgun\n Alien ray gun\n plasma grenades\n Rocket launcher\n magnet gun\n a lightsaber\nflailgun\nAWP Sniper\n sledgehammer\n crowbar\n Blades of Chaos\n The Mutator\n A hammer\n Gravity hammer\nwrist blade\nrailgun\napple\norange\nbanana\ngrapefruit\nsandwich\ncoffee grounds\n coffee mug\nstanley knife\n mandarin\n avocado\n stamps\n coffee pot\n newspaper\n shoe rack\n a blade heated with gas\n a sledhammer with a rocket on one side\n A heap of ammunition\n a turkey\n a dog\n a cat\n a car\n some keys\n A rack of lamb\nflare gun\n a menu from a place called Joel's\n a sweater\n some socks\n a raincoat\n umbrella\n a cane"};
        // create a new file output stream
        FileOutputStream outputStream1;
        //create a new file direcroty using get files direct so the directory is always correct + the name of you txt file
        File file11 = new File(getApplicationContext().getFilesDir(),"items.txt");
        if(file11.exists()){// if the file exists, print to system sayng its all good
            System.out.println("File is there All is good.");
        }
        else{ // if file does not exist, create it

            try {//catch the error if it should happen
                // create a file output with mode private so it overwrites any file with the same name
                outputStream1 = openFileOutput(filename1, Context.MODE_PRIVATE);
                // for each byte in the string we specified, write it to file
                for (String s : numbers1) {
                    outputStream1.write(s.getBytes());
                }
                // close the stream
                outputStream1.close();
            } catch (Exception e) { // collect any errors should there by any
                e.printStackTrace();
            }

            System.out.println("File has been created"); // print to system file has been created
        }




        // apply all buttons from xml to variables to access them
        Button play =  findViewById(R.id.gamebtn);
        Button about =  findViewById(R.id.aboutbtn);
        Button reload =  findViewById(R.id.reloadbtn);
        Button rules =  findViewById(R.id.rulesbtn);

        // if the player selects play, it takes them to the character selections screen
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, character_select.class));
            }
        });
        // if player selects about, it takes them to the about page
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, about.class));
            }
        });
        // if player selects reload, it takes them to the reload page
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, reload.class));
            }
        });
        // if player selects rules, it takes them to the reload page.
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, rules.class));
            }
        });

    }


}
