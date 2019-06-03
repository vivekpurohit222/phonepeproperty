package com.example.phonepeproperty.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phonepeproperty.Activity.Dashnoard.Latestactivity;
import com.example.phonepeproperty.Model.Latest;
import com.example.phonepeproperty.R;

import java.util.List;

public class Latest_adapter extends RecyclerView.Adapter<Latest_adapter.latestViewHolder> {
private Context mContext;
private List<Latest> mLatests;

    private Latestactivity latestactivity;

    public Latest_adapter(Context ctx, List<Latest> mlatest) {
        this.mContext = ctx;
        this.mLatests =mlatest;
    }

    public Latest_adapter(Latestactivity latestactivity, List<Latest> latestList) {
        this.latestactivity=latestactivity;
        this.mLatests=latestList;
    }

    @NonNull
    @Override
    public latestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.latest_carview, null);
        return new latestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull latestViewHolder holder, int position) {
        Latest latest = mLatests.get(position);
        holder.mday.setText(String.valueOf(latest.getDay()));
        holder.mactivity.setText(String.valueOf(latest.getActivity()));

    }

    @Override
    public int getItemCount() {
        return mLatests.size();
    }

    class latestViewHolder extends RecyclerView.ViewHolder{
            TextView mday,mactivity;
        public latestViewHolder(View itemView) {
            super(itemView);
            mday = itemView.findViewById(R.id.latest_dayreflect);
            mactivity = itemView.findViewById(R.id.latest_activity);

        }
    }
}
