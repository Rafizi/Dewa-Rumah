package com.naufalrafizi.dewarumah.AfterLogin.SC.NotifSC.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naufalrafizi.dewarumah.AfterLogin.SC.NotifSC.Adapter.RecyclerAdapterNotifSC;
import com.naufalrafizi.dewarumah.R;

public class NotifSC extends AppCompatActivity {

    RecyclerAdapterNotifSC rvAdapterNotifSC;

    String [] nama = {

            "Saiful",
            "Anda",
            "Saiful",
            "Saiful"

    };

    String [] content ={

            "Anda telah berhasil masuk",
            "Data anda akan segera di proses",
            "Mendapatkan 1000 point",
            "Data anda akan segera di proses"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_sc);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        RecyclerView rvListNotifaSC = (RecyclerView)findViewById(R.id.rvNotifSC);
        rvListNotifaSC.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        rvAdapterNotifSC = new RecyclerAdapterNotifSC(getApplicationContext(),nama,content);
        rvListNotifaSC.setAdapter(rvAdapterNotifSC);

    }
}
