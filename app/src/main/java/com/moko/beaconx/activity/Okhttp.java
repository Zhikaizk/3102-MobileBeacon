package com.moko.beaconx.activity;

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
        pagenameTextView = findViewById(R.id.pagename);

        // creating a client
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody formbody = new FormBody.Builder().add("value","be nice").add("","").build();
        //ASYNCHRONOUS POST REQUEST

        Request request = new Request.Builder().url("http://192.168.1.123:5000/post").post(formbody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("asd","asd");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
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
