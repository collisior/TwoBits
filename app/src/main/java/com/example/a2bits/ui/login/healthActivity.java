package com.example.a2bits.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.a2bits.R;
//import com.example.a2bits.ui.Adaptor;
//import com.example.a2bits.ui.Model;

import java.util.ArrayList;
//import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.viewpager.widget.ViewPager;

//import com.plaid.linkbase.models.BaseLinkConfiguration;
//import com.plaid.linkbase.models.LinkEventListener;


import com.plaid.link.Plaid;
import com.plaid.linkbase.models.LinkConfiguration;
import com.plaid.linkbase.models.LinkConnection;
import com.plaid.linkbase.models.LinkConnectionMetadata;
import com.plaid.linkbase.models.PlaidProduct;
//import kotlin.Unit;

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

        donateButton.setOnClickListener(view -> {

            Log.d("donate button pressed", "PROCESS initiated");
            ArrayList<PlaidProduct> products = new ArrayList<>();
            products.add(PlaidProduct.TRANSACTIONS);
            Plaid.openLink(
                    healthActivity.this,
                    new LinkConfiguration.Builder("user_good", products).build(),
                    LINK_REQUEST_CODE);
        });

    }


}