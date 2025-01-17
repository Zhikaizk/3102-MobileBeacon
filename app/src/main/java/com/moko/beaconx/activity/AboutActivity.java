package com.moko.beaconx.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.moko.beaconx.R;
import com.moko.beaconx.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AboutActivity extends BaseActivity {
    @BindView(R.id.app_version)
    TextView appVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        appVersion.setText(String.format("Version:%s", Utils.getVersionInfo(this)));

        final Button button = (Button) findViewById(R.id.okHttpbtn);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(AboutActivity.this, Okhttp.class);
                startActivity(i);
            }
        });

    }

    @OnClick({R.id.tv_back, R.id.tv_company_website})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_company_website:
//                Uri uri = Uri.parse("https://" + getString(R.string.company_website));
//                Intent intent = new Intent(Intent.ACTION_VIEW, Testin);
                Bundle extras = getIntent().getExtras();
                String mac ="";
                if (extras != null) {
                     mac = extras.getString("mac");
                    //The key argument here must match that used in the other activity
                }
                Intent i = new Intent(AboutActivity.this, Okhttp.class);
                Log.i("testing",mac);
                i.putExtra("mac",mac);
                startActivity(i);
//                Intent myIntent = new Intent(AboutActivity.this, Okhttp.class);
//                startActivity(Testing);
                AboutActivity.this.startActivity(i);
                
                break;
        }
    }
}
