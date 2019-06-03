package com.example.phonepeproperty.Activity.Dashnoard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.phonepeproperty.Adapter.Dash_MyTask_CardView_ListAdapter;
import com.example.phonepeproperty.Adapter.Latest_adapter;
import com.example.phonepeproperty.Model.Latest;
import com.example.phonepeproperty.Model.Mytask;
import com.example.phonepeproperty.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Latestactivity extends Fragment {


    Latest_adapter adapter;
    List<Latest> latestList;
    RecyclerView task;
    String url = "http://softieons.com/crmst/ws/getallreminder.php";
    JsonObjectRequest mJsonObjectRequest;
    RequestQueue mRequestQueue;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public Latestactivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_latestactivity, container, false);
        task= (RecyclerView) rootView.findViewById(R.id.latest_recycleview);
        latestList = new ArrayList<>();



        mRequestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());





        jsonrequest();
        return rootView;
    }

    private void jsonrequest() {

        mJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("data");

                    for(int i=0;i< array.length();i++){

                        JSONObject data = array.getJSONObject(i);


                        Latest latest = new Latest();
                        latest.setDay(data.getString("day"));
                        latest.setActivity(data.getString("activity"));
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
        });



        mRequestQueue.add(mJsonObjectRequest);
    }

    private void setrecyclerview() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        task.setLayoutManager(llm);
        adapter = new Latest_adapter(this,  latestList);
        task.setAdapter(adapter);

    }


}
