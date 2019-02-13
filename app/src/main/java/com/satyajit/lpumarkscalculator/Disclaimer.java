package com.satyajit.lpumarkscalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

public class Disclaimer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.pull_in_from_left, R.anim.hold);   // The new activity is pulled in from the left and the current activity is kept still

        setContentView(R.layout.disclaimer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Displays the back icon or button in the action bar
        getSupportActionBar().show(); //Shows the ActionBar


        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "fonts/Cav.ttf");  //Change the fonts of the entire UI
        fontChanger.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));



    }

    @Override
    public boolean onSupportNavigateUp(){ //Handles when back is pressed in the action bar

        finish();
        return true;
    }

    @Override
    protected void onPause() {
        // The new activity is kept still and this activity is pushed out to the left
        overridePendingTransition(R.anim.hold, R.anim.push_out_to_left);
        super.onPause();
    }

}



