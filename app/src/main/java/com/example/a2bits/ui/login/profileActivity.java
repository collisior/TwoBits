package com.example.a2bits.ui.login;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2bits.R;
import com.example.a2bits.ui.Adaptor;
import com.example.a2bits.ui.Model;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class profileActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adaptor adaptor;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    public void gotoRegir(){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Button toRegir = findViewById(R.id.button7);
        toRegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoRegir();
            }
        });

//        Title: Android Swipe Views using Viewpager
//        Author: Haerul Muttaqin
//        Date: 2019
//        Code version: 1.0https://www.youtube.com/watch?v=UsXv6VRqZKs

//        models = new ArrayList<>();
//        models.add(new Model(R.drawable.redcross, "Charity Interests",
//                "American Red Cross", "@americanredcross"));
//        models.add(new Model(R.drawable.helenkeller, "Charity Interests",
//                "Helen Keller International", "@hellenkellerinternational"));
//
//        adaptor = new Adaptor(models, this);
//        viewPager = findViewById(R.id.viewPager);
//        viewPager.setAdapter(adaptor);
//        viewPager.setPadding(0,0,0,0);
//
//        Integer[] colors_temp = {
//                getResources().getColor(R.color.white),
//                getResources().getColor(R.color.white)
//        };
//
//        colors = colors_temp;
//
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if(position < (adaptor.getCount() -1) && position < (colors.length - 1)){
//                    viewPager.setBackgroundColor(
//
//                            (Integer) argbEvaluator.evaluate(
//                                    positionOffset,
//                                    colors[position],
//                                    colors[position + 1]
//                            )
//                    );
//                }else{
//                    viewPager.setBackgroundColor(colors[colors.length - 1]);
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }
}
