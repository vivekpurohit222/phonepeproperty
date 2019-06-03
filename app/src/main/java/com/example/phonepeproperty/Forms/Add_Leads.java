package com.example.phonepeproperty.Forms;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.DataSetObserver;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.phonepeproperty.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Add_Leads extends AppCompatActivity  {
    private EditText mName, mPhone, mAddress, mEmailAddress, mBroker, mClientReply, mReminderDate, mReminderTime, mReminderNote;
    private Spinner mStatus, mProjectName, mInterested, mSource, mAssigned;
    Button mSave, mCancel;
    ArrayList<String> Status = new ArrayList<String>();
    ArrayList<String> source = new ArrayList<String>();
    ArrayList<String> assigned = new ArrayList<String>();
    ArrayList<String> interested = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_lead);

        mName = (EditText) findViewById(R.id.lead_name);
        mPhone = (EditText) findViewById(R.id.lead_phone);
        mAddress = (EditText) findViewById(R.id.lead_Address);
        mEmailAddress = (EditText) findViewById(R.id.lead_emailaddress);
        mClientReply = (EditText) findViewById(R.id.lead_clientreply);
        mStatus = (Spinner) findViewById(R.id.lead_status);
        mSource = (Spinner) findViewById(R.id.lead_source);
        mAssigned = (Spinner) findViewById(R.id.lead_assigned);
        mProjectName = (Spinner) findViewById(R.id.lead_projectname);
        mInterested = (Spinner) findViewById(R.id.lead_interested);
        mSave = (Button) findViewById(R.id.lead_save);
        mCancel = (Button) findViewById(R.id.lead_cancel);
        getData();


        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.spinner_item, interested);

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        mInterested.setAdapter(spinnerArrayAdapter);

        final ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                this, R.layout.spinner_item, Status);

        spinnerArrayAdapter1.setDropDownViewResource(R.layout.spinner_item);
        mStatus.setAdapter(spinnerArrayAdapter1);
        final ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this, R.layout.spinner_item, source);

        spinnerArrayAdapter2.setDropDownViewResource(R.layout.spinner_item);
        mSource.setAdapter(spinnerArrayAdapter2);

        final ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(
                this, R.layout.spinner_item, assigned);

        spinnerArrayAdapter3.setDropDownViewResource(R.layout.spinner_item);
        mAssigned.setAdapter(spinnerArrayAdapter3);



        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnewlead();
            }
        });
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void getData() {
        String url = "http://softieons.com/crmst/ws/leaddata.php";
        JsonObjectRequest mJsonObjectRequest;
        RequestQueue mRequestQueue;
        mRequestQueue = Volley.newRequestQueue(this);

        mJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject root = response.getJSONObject("data");
                    JSONObject data = root.getJSONObject("interested");

                    JSONArray option = data.getJSONArray("options");

                    for (int i = 0; i < option.length(); i++) {
                        interested.add(option.getString(i));
                    }

                }


                catch (JSONException e1) {
                    e1.printStackTrace();
                }
                try{
                    JSONObject root = response.getJSONObject("data");
                    JSONArray status = root.getJSONArray("status");

                    for (int i = 0; i < status.length(); i++) {
                        JSONObject name = response.getJSONObject("name");

                    }



                }
              catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                try {
                    Cache.Entry cacheEntry = HttpHeaderParser.parseCacheHeaders(response);
                    if (cacheEntry == null) {
                        cacheEntry = new Cache.Entry();
                    }
                    final long cacheHitButRefreshed = 3 * 60 * 1000; // in 3 minutes cache will be hit, but also refreshed on background
                    final long cacheExpired = 24 * 60 * 60 * 1000; // in 24 hours this cache entry expires completely
                    long now = System.currentTimeMillis();
                    final long softExpire = now + cacheHitButRefreshed;
                    final long ttl = now + cacheExpired;
                    cacheEntry.data = response.data;
                    cacheEntry.softTtl = softExpire;
                    cacheEntry.ttl = ttl;
                    String headerValue;
                    headerValue = response.headers.get("Date");
                    if (headerValue != null) {
                        cacheEntry.serverDate = HttpHeaderParser.parseDateAsEpoch(headerValue);
                    }
                    headerValue = response.headers.get("Last-Modified");
                    if (headerValue != null) {
                        cacheEntry.lastModified = HttpHeaderParser.parseDateAsEpoch(headerValue);
                    }
                    cacheEntry.responseHeaders = response.headers;
                    final String jsonString = new String(response.data,
                            HttpHeaderParser.parseCharset(response.headers));
                    return Response.success(new JSONObject(jsonString), cacheEntry);
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException e) {
                    return Response.error(new ParseError(e));
                }
            }

            @Override
            protected void deliverResponse(JSONObject response) {
                super.deliverResponse(response);
            }

            @Override
            public void deliverError(VolleyError error) {
                super.deliverError(error);
            }

            @Override
            protected VolleyError parseNetworkError(VolleyError volleyError) {
                return super.parseNetworkError(volleyError);
            }
        };


        mRequestQueue.add(mJsonObjectRequest);


    }


    private void addnewlead() {
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://softieons.com/crmst/ws/lead/addlead.php";
            JSONObject jsonBody = new JSONObject();

            jsonBody.put("name", mName.getText().toString());

            jsonBody.put("phone", mPhone.getText().toString());
            jsonBody.put("address", mAddress.getText().toString());
            jsonBody.put("email", mEmailAddress.getText().toString());
            jsonBody.put("phone", mClientReply.getText().toString());


            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };


            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}