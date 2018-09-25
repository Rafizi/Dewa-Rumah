package com.naufalrafizi.dewarumah.AfterLogin.SA.ProfilSA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

public class ProfilActivitySA extends AppCompatActivity {

    TextView txtNamaProfilSA,txtNoTelpProfilSA,txtAlamatProfilSA;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_sa);

        nama = getIntent().getStringExtra("nama");
        txtNamaProfilSA = (TextView)findViewById(R.id.txtNamaProfilSA);
        txtNoTelpProfilSA= (TextView)findViewById(R.id.txtNoTelpProfilSA);
        txtAlamatProfilSA = (TextView)findViewById(R.id.txtAlamatProfilSA);

        txtNamaProfilSA.setText("Nama : " + nama);


    }
}
