package com.moko.beaconx.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moko.beaconx.R;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_activity);

        final Button button = (Button) findViewById(R.id.submit);
        final EditText etIpAddr = (EditText) findViewById(R.id.etIpAddr);
        final EditText etStaffid = (EditText) findViewById(R.id.etStaffid);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                String ipAddr = (String) etIpAddr.getText().toString();
                String staffID = (String) etStaffid.getText().toString();

                editor.putString("IpAddr", ipAddr);
                editor.putString("StaffID", staffID);
                editor.apply();

                Intent i = new Intent(InputActivity.this, MainActivity.class);
                startActivity(i);

//                String ipAddr = (String) etIpAddr.getText().toString();
//                String staffID = (String) etStaffid.getText().toString();
//                Intent i = new Intent(InputActivity.this, MainActivity.class);
//                i.putExtra("IpAddr",ipAddr);
//                i.putExtra("StaffID",staffID);
            }
        });
    }
}