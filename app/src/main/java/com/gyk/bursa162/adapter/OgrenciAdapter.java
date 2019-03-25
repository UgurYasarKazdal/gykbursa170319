package com.gyk.bursa162.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyk.bursa162.R;
import com.gyk.bursa162.models.malzemeler.Ogrenci;

import java.util.ArrayList;

public class OgrenciAdapter extends BaseAdapter {

    Context context;
    ArrayList<Ogrenci> ogrenciler;

    public OgrenciAdapter(Context context, ArrayList<Ogrenci> ogrenciler) {
        this.context = context;
        this.ogrenciler = ogrenciler;
    }

    @Override
    public int getCount() {
        return ogrenciler.size();
    }

    @Override
    public Object getItem(int position) {
        return ogrenciler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View v = View.inflate(context, R.layout.item_listview, null);

        ImageView resim = v.findViewById(R.id.img_itemListview);
        TextView tv_isim = v.findViewById(R.id.tv_itemListview_isimSoyisim);
        TextView tv_dogumTarihi = v.findViewById(R.id.tv_itemListview_tarih);

        resim.setImageResource(ogrenciler.get(position).resim);
        tv_isim.setText(ogrenciler.get(position).getIsimSoyisim());
        tv_dogumTarihi.setText(ogrenciler.get(position).dogumTarihi);
        return v;
    }

}
