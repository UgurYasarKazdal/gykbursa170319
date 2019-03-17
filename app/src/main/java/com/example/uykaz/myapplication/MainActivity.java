package com.example.uykaz.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_Kek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_Kek = findViewById(R.id.tv_main_kek);
        Action kek = new Action();

        String olduMu = kek.kekYap();

        tv_Kek.setText(olduMu);

        tv_Kek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Main2.class);
                intent.putExtra("emir", "bana isim gönder");
                //    startActivity(intent);
                startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                tv_Kek.setText(data.getStringExtra("cevap"));
            }

            if (resultCode == RESULT_CANCELED) {
                tv_Kek.setText("MAIN 2 CEVAP VERMEDİ");
            }

        }
    }
}
