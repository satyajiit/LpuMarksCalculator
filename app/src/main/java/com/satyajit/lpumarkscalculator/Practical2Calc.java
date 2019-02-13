package com.satyajit.lpumarkscalculator;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

public class Practical2Calc extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.pull_in_from_left, R.anim.hold);   // The new activity is pulled in from the left and the current activity is kept still

        setContentView(R.layout.activity_practical_c);

        setUp(); //set up the Actionbar




    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }


    @Override
    public boolean onSupportNavigateUp(){ //Handles when back is pressed in the action bar

        finish();
        return true;
    }

    public void setUp(){

        ActionBar bar= getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.practical2)));
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("04 Practical Courses");
        bar.show();

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "fonts/Cav.ttf");  //Change the fonts of the entire UI
        fontChanger.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));





    }

    @Override
    protected void onPause() {
        // The new activity is kept still and this activity is pushed out to the left
        overridePendingTransition(R.anim.hold, R.anim.push_out_to_left);
        super.onPause();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }


}
