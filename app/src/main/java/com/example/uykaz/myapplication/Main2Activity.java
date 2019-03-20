package com.example.uykaz.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

/*    private String[] ulkeler =
            {"Türkiye", "Almanya", "Avusturya", "Amerika", "İngiltere",
                    "Macaristan", "Yunanistan", "Rusya", "Suriye", "İran", "Irak",
                    "Şili", "Brezilya", "Japonya", "Portekiz", "İspanya",
                    "Makedonya", "Ukrayna", "İsviçre"};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView liste = findViewById(R.id.listView_main2);

/*
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);

        liste.setAdapter(adapter);
*/

        // ADIM1: SATIR TASARIM DOSYASI
        //item_listview.xml

        //ADIM2-VERI MODELI OLUSTURMA

        Ogrenci ogrenci1 = new Ogrenci(R.drawable.tyron, "Tyrion", "1990");
        Ogrenci ogrenci2 = new Ogrenci(R.drawable.arya, "Arya", "2002");
        Ogrenci ogrenci3 = new Ogrenci(R.drawable.tyron, "Tywin", "1965");
        Ogrenci ogrenci4 = new Ogrenci(R.drawable.arya, "Sansa", "1995");
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

    }
}
