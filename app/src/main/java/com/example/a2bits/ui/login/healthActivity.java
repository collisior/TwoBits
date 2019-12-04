package com.example.a2bits.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.a2bits.R;
import androidx.appcompat.app.AppCompatActivity;

public class healthActivity extends AppCompatActivity {

    private static final int LINK_REQUEST_CODE = 1;
    private TextView contentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health);
        Log.d("", "donate button see");

        Button donateButton = findViewById(R.id.donateHealth);

        UserPlaidActivity.auhtorizePlaidUser(donateButton, healthActivity.this);

//        donateButton.setOnClickListener(view -> {
//
//            Log.d("donate button pressed", "PROCESS initiated");
//            ArrayList<PlaidProduct> products = new ArrayList<>();
//            products.add(PlaidProduct.TRANSACTIONS);
//            Plaid.openLink(
//                    healthActivity.this,
//                    new LinkConfiguration.Builder("user_good", products).build(),
//                    LINK_REQUEST_CODE);
//        });
    }
}
