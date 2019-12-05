package com.example.a2bits.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2bits.R;
import com.example.a2bits.ui.login.categoriesActivity;

public class plaidsuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plaidsuccess);
<<<<<<< HEAD
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfile();
            }
        });
    }

=======
    Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openProfile();
        }
    });
}
>>>>>>> 49923980832c1f57b11564d233d1ad5dc39687cb
    public void openProfile(){
        Intent intent = new Intent(this, profileActivity.class);
        startActivity(intent);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 49923980832c1f57b11564d233d1ad5dc39687cb
