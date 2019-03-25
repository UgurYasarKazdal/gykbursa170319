package com.gyk.bursa162;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.gyk.bursa162.adapter.KonukAdapter;
import com.gyk.bursa162.helper.StringHelper;
import com.gyk.bursa162.models.malzemeler.Konuk;

import java.util.ArrayList;

public class KonukActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konuk);

        ListView listView = findViewById(R.id.listView_konuk);

        // ADIM1 satır tasarımı olusturma - item_konuk.xml

        //ADIM2 Veri Kümesi Oluşturma

        Konuk konuk1 = new Konuk("Arzu", 22, StringHelper.getFirstLetter(getString(R.string.bursa)));
        Konuk konuk2 = new Konuk("Yağmur", 23, StringHelper.getFirstLetter(getString(R.string.erzurum)));
        Konuk konuk3 = new Konuk("Hasibe", 21, StringHelper.getFirstLetter(getString(R.string.bursa)));
        Konuk konuk4 = new Konuk("Sibel", 23, StringHelper.getFirstLetter(getString(R.string.ankara)));


        ArrayList<Konuk> konuklar = new ArrayList<>();

        konuklar.add(konuk3);//position(index) 0
        konuklar.add(konuk2);//position(index) 1
        konuklar.add(konuk1);//position(index) 2
        konuklar.add(konuk4);//position(index) 3

        //ADIM3 Arapter
        KonukAdapter konukAdapter = new KonukAdapter(this, konuklar);

        //ADIM4 UI'i veri kümesine baglamak
        listView.setAdapter(konukAdapter);

    }
}
