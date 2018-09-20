package com.naufalrafizi.dewarumah.AfterLogin.SA.TokoSA.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naufalrafizi.dewarumah.AfterLogin.SA.TokoSA.Adapter.RecyclerViewAdapterTokoSA;
import com.naufalrafizi.dewarumah.R;

public class TokoActivitySA extends AppCompatActivity {

    RecyclerViewAdapterTokoSA rvAdapterTokoSA;

    int gambarBarang [] = {

            R.mipmap.ic_update,
            R.mipmap.ic_delete,
            R.mipmap.ic_launcher,
            R.mipmap.ic_profile,

    };

    String namaBarang []= {

            "Sapu",
            "Smart Phone",
            "Buku",
            "Mobil"

    };

    String hargaBarang [] = {

            "100 point",
            "20000 point",
            "30 point",
            "100000 point"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toko_sa);

        setUpRecycler();

    }

    private void setUpRecycler() {

        RecyclerView rvListTokoSA = (RecyclerView)findViewById(R.id.rvListTokoSA);
        rvListTokoSA.setLayoutManager(new GridLayoutManager(this,2));
        rvAdapterTokoSA = new RecyclerViewAdapterTokoSA(getApplicationContext(), gambarBarang,namaBarang,hargaBarang);
        rvListTokoSA.setAdapter(rvAdapterTokoSA);

    }
}
