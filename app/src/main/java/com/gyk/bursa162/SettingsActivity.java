package com.gyk.bursa162;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class SettingsActivity extends Activity {
    private EditText mEdtName;
    private EditText mEdtCity;
    private EditText mEdtCv;
    private CheckBox mChkShowImage;
    private CheckBox mChkShowCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mEdtName = findViewById(R.id.edt_settings_name);
        mEdtCity = findViewById(R.id.edt_settings_city);
        mEdtCv = findViewById(R.id.edt_settings_cv);

        mChkShowImage = findViewById(R.id.chk_settings_profile);
        mChkShowCV = findViewById(R.id.chk_settings_cv);

//buton'un tıklanmasını bir defa kullancagımız için direkt tanımlıyoruz
        findViewById(R.id.btn_settings_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("isim", mEdtName.getText().toString());
                intent.putExtra("city", mEdtCity.getText().toString());
                intent.putExtra("web", mEdtCv.getText().toString());
                intent.putExtra("showImage", mChkShowImage.isChecked());
                intent.putExtra("showCv", mChkShowCV.isChecked());

                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.btn_settings_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        findViewById(R.id.btn_settings_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdtName.setText("");
                mEdtCity.setText("");
                mEdtCv.setText("");
                mChkShowImage.setChecked(false);
                mChkShowCV.setChecked(false);
            }
        });


    }
}
