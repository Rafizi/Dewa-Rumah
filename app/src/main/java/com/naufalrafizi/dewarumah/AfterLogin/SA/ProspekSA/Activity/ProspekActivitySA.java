package com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DBDataSource;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model.MInputProspek;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Adapter.RecyclerViewAdapterProspekSA;
import com.naufalrafizi.dewarumah.R;

import java.util.ArrayList;

public class ProspekActivitySA extends AppCompatActivity {

    //inisialisasi kontroler
    DBDataSource dataSource;

    //inisialisasi arraylist
    ArrayList<MInputProspek>mList = new ArrayList<>();

    RecyclerViewAdapterProspekSA rvAdapterProspek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospek_sa);
        //inisialisasi widget


        dataSource = new DBDataSource(this);

        //buka kontroler
        dataSource.open();

        //ambil semua data barang
        mList= dataSource.getAllProspek();

        RecyclerView rvProspek = (RecyclerView)findViewById(R.id.rvProspek);
        rvProspek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvAdapterProspek = new RecyclerViewAdapterProspekSA(getApplication(),mList);
        rvProspek.setAdapter(rvAdapterProspek);



    }
}
