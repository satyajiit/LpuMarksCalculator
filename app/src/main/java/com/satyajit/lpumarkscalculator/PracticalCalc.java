package com.satyajit.lpumarkscalculator;

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



public class PracticalCalc extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    private static final String[] paths = {"End Term", "Reappear"};
    EditText pn_mtp1,pn_mtp2;
    TextView pn_tt_mtp1,pn_tt_mtp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.pull_in_from_left, R.anim.hold);   // The new activity is pulled in from the left and the current activity is kept still

        setContentView(R.layout.activity_practical_n);

        setUp(); //set up the Actionbar
        initViews(); //Init all the views and activates the spinner



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                pn_mtp1.setVisibility(View.VISIBLE);
                pn_mtp2.setVisibility(View.VISIBLE);
                pn_tt_mtp1.setVisibility(View.VISIBLE);
                pn_tt_mtp2.setVisibility(View.VISIBLE);
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                pn_tt_mtp1.setVisibility(View.GONE);
                pn_tt_mtp2.setVisibility(View.GONE);
                pn_mtp1.setVisibility(View.GONE);
                pn_mtp2.setVisibility(View.GONE);
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
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.practical1)));
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("10 Practical Courses");
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
    public void initViews() {

        spinner = findViewById(R.id.pn_examSpinner);
        pn_mtp2=findViewById(R.id.pn_mtp2);
        pn_mtp1=findViewById(R.id.pn_mtp1);
        pn_tt_mtp1=findViewById(R.id.pn_tt_mtp1);
        pn_tt_mtp2=findViewById(R.id.pn_tt_mtp2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PracticalCalc.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(this);



    }

}
