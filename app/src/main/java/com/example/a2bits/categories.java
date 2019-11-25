package com.example.a2bits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2bits.ui.healthActivity;
import com.example.a2bits.ui.login.categoriesActivity;

public class categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        Button signUpButton = findViewById(R.id.button3);
        signUpButton.setOnClickListener(new View.OnClickListener() {
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
