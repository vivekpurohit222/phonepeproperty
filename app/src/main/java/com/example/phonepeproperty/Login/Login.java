package com.example.phonepeproperty.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.phonepeproperty.Activity.Navigater.NavigationActivity;
import com.example.phonepeproperty.R;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener
{
     EditText mEmail,mPassword;
     TextView txt_error;
    private Button mSignin,mclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    mSignin=(Button)findViewById(R.id.signin);
    mEmail = findViewById(R.id.Email);
    mPassword = findViewById(R.id.Pass);

    mSignin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        checklogin();
    }

    private void checklogin() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "";
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Intent intent = new Intent(Login.this,NavigationActivity.class);
                    startActivity(intent);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Intent intent = new Intent(Login.this,NavigationActivity.class);
                startActivity(intent);

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();

                params.put("email",mEmail.getText().toString().trim());
                params.put("password",mPassword.getText().toString().trim());


                return super.getParams();

            }
        };
        requestQueue.add(stringRequest);
    }



}

