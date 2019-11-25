package com.example.a2bits.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.a2bits.R;

import androidx.appcompat.app.AppCompatActivity;

public class categoriesActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        Button healthButton = findViewById(R.id.button3);
        healthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHealth();
            }
        });
    }

    public void openHealth(){
        Intent intent = new Intent(this, healthActivity.class);
        startActivity(intent);
    }
}
