package com.gyk.bursa162;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends Activity {
    private TextView mTvName;
    private TextView mTvCity;
    private TextView mTvWeb;
    private TextView mTvCv;
    ImageView mImageView;
    private final int REQUEST_SETTINGS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mTvName = findViewById(R.id.tv_profile_fullName);
        mTvCity = findViewById(R.id.tv_profile_city);
        mTvWeb = findViewById(R.id.tv_profile_web);
        mTvCv = findViewById(R.id.tv_profile_cv);
        mImageView = findViewById(R.id.img_profile);

        mTvName.setText(getIntent().getStringExtra("isim"));
        mTvCity.setText(getIntent().getStringExtra("city"));
        mTvWeb.setText(getIntent().getStringExtra("web"));
        mTvCv.setText(getIntent().getStringExtra("cv"));

        findViewById(R.id.imgBtn_profile_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                startActivityForResult(intent, REQUEST_SETTINGS);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SETTINGS) {
            if (resultCode == RESULT_OK) {

                mTvName.setText(data.getStringExtra("isim"));
                mTvCity.setText(data.getStringExtra("city"));
                mTvWeb.setText(data.getStringExtra("web"));

                //eger settings'de profil resmi gizle seçili ise, default resim gösterir
                if (data.getBooleanExtra("showImage", false)) {
                    mImageView.setImageResource(R.drawable.user_photo);
                } else {
                    mImageView.setImageResource(R.drawable.turkcell_logo);
                }

                //eger settings'de cv gizle seçili ise cv textview'i gizler
                if (data.getBooleanExtra("showCv", false)) {
                    mTvCv.setVisibility(View.INVISIBLE);
                } else {
                    mTvCv.setVisibility(View.VISIBLE);
                }
            }

            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "HİÇ AYAR YAPILMADI.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // layout içindeki city textview'in onclick attributes'inde çağrılıyor
    public void goMap(View v) {
        MapActivity.GEO = "geo:41.0315723,40.4765683";
        MapActivity.SEHIR = mTvCity.getText().toString();
        startActivity(new Intent(this, MapActivity.class));
    }
}
