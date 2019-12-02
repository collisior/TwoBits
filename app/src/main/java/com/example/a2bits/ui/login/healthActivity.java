package com.example.a2bits.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2bits.R;

import androidx.appcompat.app.AppCompatActivity;

public class healthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health);

        Button donateButton = findViewById(R.id.donateHealth);
        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payHealth();
            }
        });

    }

    public void payHealth(){
        //fill out api for plaid

    }
}
