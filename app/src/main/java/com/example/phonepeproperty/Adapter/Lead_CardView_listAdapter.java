package com.example.phonepeproperty.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phonepeproperty.Activity.Leads.LeadsFragment;
import com.example.phonepeproperty.Model.LeadModel;
import com.example.phonepeproperty.R;


import java.util.List;

public class Lead_CardView_listAdapter extends RecyclerView.Adapter<Lead_CardView_listAdapter.Lead_CardView_listViewHolder> {

    private Context mCtx;

    //we are storing all the products in a list
    private List<LeadModel> LeadList;
    LeadsFragment leadsFragment;

    public Lead_CardView_listAdapter(Context mCtx, List<LeadModel> leadList) {
        this.mCtx = mCtx;
        this.LeadList = leadList;
    }

    public Lead_CardView_listAdapter(LeadsFragment leadsFragment, List<LeadModel> leadList) {
       this.leadsFragment=leadsFragment;
       this.LeadList=leadList;
    }


    public Lead_CardView_listViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.lead_cardview_design, null);
        return new Lead_CardView_listViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Lead_CardView_listViewHolder leadHolder, int  position) {
        LeadModel leaddetail = LeadList.get(position);

        //binding the data with the viewholder views


        leadHolder.lead_Name.setText(String.valueOf(leaddetail.getLeadCV_mName()));
        leadHolder.lead_Phone.setText(String.valueOf(leaddetail.getLeadCV_mPhone()));
        leadHolder.lead_Assigned.setText(String.valueOf(leaddetail.getLeadCV_mAssigned()));
        leadHolder.lead_Status.setText(String.valueOf(leaddetail.getLeadCV_mStatus()));
        leadHolder.lead_Source.setText(String.valueOf(leaddetail.getLeadCV_mSource()));
        leadHolder.lead_LastContant.setText((String.valueOf(leaddetail.getLeadCV_mLastContact())));
        leadHolder.lead_Created.setText((String.valueOf(leaddetail.getLeadCV_mCreated())));
    }

    @Override
    public int getItemCount() {
        return LeadList.size();
    }

    public void filterlist(List<LeadModel> filterdlist) {
        LeadList = filterdlist;
        notifyDataSetChanged();
    }

    public class Lead_CardView_listViewHolder extends RecyclerView.ViewHolder {
        TextView lead_Id,lead_Name,lead_Phone,lead_Assigned,lead_Status,lead_Source,lead_LastContant,lead_Created;

        public Lead_CardView_listViewHolder(@NonNull View itemView) {
            super(itemView);
            lead_Name=itemView.findViewById(R.id.lead_cardview_name);
            lead_Phone=itemView.findViewById(R.id.lead_cardview_phone);
            lead_Assigned=itemView.findViewById(R.id.lead_cardview_assigned);
            lead_Status=itemView.findViewById(R.id.lead_cardview_status);
            lead_Source =itemView.findViewById(R.id.lead_cardview_Source);
            lead_LastContant=itemView.findViewById(R.id.lead_cardview_last_contact);
            lead_Created =itemView.findViewById(R.id.lead_cardview_created);

        }
    }


}