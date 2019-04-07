package com.gyk.bursa162;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HealthFragment extends Fragment {


    public HealthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // bu fragment'e veri aktarılmışsa kontrolü
        if (getArguments() != null) {
            if (getArguments().get("sonuc").equals("")) {
                Toast.makeText(getContext(), "HESAPLAMA YAPILMADI", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), getArguments().getString("sonuc"), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "VERİ GÖNDERİMİ YAPILMADI", Toast.LENGTH_SHORT).show();
        }

        return inflater.inflate(R.layout.fragment_health, container, false);
    }

}
