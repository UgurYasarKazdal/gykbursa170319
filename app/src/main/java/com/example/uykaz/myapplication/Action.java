package com.example.uykaz.myapplication;

import android.util.Log;

import com.example.uykaz.myapplication.models.malzemeler.Seker;
import com.example.uykaz.myapplication.models.malzemeler.Un;
import com.example.uykaz.myapplication.models.malzemeler.Yag;

public class Action {

    private Seker mSeker = new Seker(true);
    private Un mUn = new Un();
    private Yag mYag = new Yag();

    public String kekYap() {
        mSeker.agirlik = 20;
        mSeker.cesit = "Esmer";
        mSeker.renk = "esmer";

        mUn.agirlik = 100;
        mUn.cesit = "beyaz un";
        mUn.renk = "beyaz";
        mUn.setMarka("Seferoğlu");

        mYag.agirlik = 10;
        mYag.cesit = "zeytinyağı";
        mYag.renk = "yeşil";
        mYag.setAsit(1);

        return pisir();

    }

    private String pisir() {

        Log.d("KEK YAPILDI MI?", mSeker.renk + " şeker kullanarak" + String.valueOf(mUn.agirlik) + " un ile" + mYag.cesit + " kullanarak keki yaptım");

        return mSeker.renk + " şeker kullanarak" + String.valueOf(mUn.agirlik) + " un ile" + mYag.cesit + " kullanarak keki yaptım";
    }


}
