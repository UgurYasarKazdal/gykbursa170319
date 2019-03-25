package com.gyk.bursa162;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.gyk.bursa162.adapter.OgrenciAdapter;
import com.gyk.bursa162.models.malzemeler.Ogrenci;

import java.util.ArrayList;

public class OgrenciActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView liste = findViewById(R.id.listView_main2);

        // ADIM1: SATIR TASARIM DOSYASI
        //item_listview.xml

        //ADIM2-VERI MODELI OLUSTURMA

        Ogrenci ogrenci1 = new Ogrenci(R.drawable.tyron, "Ahmet", "19902532");
        Ogrenci ogrenci2 = new Ogrenci(R.drawable.arya, "Şafak", "2002");
        Ogrenci ogrenci3 = new Ogrenci(R.drawable.tyron, "Selim", "19651111");
        Ogrenci ogrenci4 = new Ogrenci(R.drawable.arya, "Murat", "1995");
        Ogrenci ogrenci5 = new Ogrenci(R.drawable.kralice, "Deanerys", "1990");
        Ogrenci ogrenci6 = new Ogrenci(R.drawable.jon, "Jon Snow", "1985");

        ArrayList<Ogrenci> ogrenciArrayList = new ArrayList<>();

        ogrenciArrayList.add(ogrenci2); //position 0
        ogrenciArrayList.add(ogrenci3);//position 1
        ogrenciArrayList.add(ogrenci4);//position 2
        ogrenciArrayList.add(ogrenci1); //position 3
        ogrenciArrayList.add(ogrenci5); //position 4
        ogrenciArrayList.add(ogrenci6); //position 5

        //ADIM3-ADAPTOR OLUSTUR
        OgrenciAdapter ogrenciAdapter = new OgrenciAdapter(this, ogrenciArrayList);

        //ADIM4-UI'YE BAGLAMAK
        liste.setAdapter(ogrenciAdapter);

        Toast.makeText(this, "Listemde " + String.valueOf(ogrenciAdapter.getCount()) + " adet ogrenci var.", Toast.LENGTH_LONG).show();

        findViewById(R.id.btn_main2_konukGoster).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OgrenciActivity.this, KonukActivity.class);
                startActivity(intent);
            }
        });
    }
}
