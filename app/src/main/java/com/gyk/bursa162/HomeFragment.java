package com.gyk.bursa162;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TextView tvSonuc;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final EditText edtBoy = view.findViewById(R.id.edt_homeFragment_boy);
        final EditText edtKilo = view.findViewById(R.id.edt_homeFragment_kilo);
        tvSonuc = view.findViewById(R.id.tv_homeFragment_sonuc);

        view.findViewById(R.id.btn_homeFragment_hesapla).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double boy = Double.parseDouble(edtBoy.getText().toString());
                Double kilo = Double.parseDouble(edtKilo.getText().toString());

                Double sonuc = kilo / (boy * boy);

                tvSonuc.setText(String.valueOf(sonuc));

            }
        });

        return view;
    }

    public String getSonuc() {
        return tvSonuc.getText().toString();
    }

}
