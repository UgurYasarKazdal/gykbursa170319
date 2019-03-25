package com.gyk.bursa162;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SmsActivity extends Activity {

    private EditText mEdt_PhoneNumber;
    private EditText mEdt_Message;
    private Button mBtn_Gonder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        mBtn_Gonder = findViewById(R.id.btn_sms_gonder);
        mEdt_Message = findViewById(R.id.edt_sms_message);
        mEdt_PhoneNumber = findViewById(R.id.edt_sms_phoneNumber);

        mBtn_Gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendSms();
            }
        });

    }

    private void sendSms() {

        Uri uri = Uri.parse("smsto:" + mEdt_PhoneNumber.getText().toString());
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
        smsIntent.putExtra("sms_body", mEdt_Message.getText().toString());
        startActivity(smsIntent);
    }
}
