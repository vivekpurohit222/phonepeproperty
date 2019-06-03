package com.example.phonepeproperty.Activity.Leads;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
import com.example.phonepeproperty.Adapter.Lead_CardView_listAdapter;
import com.example.phonepeproperty.Forms.Add_Leads;
import com.example.phonepeproperty.Model.LeadModel;
import com.example.phonepeproperty.Model.Mytask;
import com.example.phonepeproperty.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeadsFragment extends Fragment {

    RequestQueue mRequestQueue;
    JsonObjectRequest mJsonObjectRequest;
    RecyclerView task;
    String url="http://softieons.com/crmst/ws/lead/getalllead.php";
    EditText searchlead;
    List<LeadModel> LeadList;
    Lead_CardView_listAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Leads");
        View rootView=inflater.inflate(R.layout.fragment_leads, container, false);

         task= (RecyclerView) rootView.findViewById(R.id.lead_recyclerview);
         searchlead = rootView.findViewById(R.id.lead_search);
        LeadList=new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());


        Button add_Lead = (Button) rootView.findViewById(R.id.new_lead);
        add_Lead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pass the context and the Activity class you need to open from the Fragment Class, to the Intent
                Intent intent = new Intent(getActivity(),Add_Leads.class);
                startActivity(intent);
            }
        });

        jsonrequest();

        searchlead.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());

            }
        });

        return rootView;
    }
    private void filter(String s) {
        List<LeadModel> filterdlist = new ArrayList<>();
        for(LeadModel item : LeadList){
            if(item.getLeadCV_mName().toLowerCase().contains(s.toLowerCase())){
                filterdlist.add(item);
            }
            if(item.getLeadCV_mPhone().toLowerCase().contains(s.toLowerCase())){
                filterdlist.add(item);
            }
            if(item.getLeadCV_mSource().toLowerCase().contains(s.toLowerCase())){
                filterdlist.add(item);
            }


        }
        adapter.filterlist(filterdlist);
    }

    private void jsonrequest() {

        mJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("data");

                    for(int i=0;i< array.length();i++){

                        JSONObject data = array.getJSONObject(i);

                        LeadModel leadModel = new LeadModel();
                        leadModel.setLeadCV_mId(data.getInt("id"));
                        leadModel.setLeadCV_mAssigned(data.getString("assigned"));
                        leadModel.setLeadCV_mLastContact(data.getString("lastcontact"));
                        leadModel.setLeadCV_mName(data.getString("name"));
                        leadModel.setLeadCV_mPhone(data.getString("phonenumber"));
                        leadModel.setLeadCV_mSource(data.getString("source"));
                        leadModel.setLeadCV_mStatus(data.getString("status"));
                        LeadList.add(leadModel);

                        setrecyclerview();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
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

    private void setrecyclerview() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        task.setLayoutManager(llm);


        adapter = new Lead_CardView_listAdapter(this,  LeadList);
        task.setAdapter(adapter);


    }



}
