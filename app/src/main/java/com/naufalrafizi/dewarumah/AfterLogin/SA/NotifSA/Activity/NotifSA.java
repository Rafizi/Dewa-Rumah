

package com.naufalrafizi.dewarumah.AfterLogin.SA.NotifSA.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naufalrafizi.dewarumah.AfterLogin.SA.NotifSA.Adapter.RecyclerAdapterNotifSA;
import com.naufalrafizi.dewarumah.R;

public class NotifSA extends AppCompatActivity {

    RecyclerAdapterNotifSA rvAdapterNotifSA;

    String [] nama = {

            "Saiful",
            "Saiful",
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
        setContentView(R.layout.activity_notif_sa);

        setUpRecyclerView();


    }

    private void setUpRecyclerView() {

        RecyclerView rvListNotifaSA = (RecyclerView)findViewById(R.id.rvNotifSA);
        rvListNotifaSA.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvAdapterNotifSA = new RecyclerAdapterNotifSA(getApplicationContext(),nama,content);
        rvListNotifaSA.setAdapter(rvAdapterNotifSA);

    }
}
