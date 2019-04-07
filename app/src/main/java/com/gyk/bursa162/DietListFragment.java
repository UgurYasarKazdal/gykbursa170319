package com.gyk.bursa162;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gyk.bursa162.adapter.OgrenciAdapter;
import com.gyk.bursa162.models.malzemeler.Ogrenci;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DietListFragment extends Fragment {

    public DietListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_list, container, false);

        ListView liste = view.findViewById(R.id.listView_dietListFr);
        Ogrenci ogrenci1 = new Ogrenci(R.drawable.onion, "Onion", "100K");
        Ogrenci ogrenci2 = new Ogrenci(R.drawable.domates, "Tomatoes", "80K");
        Ogrenci ogrenci3 = new Ogrenci(R.drawable.carrot, "Carrot", "50K");
        Ogrenci ogrenci4 = new Ogrenci(R.drawable.cucumber, "Cucumber", "150K");

        ArrayList<Ogrenci> ogrenciArrayList = new ArrayList<>();
        ogrenciArrayList.add(ogrenci2); //position 0
        ogrenciArrayList.add(ogrenci3);//position 1
        ogrenciArrayList.add(ogrenci4);//position 2
        ogrenciArrayList.add(ogrenci1); //position 3

        OgrenciAdapter ogrenciAdapter = new OgrenciAdapter(getContext(), ogrenciArrayList);
        liste.setAdapter(ogrenciAdapter);

        return view;
    }
}
