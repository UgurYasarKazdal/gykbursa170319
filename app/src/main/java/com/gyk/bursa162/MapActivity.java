package com.gyk.bursa162;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MapActivity extends AppCompatActivity {

    Button openMapPage;

    public static String GEO = "geo:41.0138400,28.9496600";
    public static String SEHIR = "İstanbul";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        openMapPage = (Button) findViewById(R.id.open_map_page);
        openMapPage.setText(SEHIR + "'e git");

        // 40.099472, 29.059489
        openMapPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //İstanbul enlem ve boylam
                Uri geoLocation = Uri.parse(GEO);
                showMap(geoLocation);
            }
        });
    }


    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
