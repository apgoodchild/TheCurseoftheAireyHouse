package com.goodchild.al_ro.thecurseoftheaireyhouse;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // get both choice and length variables from previous pages of the app
        final String choice = getIntent().getStringExtra("choice");
        final String length = getIntent().getStringExtra("length");
        // create a new array list to store and help tranform user stats
        final ArrayList<String> list3 = new ArrayList<>();

        // create a file path straight to local files
        File yourFilePath = getFilesDir();
        // create a file path staright to the one above and the name of the text file
        File file = new File(yourFilePath,"/items.txt");
        // create  final copy to use outside of this method
        final File file1 = new File(yourFilePath,"/house.txt");
        // initilise variables used for game
        // make game key, when received, finished the game
        final int key = 0;
        // plyer health
        int health = 0;
        //player stamina stat
        int stamina = 0;
        // player sanity stat
        int sanity = 0;
        //player omen count
        int playerOmen = 0;
        // games required omens to finish the game
        int omen = 0;
        final ArrayList<Integer> list4 = new ArrayList<>();
        // new list for tranfoming user stats
        final ArrayList<Integer> omenList = new ArrayList<>();
        // new list for saving omen of both player and game
        // create a button for accssing the save game button
        Button save = findViewById(R.id.savebtn);





        // if the player chose 1 then the omen count would be set at 30
        if (length.equals("1")){
            omen = 30;
        }else if (length.equals("2")){// if player chose 2 then omen count would be set at 100
            omen = 100;
        }else if (length.equals("3")) {
            omen = 200;// if player chose 3 then omen count would be set at 200
        }else if (length.equals("4")){// if player chose to load a game then load it from the text file
            final File filer = new File(yourFilePath,"/save.txt"); // create a new fild
            // create a new array list for storing information from file
            final ArrayList<String> list9 = new ArrayList<>();
            //create a temp line reader
            String line5;
            try {// catch in case of error
                //create a buffer reader to access the file
                BufferedReader input = new BufferedReader(new FileReader(filer));
                // if the reader is not ready throw and exception
                if (!input.ready()) {
                    throw new IOException();
                }// while lin5 is not empty, save that data in list9
                while ((line5 = input.readLine()) != null) {
                    list9.add(line5);
                }
                // close inputs
                input.close();

            } catch (IOException e) {// catch any erros if ther were any
                System.out.println(e);
            }
            omen = Integer.parseInt(list9.get(3)); // save the players omen count from last game so they can continue

        }else {// else print out to system that oman was not loaded
            System.out.println("Oman Not Loaded");
        }
        //create a varibale thats the difference between the omans to get the number to display to user
        int showOmen = omen - playerOmen;
        // add that newly made player oman to both oman lists
        omenList.add(omen);
        omenList.add(playerOmen);

        // get access to all buttons and text views and assign values
        final TextView stats = findViewById(R.id.stattxt);
        final TextView desc = findViewById(R.id.desctxt);
        Button explorebtn = findViewById(R.id.explorebtn);
        Button observebtn = findViewById(R.id.observationbtn);
        final TextView keytxt = findViewById(R.id.keytxt);
        // Set text for key and omen area
        keytxt.setText("Key is not Found yet. Keep Trying! \nNo. of omens left until the monster finds you: "+showOmen );
        // depending on the players choices in the last few app pages, they will have chosen 1 of 4 ways of creating a character. Dpending on that nuber, the sats change accordingly
        if (choice.equals("1")){
            health = 10;
            stamina = 5;
            sanity = 1;
        }else if (choice.equals("2")){
            health = 5;
            stamina = 10;
            sanity = 1;
        }else if (choice.equals("3")){
            health = 1;
            stamina = 5;
            sanity = 10;
        }else if (choice.equals("4")){


            // randMain simply takes no arugements in and returns a random ineger value between 0 and 10.
            //e.g. when called randMain() --> returns int 5
            // this is used for randomising some code through the project.
            //eg. to get a random index of a list
            // to get a random amount of damage to a player
            health = randMain();
            stamina = randMain();
            sanity = randMain();
        }else if (choice.equals("5")){ // if the person chose to load a game file get the save game data
            final File filer = new File(yourFilePath,"/save.txt"); // create a new file path
            final ArrayList<String> list9 = new ArrayList<>(); //create a new array for storing user data
            String line5; // create temp line for storing data
            try {
                BufferedReader input = new BufferedReader(new FileReader(filer)); // create a buffered reader

                if (!input.ready()) {// if input isnt there throw and exception
                    throw new IOException();
                }
                while ((line5 = input.readLine()) != null) {
                    list9.add(line5); // while the temp input is not empty keep adding things from file to list9
                }
                input.close(); // close reader

            } catch (IOException e) { // throw excepton if there is an error
                System.out.println(e);
            }

            // set player stats from the newly created list we made
            health = Integer.parseInt(list9.get(0));
            stamina = Integer.parseInt(list9.get(1));
            sanity = Integer.parseInt(list9.get(2));

        // if any other value appear print out to sysm health erro
        } else{
            System.out.println("Error Setting Health");
        }
        // update text fields with players new stats
        stats.setText("Stats: Health: "+health+"   Stamina: "+stamina+"   Sanity: "+sanity);
        // add the new stats to the original palyer stats list
        list4.add(health);
        list4.add(stamina);
        list4.add(sanity);
        // code for this gotten from : https://stackoverflow.com/questions/17100886/how-to-write-an-array-to-a-text-file-on-internal-storage?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa


