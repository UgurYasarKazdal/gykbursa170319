package com.gyk.bursa162.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gyk.bursa162.R;
import com.gyk.bursa162.models.malzemeler.Konuk;

import java.util.ArrayList;

public class KonukAdapter extends BaseAdapter {

    Context context;
    ArrayList<Konuk> konuklar;

    public KonukAdapter(Context context, ArrayList<Konuk> konuklar) {
        this.context = context;
        this.konuklar = konuklar;
    }

    @Override
    public int getCount() {
        return konuklar.size();
    }

    @Override
    public Object getItem(int position) {
        return konuklar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View v = View.inflate(context, R.layout.item_konuk, null);
        TextView tvKonukAd = v.findViewById(R.id.tv_konuk_ad);
        TextView tvKonukYas = v.findViewById(R.id.tv_konuk_yas);
        TextView tvKonukDogumYeri = v.findViewById(R.id.tv_konuk_dogumYeri);

        tvKonukAd.setText(konuklar.get(position).getAd());
        tvKonukYas.setText(String.valueOf(konuklar.get(position).getYas()));
        tvKonukDogumYeri.setText(konuklar.get(position).getDogumYeri());

        return v;
    }
}
