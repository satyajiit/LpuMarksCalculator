package com.satyajit.lpumarkscalculator;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TheoryCalc extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"End Term", "Reappear - 70M", "Reappear - 100M"};
    TextView t_tt_midTerm;
    EditText t_midTerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.pull_in_from_left, R.anim.hold);   // The new activity is pulled in from the left and the current activity is kept still

        setContentView(R.layout.theory_calc);

       setUp(); //set up the Actionbar
       initViews(); //Init all the views and activates the spinner



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {

            case 0: //End Term
                t_tt_midTerm.setVisibility(View.VISIBLE);
                t_midTerm.setVisibility(View.VISIBLE);
                break;

                case 1: //Re_70M


                case 2: //RE_100M

                t_tt_midTerm.setVisibility(View.GONE);
                t_midTerm.setVisibility(View.GONE);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
    @Override
    public boolean onSupportNavigateUp(){ //Handles when back is pressed in the action bar

        finish();
        return true;
    }

    public void setUp(){

        ActionBar bar= getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.theory)));
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("Theory and EL Courses");
        bar.show();


        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "fonts/Cav.ttf");  //Change the fonts of the entire UI
        fontChanger.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));

    }

    public void initViews(){

        t_midTerm=findViewById(R.id.t_midTerm);
        t_tt_midTerm=findViewById(R.id.t_tt_midTerm);
        spinner = findViewById(R.id.t_examSpinner);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(TheoryCalc.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }
    @Override
    protected void onPause() {
        // The new activity is kept still and this activity is pushed out to the left
        overridePendingTransition(R.anim.hold, R.anim.push_out_to_left);
        super.onPause();
    }
    public void showCSE(View v){
        startActivity(new Intent(this,CseCalc.class));
    }
    public void showMEC(View v){
        startActivity(new Intent(this,Mec103Calc.class));
    }

}
