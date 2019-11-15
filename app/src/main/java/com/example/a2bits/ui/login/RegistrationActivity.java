package com.example.a2bits.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a2bits.R;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class RegistrationActivity extends AppCompatActivity {
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.registration);

            Button signUpButton = findViewById(R.id.signUp);
            signUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    signUp();
                }
            });
        }

    public void signUp(){
        final TextView userName = (TextView) findViewById(R.id.username);
        final TextView email = (TextView) findViewById(R.id.email);
        final TextView password = (TextView) findViewById(R.id.password);

        final TextView firstName = (TextView) findViewById(R.id.firstName);
        final TextView lastName = (TextView) findViewById(R.id.LastName);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://10.0.2.2:8000/api/users/";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RegistrationActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("debug", "signUp: "+ error);

                        Toast.makeText(RegistrationActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("username",userName.getText().toString());
                params.put("email",email.getText().toString());
                params.put("password",password.getText().toString());
            //    params.put("profile", {["first_Name", firstName.toString()],["last_name", lastName.toString()]};
                return params;
            }

        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }


}
