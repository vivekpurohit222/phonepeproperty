package com.example.phonepeproperty.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phonepeproperty.Activity.Dashnoard.Dash_MyTask_CardView;
import com.example.phonepeproperty.Model.Mytask;
import com.example.phonepeproperty.R;

import java.util.ArrayList;
import java.util.List;

public class Dash_MyTask_CardView_ListAdapter extends RecyclerView.Adapter<Dash_MyTask_CardView_ListAdapter.TaskViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Mytask> taskList;
    private Dash_MyTask_CardView dash_myTask_cardView;

    //getting the context and product list with constructor
    public Dash_MyTask_CardView_ListAdapter(Context mCtx, List<Mytask> TaskList) {
        this.mCtx = mCtx;
        this.taskList = TaskList;
    }

    public Dash_MyTask_CardView_ListAdapter(Dash_MyTask_CardView dash_myTask_cardView, List<Mytask> TaskList) {
       this.dash_myTask_cardView=dash_myTask_cardView;
       this.taskList=TaskList;
    }




    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.mytask_cardview, null);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        //getting the product of the specified position
        Mytask dashdetail = taskList.get(position);

        //binding the data with the viewholder views

        holder.textViewName.setText(String.valueOf(dashdetail.getDash_mName()));
        holder.textViewStartDate.setText(dashdetail.getDash_mStartDate());
        holder.textViewDueDate.setText(dashdetail.getDash_mDueDate());

        holder.textViewStatus.setText(String.valueOf(dashdetail.getDash_mStatus()));
        holder.textViewPriority.setText(String.valueOf(dashdetail.getDash_mPriority()));


    }


    @Override
    public int getItemCount() {
        return taskList.size();

        }
        public void filterlist(List<Mytask> filterslist){
        taskList = filterslist;
        notifyDataSetChanged();
        }



    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView  textViewStartDate, textViewDueDate,textViewName;
        TextView textViewPriority,textViewStatus;

        public TaskViewHolder(View itemView) {
            super(itemView);


            textViewName = itemView.findViewById(R.id.dash_name);
            textViewStartDate = itemView.findViewById(R.id.dash_startdate);
            textViewDueDate = itemView.findViewById(R.id.dash_duedate);
            textViewPriority = itemView.findViewById(R.id.dash_priority);
            textViewStatus = itemView.findViewById(R.id.dash_status);
        }
    }

}
