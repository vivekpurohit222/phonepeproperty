package com.example.phonepeproperty.Activity.Dashnoard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TabDashboard extends FragmentPagerAdapter {
    private static final int FRAGMENT_COUNT = 4;

    public TabDashboard(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Dash_MyTask_CardView();

            case 1:
                return new Chart();
            case 2:
                return new Dash_Myreminders();
            case 3:
                return new Latestactivity();

        }
        return null;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "My Tasks";
            case 1:
                return "Chart";
            case 2:
                return "My Reminders";
            case 3:
                return "Latest Activity";
        }
        return null;
    }
}
