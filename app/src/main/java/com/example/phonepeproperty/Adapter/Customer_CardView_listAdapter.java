package com.example.phonepeproperty.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phonepeproperty.Activity.Customer.CustomersFragment;
import com.example.phonepeproperty.Model.Customer;
import com.example.phonepeproperty.R;
import java.util.List;

public class Customer_CardView_listAdapter extends RecyclerView.Adapter<Customer_CardView_listAdapter.Customer_CardView_listViewHolder> {

    private Context mCtx;

    //we are storing all the products in a list
    private List<Customer> customerList;
    private CustomersFragment customersFragment;

    public Customer_CardView_listAdapter(Context mCtx, List<Customer> CustomerList) {
        this.mCtx = mCtx;
        this.customerList = CustomerList;
    }

    public Customer_CardView_listAdapter(CustomersFragment customersFragment, List<Customer> TaskList) {
        this.customersFragment=customersFragment;
        this.customerList=TaskList;
    }


    public Customer_CardView_listViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.customer_cardview_design, null);



        return new Customer_CardView_listViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull Customer_CardView_listViewHolder customerHolder, final int  position) {
       final Customer customerdetail = customerList.get(position);

        //binding the data with the viewholder views


        customerHolder.customer_Company.setText(String.valueOf(customerdetail.getCustomerCV_mCompany()));
        customerHolder.customer_Phone.setText(String.valueOf(customerdetail.getCustomerCV_mPhone()));
        customerHolder.customer_DateCreated.setText(String.valueOf(customerdetail.getCustomerCV_mDateCtreated()));
        customerHolder.customer_Interested.setText(String.valueOf(customerdetail.getCustomerCV_mInterested()));
        customerHolder.customer_ProjectName.setText(String.valueOf(customerdetail.getCustomerCV_mProjectName()));

    }


    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public void filterlist(List<Customer> filterdlist) {
            customerList = filterdlist;
            notifyDataSetChanged();
    }

    public class Customer_CardView_listViewHolder extends RecyclerView.ViewHolder {
        TextView customer_Id,customer_Company,customer_Phone,customer_DateCreated,customer_Interested,customer_ProjectName;
        CardView id;
        public Customer_CardView_listViewHolder(@NonNull View itemView) {
            super(itemView);
            customer_Company=itemView.findViewById(R.id.customer_cardview_company_name);
            customer_Phone=itemView.findViewById(R.id.customer_cardview_phone);
            customer_DateCreated=itemView.findViewById(R.id.customer_cardview_date_created);
            customer_Interested=itemView.findViewById(R.id.customer_cardview_interested);
            customer_ProjectName=itemView.findViewById(R.id.customer_cardview_project_name);
            id = itemView.findViewById(R.id.customer_cardview_id);
            }

      }
}
