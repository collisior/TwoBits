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

public class UserPlaidActivity extends AppCompatActivity{
    private static final int LINK_REQUEST_CODE = 1;
    private TextView contentTextView;

    public static void auhtorizePlaidUser(Button button, AppCompatActivity activity) {
        button.setOnClickListener(view -> {

            Log.d("donate button pressed", "PROCESS initiated");
            ArrayList<PlaidProduct> products = new ArrayList<>();
            products.add(PlaidProduct.TRANSACTIONS);
            Plaid.openLink(activity,
                    new LinkConfiguration.Builder("user_good", products).build(),
                    LINK_REQUEST_CODE);
        });
    }

    public void onButtonShowPopupWindowClick() {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.plaid_error, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(findViewById(android.R.id.content).getRootView(), Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
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
                onButtonShowPopupWindowClick();
                Log.d("resultCode", "RESULT_CANCELLED");
            }
            else if (Plaid.RESULT_EXIT == resultCode) {
                onButtonShowPopupWindowClick();
                Log.d("resultCode", "RESULT_EXIT");
            }
            else if (Plaid.RESULT_EXCEPTION == resultCode) {
                onButtonShowPopupWindowClick();
                Log.d("resultCode", "RESULT_EXCEPTION");
            }
        }
    }
}