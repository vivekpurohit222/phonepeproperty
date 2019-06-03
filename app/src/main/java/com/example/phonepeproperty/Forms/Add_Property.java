package com.example.phonepeproperty.Forms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.phonepeproperty.Activity.Property.PropertiesFragment;
import com.example.phonepeproperty.R;

public class Add_Property extends AppCompatActivity {

    private Spinner AddProperty_mType,AddProperty_mPropertyfor;
    private EditText AddProperty_mTitle,AddProperty_mDescription,AddProperty_mRate,AddProperty_mArea,AddProperty_mBhk,AddProperty_mName,AddProperty_mPhone,AddProperty_mEmail,AddProperty_mAddress,AddProperty_mState;
    private Button saveProperty,cancleForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__property);

        AddProperty_mTitle=(EditText) findViewById(R.id.property_title);
        AddProperty_mDescription=(EditText)findViewById(R.id.property_decription);
        AddProperty_mRate=(EditText)findViewById(R.id.property_rate);
        AddProperty_mArea=(EditText)findViewById(R.id.property_area);
        AddProperty_mBhk=(EditText)findViewById(R.id.property_bhk);
        AddProperty_mName=(EditText)findViewById(R.id.property_name);
        AddProperty_mPhone=(EditText)findViewById(R.id.property_phone);
        AddProperty_mEmail=(EditText)findViewById(R.id.property_emailid);
        AddProperty_mAddress=(EditText)findViewById(R.id.property_address);
        AddProperty_mState=(EditText)findViewById(R.id.property_state);
        saveProperty = findViewById(R.id.customer_save);
        cancleForm = findViewById(R.id.customer_cancel);
        AddProperty_mType=(Spinner)findViewById(R.id.property_type);
        AddProperty_mPropertyfor=(Spinner)findViewById(R.id.priority_for);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> property_type = ArrayAdapter.createFromResource(this,
                R.array.Property_type,R.layout.spinner_item);
// Specify the layout to use when the list of choices appears
        property_type.setDropDownViewResource(R.layout.spinner_item);
// Apply the adapter to the spinner
        AddProperty_mType.setAdapter(property_type);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> property_for = ArrayAdapter.createFromResource(this,
                R.array.Property_for,R.layout.spinner_item);
// Specify the layout to use when the list of choices appears
        property_for.setDropDownViewResource(R.layout.spinner_item);
// Apply the adapter to the spinner
        AddProperty_mPropertyfor.setAdapter(property_for);

        saveProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePropertyitem();
            }
        });
        cancleForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void savePropertyitem() {

    }

}
