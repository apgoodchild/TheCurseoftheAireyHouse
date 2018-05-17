package com.goodchild.al_ro.thecurseoftheaireyhouse;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class boxx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxx);


        // both array lists and length are variable brought in from other pages to help keep persistant data betweek pages.
        //playerStat is player stats, bossStat is the creation of a blank list to use for boss stats
        // length is the variable the player chooses in how long they want to play, this number effect game difficulty.
        final ArrayList<Integer> playerStat = getIntent().getIntegerArrayListExtra("stats");
        final ArrayList<Integer> bossStat = new ArrayList<>();
        final String length = getIntent().getStringExtra("diff");

        //load all buttons and text views so they can be accessed locally. Final is placed to make them accessable outside of the current method.
        final TextView enemytxt = findViewById(R.id.bossstattxt);
        final TextView playertxt = findViewById(R.id.playerhealthtxt);
        Button mainmenu = findViewById(R.id.backMainbtn1);
        Button attackbtn = findViewById(R.id.attackbtn);
        Button dodgebtn = findViewById(R.id.evadebtn);
        final TextView descText = findViewById(R.id.desctxt);

        //create a listener so when the user preses the Main menu button, they are taken back to main menu
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(boxx.this, MainActivity.class));
            }
        });
        //take player stats out of playerStat list and put them in a text box for the player to see
        playertxt.setText("Player Stats: Health :"+playerStat.get(0)+"  Stamina: "+playerStat.get(1)+"  Sanity: "+playerStat.get(2));

        // This series of if statments refer to the difficulty of the game. The longer the player chose, the more damage the boss deals.
        //this is level one
        if (length.equals("1")){
            // The randMain method is used here to help generate a random number. The method takes 2 integer values, indicating highest and lowest value possible. It then gives back a random integer.
            // e.g randMain(10, 5) and it returns an integer.
            bossStat.add(0, randMain(25,30));
            bossStat.add(1, randMain(25,30));
            bossStat.add(2, randMain(25,30));
            enemytxt.setText("Boss Stats: Health :"+bossStat.get(0)+"  Stamina: "+bossStat.get(1)+"  Sanity: "+bossStat.get(2));
        //This is level 2
        }else if (length.equals("2")){
            bossStat.add(0, randMain(90,100));
            bossStat.add(1, randMain(90,100));
            bossStat.add(2, randMain(90,100));
            enemytxt.setText("Boss Stats: Health :"+bossStat.get(0)+"  Stamina: "+bossStat.get(1)+"  Sanity: "+bossStat.get(2));
        //This is level 3
        }else if (length.equals("3")){
            bossStat.add(0, randMain(190,200));
            bossStat.add(1, randMain(190,200));
            bossStat.add(2, randMain(190,200));
            enemytxt.setText("Boss Stats: Health :"+bossStat.get(0)+"  Stamina: "+bossStat.get(1)+"  Sanity: "+bossStat.get(2));
        //This is for a game where someone has loaded their own save file
        }else {
            bossStat.add(0, randMain(1,100));
            bossStat.add(1, randMain(1,100));
            bossStat.add(2, randMain(1,100));
            enemytxt.setText("Boss Stats: Health :"+bossStat.get(0)+"  Stamina: "+bossStat.get(1)+"  Sanity: "+bossStat.get(2));
        }

        //on click listener for the button labled attack
        attackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When the person clicks this button, it creates a android dialog box with 3 buttons. Players choose one of the buttons to select which statistic they would like to use to attack

                new AlertDialog.Builder(boxx.this)
                        .setTitle("You chose to Attack!")
                        .setMessage("Which stat would you like to attack with?")
                        // first button of dialog
                        .setPositiveButton("Health", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                //Get the first player stat
                                int calc1 = playerStat.get(0);
                                //Get the first boss stat
                                int calc2 = bossStat.get(0);
                                //subtract the two to get the new updated health of the boss
                                int calc3 = calc2 - calc1;
                                //replace the old health value of boss from bossList
                                bossStat.set(0, calc3);
                                //upodate the description panel to say what happend
                                descText.setText("You damaged the mad man! his health is now: "+calc3);
                                //update the boss text panel to show update stats
                                enemytxt.setText("Boss Stats: Health :"+bossStat.get(0)+"  Stamina: "+bossStat.get(1)+"  Sanity: "+bossStat.get(2));
                                //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                                //function takes 2 ArrayList[] values
                                //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                                //eg. checkStat(ham,ham)
                                checkStat(playerStat, bossStat);


                            }
                        }).setNegativeButton("Stamina", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                            // first player stat
                            int calc1 = playerStat.get(1);
                            // boss player stat
                            int calc2 = bossStat.get(1);
                            //subtract to get damage
                            int calc3 = calc2 - calc1;
                            //replace the value thats changed in the boss stat list
                            bossStat.set(1, calc3);
                            //update text values on page
                            descText.setText("You damaged the mad man! his Stamina is now: "+calc3);
                            enemytxt.setText("Boss Stats: Health :"+bossStat.get(0)+"  Stamina: "+bossStat.get(1)+"  Sanity: "+bossStat.get(2));

                        //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                        //function takes 2 ArrayList[] values
                        //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                        //eg. checkStat(ham,ham)
                            checkStat(playerStat, bossStat);





                    }
                }).setNeutralButton("Sanity", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //get first player
                        int calc1 = playerStat.get(2);
                        //get boss stat
                        int calc2 = bossStat.get(2);
                        //subtract the two
                        int calc3 = calc2 - calc1;
                        // replace old boss stat with new in bossList
                        bossStat.set(2, calc3);
                        //update text
                        descText.setText("You damaged the mad man! his Sanity is now: "+calc3);
                        enemytxt.setText("Boss Stats: Health :"+bossStat.get(0)+"  Stamina: "+bossStat.get(1)+"  Sanity: "+bossStat.get(2));

                        //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                        //function takes 2 ArrayList[] values
                        //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                        //eg. checkStat(ham,ham)
                        checkStat(playerStat, bossStat);

                    }
                })
                        .show();

                //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                //function takes 2 ArrayList[] values
                //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                //eg. checkStat(ham,ham)
                checkStat(playerStat, bossStat);


            }
        });

        //This on click listener is ther for the dodge button on this page. When the user clicks the button, it loads a dialog box which let them choose which stat to use to evade and then calculates the damage and updats both lists and text widgets.
        dodgebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on clikc a dialog box is created
                new AlertDialog.Builder(boxx.this)
                        .setTitle("You chose to Dodge!")
                        .setMessage("Which stat would you like to dodge with?")
                        // First choice or if they choose to use health
                        .setPositiveButton("Health", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // The randMain method is used here to help generate a random number. The method takes 2 integer values, indicating highest and lowest value possible. It then gives back a random integer.
                                // e.g randMain(10, 5) and it returns an integer.
                                // all uses of randMain do the same thing in this listener.
                                // in this case it returns a number between 1 and 5, the a series of if statments do actions according to the number
                                int hit = randMain(1,5);
                                // if the number is 1
                                if (hit == 1){
                                    //get player stat
                                    int hi1 = playerStat.get(0);
                                    // change the player stat to make it seem like damage
                                    hi1 = hi1 - 5;
                                    //update the player stat in playerList
                                    playerStat.set(0,hi1);
                                    //update text
                                    descText.setText("He hits you softly, as if to slap you with a glove. Health Decreased.");
                                    playertxt.setText("Player Stats: Health :"+playerStat.get(0)+"  Stamina: "+playerStat.get(1)+"  Sanity: "+playerStat.get(2));
                                    //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                                    //function takes 2 ArrayList[] values
                                    //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                                    //eg. checkStat(ham,ham)
                                    checkStat(playerStat, bossStat);

                                    //if the number is 2
                                }else if (hit == 2){
                                    //get player stat
                                    int hi1 = playerStat.get(0);
                                    //subtract the damage from player stat
                                    hi1 = hi1 - 10;
                                    //update player stat
                                    playerStat.set(0,hi1);
                                    //update text
                                    descText.setText("Ok,ok he hurt you but nothing to worry about. Health decreased. ");
                                    playertxt.setText("Player Stats: Health :"+playerStat.get(0)+"  Stamina: "+playerStat.get(1)+"  Sanity: "+playerStat.get(2));

                                    //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                                    //function takes 2 ArrayList[] values
                                    //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                                    //eg. checkStat(ham,ham)
                                    checkStat(playerStat, bossStat);

                                    // if the number is 3
                                }else if (hit == 3){
                                    //get player stat
                                    int hi1 = playerStat.get(0);
                                    //apply damage to player stat
                                    hi1 = hi1 - 25;
                                    //update player stat in playerList
                                    playerStat.set(0,hi1);
                                    //update text
                                    descText.setText("OK im surprised you not dead right now, Health reduced.");
                                    playertxt.setText("Player Stats: Health :"+playerStat.get(0)+"  Stamina: "+playerStat.get(1)+"  Sanity: "+playerStat.get(2));

                                    //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                                    //function takes 2 ArrayList[] values
                                    //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                                    //eg. checkStat(ham,ham)
                                    checkStat(playerStat, bossStat);
                                    //Any number above 3 is considered a seccussful dodge, therefor only text is updated
                                }else{
                                    //update text
                                    descText.setText("You Successfully dodge his attack! ");
                                    playertxt.setText("Player Stats: Health :"+playerStat.get(0)+"  Stamina: "+playerStat.get(1)+"  Sanity: "+playerStat.get(2));

                                    //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                                    //function takes 2 ArrayList[] values
                                    //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                                    //eg. checkStat(ham,ham)
                                    checkStat(playerStat, bossStat);
                                }
                        //Second choice, or if they choose to use stamin.
                            }
                        }).setNegativeButton("Stamina", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // The randMain method is used here to help generate a random number. The method takes 2 integer values, indicating highest and lowest value possible. It then gives back a random integer.
                        // e.g randMain(10, 5) and it returns an integer.
                        // all uses of randMain do the same thing in this listener.
                        // in this case it returns a number between 1 and 5, the a series of if statments do actions according to the number
                        int hit = randMain(1,5);
                        //if the number generated is 1
                        if (hit == 1){
                            // get player stat
                            int hi1 = playerStat.get(1);
                            //update player stat with damage
                            hi1 = hi1 - 5;
                            //update the stat in playerList
                            playerStat.set(1,hi1);
                            //update Text
                            descText.setText("He hits you softly, as if to slap you with a glove. Stamina Decreased.");
                            playertxt.setText("Player Stats: Health :"+playerStat.get(0)+"  Stamina: "+playerStat.get(1)+"  Sanity: "+playerStat.get(2));

                            //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                            //function takes 2 ArrayList[] values
                            //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                            //eg. checkStat(ham,ham)
                            checkStat(playerStat, bossStat);
                            //if the number is 2
                        }else if (hit == 2){
                            //get player stat
                            int hi1 = playerStat.get(1);
                            //update the stat with damage
                            hi1 = hi1 - 10;
                            //update the stat in player Stat
                            playerStat.set(1,hi1);
                            //update text
                            descText.setText("Ok,ok he hurt you but nothing to worry about. Stamina decreased. ");
                            playertxt.setText("Player Stats: Health :"+playerStat.get(0)+"  Stamina: "+playerStat.get(1)+"  Sanity: "+playerStat.get(2));

                            //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                            //function takes 2 ArrayList[] values
                            //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                            //eg. checkStat(ham,ham)
                            checkStat(playerStat, bossStat);
                            // if the number is 3
                        }else if (hit == 3){
                            // get player stat
                            int hi1 = playerStat.get(1);
                            //update the stat with damage
                            hi1 = hi1 - 25;
                            // update the stat in PlayerStat
                            playerStat.set(1,hi1);
                            //update texts
                            descText.setText("OK im surprised you not dead right now, Stamina reduced.");
                            playertxt.setText("Player Stats: Health :"+playerStat.get(0)+"  Stamina: "+playerStat.get(1)+"  Sanity: "+playerStat.get(2));

                            //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                            //function takes 2 ArrayList[] values
                            //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                            //eg. checkStat(ham,ham)
                            checkStat(playerStat, bossStat);
                            //Anything about 5 is considered a successful dodge, only text is updated.
                        }else{
                            descText.setText("You Successfully dodge his attack! ");
                        }






                    }
                    // third button or if the player chooses to use sanity
                }).setNeutralButton("Sanity", new DialogInterface.OnClickListener() {
                    @Override//a on click method for the dialog box
                    public void onClick(DialogInterface dialog, int which) {
                        checkStat(playerStat, bossStat);

                        // The randMain method is used here to help generate a random number. The method takes 2 integer values, indicating highest and lowest value possible. It then gives back a random integer.
                        // e.g randMain(10, 5) and it returns an integer.
                        // all uses of randMain do the same thing in this listener.
                        // in this case it returns a number between 1 and 5, the a series of if statments do actions according to the number
                        int hit = randMain(1,5);
                        // if the number generated is 1
                        if (hit == 1){
                            //get player stat
                            int hi1 = playerStat.get(2);
                            //update player stat with damage
                            hi1 = hi1 - 5;
                            // update player stat in playerList
                            playerStat.set(2,hi1);
                            //update texts
                            descText.setText("He hits you softly, as if to slap you with a glove. Sanity Decreased.");
                            playertxt.setText("Player Stats: Health :"+playerStat.get(0)+"  Stamina: "+playerStat.get(1)+"  Sanity: "+playerStat.get(2));

                            //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                            //function takes 2 ArrayList[] values
                            //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                            //eg. checkStat(ham,ham)
                            checkStat(playerStat, bossStat);
                            //if the number generated is 2
                        }else if (hit == 2){
                            //get player stat
                            int hi1 = playerStat.get(2);
                            //update stat with damage
                            hi1 = hi1 - 10;
                            // update stat in playerList
                            playerStat.set(2,hi1);
                            //Update Text
                            descText.setText("Ok,ok he hurt you but nothing to worry about. Sanity decreased. ");
                            playertxt.setText("Player Stats: Health :"+playerStat.get(0)+"  Stamina: "+playerStat.get(1)+"  Sanity: "+playerStat.get(2));

                            //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                            //function takes 2 ArrayList[] values
                            //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                            //eg. checkStat(ham,ham)
                            checkStat(playerStat, bossStat);
                            //if the number generated is 3
                        }else if (hit == 3){
                            // get number for player stat
                            int hi1 = playerStat.get(2);
                            // uodate number to reflect damage
                            hi1 = hi1 - 25;
                            // upodate numbder in playerList
                            playerStat.set(2,hi1);
                            //update text
                            descText.setText("OK im surprised you not dead right now, Sanity reduced.");
                            playertxt.setText("Player Stats: Health :"+playerStat.get(0)+"  Stamina: "+playerStat.get(1)+"  Sanity: "+playerStat.get(2));

                            //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                            //function takes 2 ArrayList[] values
                            //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                            //eg. checkStat(ham,ham)
                            checkStat(playerStat, bossStat);
                        }else{// anything above a 5 is considered to be a successful dodge
                            descText.setText("You Successfully dodge his attack! ");

                            //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
                            //function takes 2 ArrayList[] values
                            //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
                            //eg. checkStat(ham,ham)
                            checkStat(playerStat, bossStat);
                        }



                    }
                })
                        .show();



            }
        });



    }
    // The randMain method is used here to help generate a random number. The method takes 2 integer values, indicating highest and lowest value possible. It then gives back a random integer.
    // e.g randMain(10, 5) and it returns an integer.
    // all uses of randMain do the same thing in this listener.
    // in this case it returns a number between 1 and 5, the a series of if statments do actions according to the number
    public int randMain(int min1, int max1){ // input 2 integer numbers
        Random r = new Random(); // create new random
        final int min = min1; // save first number
        final int max = max1; // save second number
        final int random = r.nextInt((max - min) + 1) + min; // calculate random
        return random; // return a single random integer
    }
    //This function when called, checks to see if the player, or bosses statistics has reached 0, if they have it takes them to the apropriate page, if not, it does nothing.
    //function takes 2 ArrayList[] values
    //eg. new ArrayList[Integer] ham = new ArrayList[Integer]
    //eg. checkStat(ham,ham)
    public void checkStat(ArrayList<Integer> player, ArrayList<Integer> enemy){
       // if any of the players statistics found in playerList are found to be below or equal to 0, the game ends with the player taken back to the main screen. A toast is also shown to explain what happened.
        if (player.get(0)<=0 || player.get(1)<=0 || player.get(2)<=0){
            Toast.makeText(getApplicationContext(), "Woops, you died. Back to menu i guess.",
                    Toast.LENGTH_LONG).show();
            startActivity(new Intent(boxx.this, MainActivity.class));
        }
        //the Enemies EnemyList is checked. If it contains any 0's, then the player wins, and the player is taken to the finish page and a toast is shown congratulating them.
        if (enemy.get(0)<=0 || enemy.get(1)<=0 || enemy.get(2)<=0){
            Toast.makeText(getApplicationContext(), "You Won! You Won congrats!.",
                    Toast.LENGTH_LONG).show();
            int next = 1;
            Intent intent = new Intent(getBaseContext(), finish.class);
            intent.putExtra("win", next);
            startActivity(intent);


        }

    }
}
