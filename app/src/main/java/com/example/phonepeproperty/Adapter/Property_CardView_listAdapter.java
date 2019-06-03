package com.example.phonepeproperty.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phonepeproperty.Activity.Property.PropertiesFragment;
import com.example.phonepeproperty.Model.Property;
import com.example.phonepeproperty.R;

import java.util.List;

public class Property_CardView_listAdapter extends RecyclerView.Adapter<Property_CardView_listAdapter.Property_CardView_listViewHolder> {

private Context mCtx;

//we are storing all the products in a list

private List<Property> propertyList;

private PropertiesFragment propertiesFragment;

public Property_CardView_listAdapter(Context mCtx, List<Property> PropertyList) {
        this.mCtx = mCtx;
        this.propertyList = PropertyList;
        }

    public Property_CardView_listAdapter(PropertiesFragment propertiesFragment, List<Property> propertyList) {
       this.propertiesFragment=propertiesFragment;
       this.propertyList=propertyList;
    }


    public Property_CardView_listViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.property_cardview_design, null);
        return new Property_CardView_listViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull Property_CardView_listViewHolder propertyHolder, int  position) {
        Property Propertydetail = propertyList.get(position);

        //binding the data with the viewholder views


        propertyHolder.property_ProjectTitle.setText(String.valueOf(Propertydetail.getPropertyCV_mProjectTitle()));
        propertyHolder.property_ProjectTitle.setText(String.valueOf(Propertydetail.getPropertyCV_mProjectTitle()));
        propertyHolder.property_PropertyType.setText(String.valueOf(Propertydetail.getPropertyCV_mPropertyType()));
        propertyHolder.property_PropertyFor.setText(String.valueOf(Propertydetail.getPropertyCV_mPropertyFor()));
        propertyHolder.property_PartyName.setText(String.valueOf(Propertydetail.getPropertyCV_mPartyName()));

        }

@Override
public int getItemCount() {
        return propertyList.size();
        }

    public void filterlist(List<Property> filterdlist) {
    propertyList = filterdlist;
    notifyDataSetChanged();
    }

    public class Property_CardView_listViewHolder extends RecyclerView.ViewHolder {
    TextView property_Id,property_ProjectTitle,property_Rate,property_PropertyType,property_PropertyFor,property_PartyName;

    public Property_CardView_listViewHolder(@NonNull View itemView) {
        super(itemView);
        property_ProjectTitle=itemView.findViewById(R.id.property_cardview_project_title);
        property_Rate =itemView.findViewById(R.id.property_cardview_rate);
        property_PropertyType=itemView.findViewById(R.id.property_cardview_property_type);
        property_PropertyFor=itemView.findViewById(R.id.property_cardview_property_for);
        property_PartyName=itemView.findViewById(R.id.property_cardview_party_name);


    }


}


}