package com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DBDataSource;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DataHelper;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model.MInputProspek;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Adapter.RecyclerViewAdapterProspekSA;
import com.naufalrafizi.dewarumah.R;

import java.util.ArrayList;
import java.util.List;

public class ProspekActivitySA extends AppCompatActivity {

    //inisialisasi kontroler
    DataHelper dbHelper;

    RecyclerView rvProspek;
    //inisialisasi arraylist
    List<MInputProspek> mList = new ArrayList<>();
    MInputProspek p;

    RecyclerViewAdapterProspekSA rvAdapterProspek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospek_sa);
        //inisialisasi widget
        dbHelper = new DataHelper(this);
        p = new MInputProspek();


        mList.addAll(dbHelper.getAllProspek());



        //buka kontroler


        //ambil semua data barang
//        mList= dataSource.getAllProspek();


        rvProspek = (RecyclerView)findViewById(R.id.rvProspek);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rvProspek.setLayoutManager(manager);

        rvAdapterProspek = new RecyclerViewAdapterProspekSA(getApplicationContext(),mList);
        rvProspek.setAdapter(rvAdapterProspek);



    }
}
