package com.gyk.bursa162;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DenemeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deneme);

        String emirim = getIntent().getStringExtra("emir");

        Toast.makeText(this, emirim, Toast.LENGTH_LONG).show();


        final EditText isim = findViewById(R.id.edt_benim2_isim);

        Button isimAl = findViewById(R.id.btn_benim2_isimAl);

        Button vazgec = findViewById(R.id.btn_benim2_vazgec);

        isimAl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("cevap", isim.getText().toString());
                setResult(RESULT_OK, intent);

                finish();

            }
        });

        vazgec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

    }
}
