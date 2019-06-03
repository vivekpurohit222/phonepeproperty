package com.example.phonepeproperty.Activity.Dashnoard;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phonepeproperty.R;


public class DashboardFragment extends Fragment {

    private CardView taskCard,chartCard,reminderCard,activityCard;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public DashboardFragment() {// Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Dashboard");
        View rootView =inflater.inflate(R.layout.fragment_dashboard, container, false);

        tabLayout = (TabLayout)rootView.findViewById(R.id.tabs);
        viewPager = (ViewPager)rootView.findViewById(R.id.view_pager);
        viewPager.setAdapter(new TabDashboard(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

       /* taskCard=(CardView) rootView.findViewById(R.id.mytasks);
        chartCard=(CardView) rootView.findViewById(R.id.chart);
        reminderCard=(CardView) rootView.findViewById(R.id.myreminders);
        activityCard=(CardView) rootView.findViewById(R.id.latestactivity);*/

        /*taskCard.setOnClickListener(this);
        chartCard.setOnClickListener(this);
        reminderCard.setOnClickListener(this);
        activityCard.setOnClickListener(this);*/


        return rootView;
    }


   /* @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.mytasks:
                Toast.makeText(getActivity(),
                        "Vivek", Toast.LENGTH_LONG).show();
                break;
            case R.id.chart:
                Toast.makeText(getActivity(),
                        "Aditya", Toast.LENGTH_LONG).show();
                break;
            case R.id.myreminders:
                Toast.makeText(getActivity(),
                        "Priyank", Toast.LENGTH_LONG).show();
                break;
            case R.id.latestactivity:
                Toast.makeText(getActivity(),
                        "Parth", Toast.LENGTH_LONG).show();
                break;
        }
    }*/
}