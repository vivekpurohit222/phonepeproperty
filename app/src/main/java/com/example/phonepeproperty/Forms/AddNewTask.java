package com.example.phonepeproperty.Forms;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.phonepeproperty.Activity.Leads.LeadsFragment;
import com.example.phonepeproperty.Model.Mytask;
import com.example.phonepeproperty.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

public class AddNewTask extends AppCompatActivity {
     int ts_mYear, ts_mMonth,ts_mDay,td_mYear,td_mMonth,td_mDay;
     EditText mSubject,mHourlyRate,mStartDate,mDueDate,mTaskDescription;
     Spinner mPriority,mRepeatEvery,mRelatedTo;
    Button mSave,mCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
        mSubject=(EditText)findViewById(R.id.task_subject);
        mHourlyRate=(EditText)findViewById(R.id.task_hourlyrate);
        mStartDate=(EditText)findViewById(R.id.task_startdate);
        mDueDate=(EditText)findViewById(R.id.task_duedate);
        mTaskDescription=(EditText)findViewById(R.id.task_taskdescription);
        mSave=(Button)findViewById(R.id.task_save);
        mCancel=(Button)findViewById(R.id.task_cancel);
        mPriority=(Spinner)findViewById(R.id.task_priority);
        mRelatedTo=(Spinner)findViewById(R.id.task_relatedto);
        mRepeatEvery=(Spinner)findViewById(R.id.task_repeatevery);
        mSave = findViewById(R.id.task_save);
        mCancel = findViewById(R.id.task_cancel);
        ArrayAdapter<CharSequence> priority = ArrayAdapter.createFromResource(this,
                R.array.task_priority, R.layout.spinner_item);
// Specify the layout to use when the list of choices appears
        priority.setDropDownViewResource(R.layout.spinner_item);
// Apply the adapter to the spinner
        mPriority.setAdapter(priority);

        ArrayAdapter<CharSequence> relatedto = ArrayAdapter.createFromResource(this,
                R.array.task_relatedto, R.layout.spinner_item);
// Specify the layout to use when the list of choices appears
        relatedto.setDropDownViewResource(R.layout.spinner_item);
// Apply the adapter to the spinner
        mRelatedTo.setAdapter(relatedto);

        ArrayAdapter<CharSequence> repeatevery = ArrayAdapter.createFromResource(this,
                R.array.task_repeatevery,R.layout.spinner_item);
// Specify the layout to use when the list of choices appears
        repeatevery.setDropDownViewResource(R.layout.spinner_item);
// Apply the adapter to the spinner
        mRepeatEvery.setAdapter(repeatevery);

        jsonGetData();

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask();
            }
        });
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewTask.this,LeadsFragment.class);
                startActivity(intent);
            }
        });

    }




    private void jsonGetData() {
        String url = "http://softieons.com/crmst/ws/getalltask.php";
        JsonObjectRequest mJsonObjectRequest;
        RequestQueue mRequestQueue;
        mRequestQueue = Volley.newRequestQueue(this);

        mJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject root = response.getJSONObject("data");
                    String a = root.getString("project");


                    } catch (JSONException e1) {
                    e1.printStackTrace();
                }

            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
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

    private void addTask() {
    }

    public void onClick(View v) {


        if (v == mStartDate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            ts_mYear = c.get(Calendar.YEAR);
            ts_mMonth = c.get(Calendar.MONTH);
            ts_mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            mStartDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, ts_mYear, ts_mMonth, ts_mDay);
            datePickerDialog.show();
        }
        if (v == mDueDate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            td_mYear = c.get(Calendar.YEAR);
            td_mMonth = c.get(Calendar.MONTH);
            td_mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            mDueDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, td_mYear, td_mMonth, td_mDay);
            datePickerDialog.show();
        }
    }




}
