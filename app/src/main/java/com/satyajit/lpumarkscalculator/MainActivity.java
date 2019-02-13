package com.satyajit.lpumarkscalculator;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton theoryBtn,specialBtn,practicalBtn,practical2Btn;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();  //Hides the Actionbar

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "fonts/Cav.ttf");  //Change the fonts of the entire UI
        fontChanger.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));

        initItems(); //Initialise the views
        startAnim(); //Strat animating the items

    }



    public void initItems(){
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate_in);
        theoryBtn=findViewById(R.id.theory_button_ui);
        specialBtn=findViewById(R.id.special_button_ui);
        practicalBtn=findViewById(R.id.practical_button_n_ui);
        practical2Btn=findViewById(R.id.practical_button_c_ui);
    }

    public void startAnim(){
        theoryBtn.startAnimation(animation);
        specialBtn.startAnimation(animation);
        practicalBtn.startAnimation(animation);
        practical2Btn.startAnimation(animation);
    }

    public void shwDisclaimerActivity(View v){

        startActivity(new Intent(this,Disclaimer.class));
    }
    public void shwTheoryActivity(View v){

        startActivity(new Intent(this,TheoryCalc.class));
    }
    public void shwSpecialActivity(View v){

        startActivity(new Intent(this,SpecialCalc.class));
    }

    public void shwPracticalActivity(View v){

        startActivity(new Intent(this,PracticalCalc.class));
    }
    public void shwPractical2Activity(View v){

        startActivity(new Intent(this,Practical2Calc.class));
    }


}