// This section of code is similar to above, using file reader to read and save elements from a text file.
        String line1;
        final ArrayList<String> list1 = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file1));

            if (!input.ready()) {
                throw new IOException();
            }
            while ((line1 = input.readLine()) != null) {
                list1.add(line1);
            }
            input.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        int hello =list1.size();
        System.out.println("house has "+hello);


// This section of code is similar to above, using file reader to read and save elements from a text file.

        String line;
        final ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));

            if (!input.ready()) {
                throw new IOException();
            }
            while ((line = input.readLine()) != null) {
                list.add(line);
            }
            input.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        int hello1 =list.size();
        System.out.println("items has:"+hello1);
        // save main menu button to variable for access
        Button returnMain =  findViewById(R.id.backMainbtn);
        // listening for main menu button so when press takes you back to mainActivity
        returnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(game.this, MainActivity.class));
            }
        });
        // Explore button listener, so when selected to does a series of actions to change player stats
        explorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // find the size of the list1
               int houseSize = list1.size();
                // randRoom creates a random number betweeen 0 and the number of indexes in roomList. This is done so a description can be pulled out at random.
                // e.g. when call randRoom takes one integr which is the number of entries in randRoom, then gives you a random number through a return of int to help you select a random incice in randRoom.
                //e.g. int 15--> rtuens a random ineger between 0 and 15
                // this is only used to select room descriptions randomly
               int roomSelect = randRoom(houseSize);
               // get the value of what ever is the place selected by the random number generater
               String roomDesc = list1.get(roomSelect);
               // change the text to refelct the new room
               desc.setText(roomDesc);
               // clear the lsit so it may b used again
               list3.clear();
                //create a new random number
                Random r = new Random();
                // set min to 0
                final int min = 0;
                //set max to 200
                final int max = 200;
                // use random function to get random number
                int random = r.nextInt((max - min) + 1) + min;
                // make variable to send to bext page in case of win condition
                int next = 0;
                // if number is equal to 102, the person has found the key and instanly wins the game
                if (random ==102){
                    // new intent which goes to the finish page directly
                    Intent intent = new Intent(getBaseContext(), finish.class);
                    // put the win condition in so winning text can be changed
                    intent.putExtra("win", next);
                    // start the activity
                    startActivity(intent);

                }
                //work out current omen value and save it in a variable
                int omenhy = omenList.get(0) - omenList.get(1);
                // check if oman is 0 if it is, sent to a new page with player stats and difficulty information.
                if (omenhy == 0){

                    Intent intent = new Intent(getBaseContext(), boxx.class);
                    intent.putExtra("stats", list4);
                    intent.putExtra("diff", length);
                    startActivity(intent);

                }


            }
        });



        observebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //find size of item list

                int itemSize =  list.size();
                // randItem creates a random number betweeen 0 and the number of indexes in itemLest. This is done so a description can be pulled out at random.
                // e.g. when call randItem takes one integr which is the number of entries in randItem, then gives you a random number through a return of int to help you select a random incice in randItem.
                //e.g. int 15--> rtuens a random ineger between 0 and 15
                // this is only used to select item descriptions randomly
                int itemSelect = randItem(itemSize);
                String itemDesc = list.get(itemSelect);
                // randMain simply takes no arugements in and returns a random ineger value between 0 and 10.
                //e.g. when called randMain() --> returns int 5
                // this is used for randomising some code through the project.
                //eg. to get a random index of a list
                // to get a random amount of damage to a player
                int itemget = randMain();

                // if item list size is lower that 1 then continue
                if (list3.size() <= 1){
                    // if the value of the random number is greater than 5, then contnue
                    if (itemget >= 5){
                        //save the numnber of items in item size
                        int itemSize1 = list.size();
                        // randRoom creates a random number betweeen 0 and the number of indexes in roomList. This is done so a description can be pulled out at random.
                        // e.g. when call randRoom takes one integr which is the number of entries in randRoom, then gives you a random number through a return of int to help you select a random incice in randRoom.
                        //e.g. int 15--> rtuens a random ineger between 0 and 15
                        // this is only used to select room descriptions randomly
                        int itemSelect1 = randRoom(itemSize1);
                        //get the randomly picked items value
                        String roomDesc = list.get(itemSelect1);
                        // creates a new alert dialog box with 3 choices
                        new AlertDialog.Builder(game.this) // first choice
                                .setTitle("You Found: "+roomDesc)
                                .setMessage("This item boosts you stats, which one would you like to boost?")
                                .setPositiveButton("Health", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        int abc = list4.get(0); // get the valye in list 4
                                        //add to the the value
                                        int abb = abc +2;
                                        // change the old value out with new one
                                        list4.set(0, abb);
                                        // update user stats
                                        stats.setText("Stats: Health: "+list4.get(0)+"   Stamina: "+list4.get(1)+"   Sanity: "+list4.get(2));
                                        //increase game oman counter
                                        int gameOmens = omenList.get(1) + 1;
                                        // set the new oman value in omanList
                                        omenList.set(1,gameOmens);
                                        // get the update value for the user
                                        int newOman = omenList.get(0) - omenList.get(1);
                                        //update the text values
                                        keytxt.setText("Key is not Found yet. Keep Trying! \nNo. of omens left until the monster finds you: "+newOman );



                                    }
                                }).setNegativeButton("Stamina", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) { // second option
                                int abc = list4.get(1); // get player stat
                                // get player stat and add 2
                                int abb = abc +2;
                                // place the new valuye in the original list
                                list4.set(1, abb);
                                // print the result
                                System.out.println(abb);
                                // update text
                                stats.setText("Stats: Health: "+list4.get(0)+"   Stamina: "+list4.get(1)+"   Sanity: "+list4.get(2));
                                // add oman to the meeter
                                int gameOmens = omenList.get(1) + 1;
                                // updates oman in list
                                omenList.set(1,gameOmens);
                                // updates the player oman count
                                int newOman = omenList.get(0) - omenList.get(1);
                                // updates oman info for user
                                keytxt.setText("Key is not Found yet. Keep Trying! \nNo. of omens left until the monster finds you: "+newOman );


                            }
                        }).setNeutralButton("Sanity", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { // 3rd option
                                int abc = list4.get(2); // get value
                                // add value
                                int abb = abc +2;
                                // update original list
                                list4.set(2, abb);
                                // update stats for user
                                stats.setText("Stats: Health: "+list4.get(0)+"   Stamina: "+list4.get(1)+"   Sanity: "+list4.get(2));
                                //add another oman
                                int gameOmens = omenList.get(1) + 1;
                                // omen list altered with new value
                                omenList.set(1,gameOmens);
                                //get new player value
                                int newOman = omenList.get(0) - omenList.get(1);
                                // update player text
                                keytxt.setText("Key is not Found yet. Keep Trying! \nNo. of omens left until the monster finds you: "+newOman );


                            }
                        })
                                .show();


                    }else {
                        Toast.makeText(getApplicationContext(), "You Found Nothing Sorry!",
                                Toast.LENGTH_SHORT).show();// creates a toast saying you found nothing

                    }
                }else {
                    Toast.makeText(getApplicationContext(), "You have found everything in this room!",
                            Toast.LENGTH_SHORT).show(); // creates a toast when after you have yoused explore once, this pop up

                }

                list3.add("hello");
                list3.add("hello"); // add these to list 3 in oder for for loop to run correctly




            }

        });

        // on click listener to save
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set file name to save.txt
                String filename = "save.txt";
                // get current oman value
                int currentOman = omenList.get(0) - omenList.get(1);
                // give player stats and omen value in string to save
                String[] numbers = new String[] {Integer.toString(list4.get(0))+"\n"+Integer.toString(list4.get(1))+"\n"+Integer.toString(list4.get(2))+"\n"+currentOman};
                FileOutputStream outputStream;// create new file stream
                try {// catch in case of error
                    // write in mode private to overwrite any file with the same name
                    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                    // for each bye, write to file
                    for (String s : numbers) {
                        outputStream.write(s.getBytes());
                    }
                    outputStream.close(); // close file stream
                } catch (Exception e) { // catch in case of error
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(), "Your progress has been saved",
                        Toast.LENGTH_SHORT).show();// show a toast saying the game has saved!
            }
        });


    }
