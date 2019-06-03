package com.example.phonepeproperty.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phonepeproperty.Activity.Dashnoard.Dash_Myreminders;
import com.example.phonepeproperty.Model.Myreminder;
import com.example.phonepeproperty.R;

import java.util.List;

public class Reminder_adapter extends RecyclerView.Adapter<Reminder_adapter.ReminderViewHolder> {
    private Context mContext;
    private List<Myreminder> mMyreminders;

    private Context mCtx;

    //we are storing all the products in a list

    private Dash_Myreminders mDash_Dash_myreminders_cardView;

    public Reminder_adapter(Context mCtx, List<Myreminder> mMyreminders) {
        this.mContext = mCtx;
        this.mMyreminders = mMyreminders;
    }

    public Reminder_adapter(Dash_Myreminders dash_myReminders_cardView, List<Myreminder> TaskList) {
        this.mDash_Dash_myreminders_cardView = dash_myReminders_cardView;
        this.mMyreminders =TaskList;
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_reminders, null);
        return new ReminderViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ReminderViewHolder holder, int position) {

        Myreminder reminders = mMyreminders.get(position);

        //binding the data with the viewholder views
        holder.textViewRelatedTo.setText(reminders.getRelatedTo());
        holder.textViewDesc.setText(reminders.getDescription());
        holder.textViewDate.setText(String.valueOf(reminders.getDate()));

    }

    @Override
    public int getItemCount() {
        return mMyreminders.size();
    }

    class ReminderViewHolder extends RecyclerView.ViewHolder {
        TextView textViewRelatedTo, textViewDesc, textViewDate;

        public ReminderViewHolder(View itemView) {
            super(itemView);
            textViewRelatedTo = itemView.findViewById(R.id.reminder_relatedTo);
            textViewDesc = itemView.findViewById(R.id.reminder_description);
            textViewDate = itemView.findViewById(R.id.reminder_date);

        }
    }
 }
