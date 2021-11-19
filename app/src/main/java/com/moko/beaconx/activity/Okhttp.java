package com.moko.beaconx.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.moko.beaconx.R;

import java.io.IOException;

import androidx.annotation.NonNull;
import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Okhttp extends AppCompatActivity {

    // declare attribute for textview
    private TextView pagenameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
//        pagenameTextView = findViewById(R.id.pagename);

        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        String staff = sharedPreferences.getString("IpAddr","");
        String ip = sharedPreferences.getString("StaffID","");
        Log.d("test", staff + ip);


        TextView tvIpAddr = findViewById(R.id.tvIpAddr);
        TextView tvStaffid = findViewById(R.id.tvStaffid);

        tvIpAddr.setText(ip);
        tvIpAddr.setText(staff);


        // creating a client
        OkHttpClient okHttpClient = new OkHttpClient();

        //RequestBody formbody = new FormBody.Builder().add("value","be nice").add("","").build();
        //ASYNCHRONOUS POST REQUEST

//        Request request = new Request.Builder().url("http://192.168.1.123:5000/get").post(formbody).build();
        Bundle extras = getIntent().getExtras();
        String mac ="";
        if (extras != null) {
            mac = extras.getString("mac");
            //The key argument here must match that used in the other activity
        }
        //Request request = new Request.Builder().url("http://ec2-13-229-105-253.ap-southeast-1.compute.amazonaws.com:5000/getmacaddress?MACaddress="+mac+"'").build();
        Request request = new Request.Builder().url("http://13.212.254.10:5000/getmacaddress?MACaddress="+mac+"'").build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("asd","asd");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.d("res","On response log");
                pagenameTextView.setText(response.body().string());
            }
        });//handles multiple request


/*//ASYNCHRONOUS GET REQUEST
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://192.168.32.135:5000/").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("asd","asd");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                TextView textView=findViewById(R.id.textview);
                textView.setText(response.body().string());
            }
        });//handles multiple request*/
    }
    }
