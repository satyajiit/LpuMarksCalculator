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

public class SpecialCalc extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Spinner spinner,spinner2;
    private static final String[] paths = {"SELECT", "PEA", "PES" , "PEV" ,"PEL"};
    private static final String[] paths2 = {"End Term", "Reappear"};
    EditText s_ca1,s_ca2,s_ca3,s_ca4,s_attendance,s_midTerm;
    TextView s_tt_tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.pull_in_from_left, R.anim.hold);   // The new activity is pulled in from the left and the current activity is kept still

        setContentView(R.layout.special_calc);

        setUp(); //set up the Actionbar
        initViews(); //Init all the views and activates the spinner



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        if(position>0) AccessViews(true);
        else AccessViews(false);

        switch (position) {
            case 0:
                spinner2.setEnabled(false);
                s_tt_tip.setVisibility(View.GONE);
                break;
            case 1: //PEA
               spinner2.setEnabled(true);
                s_tt_tip.setVisibility(View.GONE);
                break;
            case 2: //PES
                spinner2.setEnabled(false);
                s_tt_tip.setVisibility(View.VISIBLE);
               break;
            case 3: //PEV
                spinner2.setEnabled(true);
                s_tt_tip.setVisibility(View.GONE);
                break;
            case 4: //PEL
                spinner2.setEnabled(true);
                s_tt_tip.setVisibility(View.GONE);
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
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.special)));
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("PE Courses");
        bar.show();

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "fonts/Cav.ttf");  //Change the fonts of the entire UI
        fontChanger.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));






    }

    public void initViews(){

        spinner = findViewById(R.id.s_courseSpinner);
        spinner2 = findViewById(R.id.s_examSpinner);

        s_ca1 = findViewById(R.id.s_ca1);
        s_ca2 = findViewById(R.id.s_ca2);
        s_ca3 = findViewById(R.id.s_ca3);
        s_ca4 = findViewById(R.id.s_ca4);
        s_attendance=findViewById(R.id.s_attendance);
        s_midTerm=findViewById(R.id.s_midTerm);

        s_tt_tip=findViewById(R.id.s_tt_tip);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SpecialCalc.this,
                android.R.layout.simple_spinner_item,paths);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(SpecialCalc.this,
                android.R.layout.simple_spinner_item,paths2);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

        spinner2.setEnabled(false);


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


    public void AccessViews(boolean b){
        s_ca1.setEnabled(b);
        s_ca2.setEnabled(b);
        s_ca3.setEnabled(b);
        s_ca4.setEnabled(b);
        s_attendance.setEnabled(b);
        s_midTerm.setEnabled(b);
    }

}
