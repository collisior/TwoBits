package com.example.a2bits.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
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

        donateButton.setOnClickListener(view -> {
            goToProfile();
            Log.d("donate button pressed", "PROCESS initiated");
            ArrayList<PlaidProduct> products = new ArrayList<>();
            products.add(PlaidProduct.TRANSACTIONS);
            Plaid.openLink(
                    healthActivity.this,
                    new LinkConfiguration.Builder("user_good", products).build(),
                    LINK_REQUEST_CODE);
        });
    }

    public void goToProfile(){
        Intent intent = new Intent(this, profileActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(
            int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LINK_REQUEST_CODE && data != null) {
            Log.d("ProfileActivityEvent", "Plaid done");
            if (Plaid.RESULT_SUCCESS == resultCode) {
                Log.d("resultCode", "RESULT_SUCCESS");
                LinkConnection item = (LinkConnection) data.getSerializableExtra(Plaid.LINK_RESULT);
                if (item != null) {
                    LinkConnectionMetadata metadata = item.getLinkConnectionMetadata();
                    Log.d("Public token = ", item.getPublicToken());
                }
            }
            else if (Plaid.RESULT_CANCELLED == resultCode) {
                Log.d("resultCode", "RESULT_CANCELLED");
            }
            else if (Plaid.RESULT_EXIT == resultCode) {
                Log.d("resultCode", "RESULT_EXIT");
            }
            else if (Plaid.RESULT_EXCEPTION == resultCode) {
                Log.d("resultCode", "RESULT_EXCEPTION");
            }
        }
    }
}