package com.example.a2bits.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a2bits.R;

import org.json.JSONException;
import org.json.JSONObject;

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

        public void openCategories(){
            Intent intent = new Intent(this, categoriesActivity.class);
            startActivity(intent);
        }

    public void signUp(){


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://10.0.2.2:8000/api/users/";
        JSONObject jsonObject = null;
        try {
           jsonObject = getJsonObject();
        } catch (JSONException e) {

        }
        Log.d("JSONOBJECT",jsonObject.toString());
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST,url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(RegistrationActivity.this,response.toString(),Toast.LENGTH_LONG).show();
                        openCategories();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }

//        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Toast.makeText(RegistrationActivity.this,response,Toast.LENGTH_LONG).show();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d("debug", "signUp: "+ error);
//
//                        Toast.makeText(RegistrationActivity.this,error.toString(),Toast.LENGTH_LONG).show();
//                    }
//                }){
//            @Override
//            protected Map<String,String> getParams(){
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("username",userName.getText().toString());
//                params.put("email",email.getText().toString());
//                params.put("password",password.getText().toString());
//
//
//                params.put("profile", firstName.getText().toString());
//                params.put("last_name", lastName.getText().toString());
//
//                try {
//                    params.put("profile", getJsonObject(firstName.getText().toString(), lastName.getText().toString()));
//                }catch(JSONException e){}
//                return params;
//            }





        };

        // Add the request to the RequestQueue.
        queue.add(jsonObjReq);

    }

    private JSONObject getJsonObject() throws JSONException {
        final TextView userName = (TextView) findViewById(R.id.username);
        final TextView email = (TextView) findViewById(R.id.email);
        final TextView password = (TextView) findViewById(R.id.password);

        final TextView firstName = (TextView) findViewById(R.id.firstName);
        final TextView lastName = (TextView) findViewById(R.id.LastName);
        JSONObject userObject = new JSONObject();
        JSONObject profileJson = new JSONObject();
        userObject.put("username",userName.getText().toString());
        userObject.put("email",email.getText().toString());
        userObject.put("password",password.getText().toString());
        profileJson.put("first_name", firstName.getText().toString());
        profileJson.put("last_name", lastName.getText().toString());
        userObject.put("profile", profileJson);
        return userObject;
    }


}
