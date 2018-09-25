package com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Adapter.RecyclerViewAdapterDataGM;
import com.naufalrafizi.dewarumah.AfterLogin.SA.TokoSA.Adapter.RecyclerViewAdapterTokoSA;
import com.naufalrafizi.dewarumah.R;

public class DataGMActivity extends AppCompatActivity {

    RecyclerViewAdapterDataGM rvAdapterDataGM;

    String [] SA = {

            "Saiful"
    };

    String [] SCsaiful = {

            "Della"
    };

    String [] prospek = {
            " Robin,Dara,Juna"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_gm);


        setUpRecycler();

    }

    private void setUpRecycler() {

        RecyclerView rvListDataGM = (RecyclerView)findViewById(R.id.rvListDataGM);
        rvListDataGM.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvAdapterDataGM = new RecyclerViewAdapterDataGM(getApplicationContext(), SA,SCsaiful,prospek);
        rvListDataGM.setAdapter(rvAdapterDataGM);

    }
}