// randMain simply takes no arugements in and returns a random ineger value between 0 and 10.
//e.g. when called randMain() --> returns int 5
// this is used for randomising some code through the project.
//eg. to get a random index of a list
// to get a random amount of damage to a player
    public int randMain(){
        // create a new random
        Random r = new Random();
        // create a min and max value you want the random value to be between
        final int min = 0;
        final int max = 10;
        // run it through the random function with +1 so its inclusive and +min so its one above the inclusive.
        final int random = r.nextInt((max - min) + 1) + min;
        // return and random number in a int variable
        return random;
    }

    // randRoom creates a random number betweeen 0 and the number of indexes in roomList. This is done so a description can be pulled out at random.
    // e.g. when call randRoom takes one integr which is the number of entries in randRoom, then gives you a random number through a return of int to help you select a random incice in randRoom.
    //e.g. int 15--> rtuens a random ineger between 0 and 15
    // this is only used to select room descriptions randomly
    public int randRoom(int number){
        // new random
        Random r = new Random();
        // set min to 0
        final int min = 0;
        // set max to max number in roomList -1
        final int max = number - 1;
        // do the random function
        final int random = r.nextInt((max - min) + 1) + min;
        //return a random number between the ones specified
        return random;
    }

    // randItem creates a random number betweeen 0 and the number of indexes in itemLest. This is done so a description can be pulled out at random.
    // e.g. when call randItem takes one integr which is the number of entries in randItem, then gives you a random number through a return of int to help you select a random incice in randItem.
    //e.g. int 15--> rtuens a random ineger between 0 and 15
    // this is only used to select item descriptions randomly
    public int randItem(int number){
        // create a new random function
        Random r = new Random();
        // set min to 0
        final int min = 0;
        // set max to itemList indice
        final int max = number - 1;
        // use the random feature
        final int random = r.nextInt((max - min) + 1) + min;
        //return a random integer to be used for picking out random items.
        return random;
    }



}

