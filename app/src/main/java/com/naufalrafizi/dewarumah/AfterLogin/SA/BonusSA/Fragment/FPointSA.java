package com.naufalrafizi.dewarumah.AfterLogin.SA.BonusSA.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.naufalrafizi.dewarumah.AfterLogin.SA.TokoSA.Activity.TokoActivitySA;
import com.naufalrafizi.dewarumah.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FPointSA extends Fragment {

    Button btnBelanjaSA;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fpoint_sa, container, false);

        btnBelanjaSA = (Button)v.findViewById(R.id.btnBelanjaSA);

        btnBelanjaSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), TokoActivitySA.class));


            }
        });

        return v;

    }

}
