package com.moko.beaconx.activity;

import android.content.Intent;
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

        final Button button = findViewById(R.id.submit);
        final EditText etIpAddr = findViewById(R.id.etIpAddr);
        final EditText etStaffid = findViewById(R.id.etstaffid);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String value="Beacon test";
                Intent i = new Intent(InputActivity.this, MainActivity.class);
                i.putExtra("etIpAddr",value);
                i.putExtra("etstaffid",value);
                startActivity(i);
            }
        });
    }
}