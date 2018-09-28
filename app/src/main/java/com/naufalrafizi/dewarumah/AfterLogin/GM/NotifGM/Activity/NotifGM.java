package com.naufalrafizi.dewarumah.AfterLogin.GM.NotifGM.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naufalrafizi.dewarumah.AfterLogin.GM.NotifGM.Adapter.RecyclerAdapterNotifGM;
import com.naufalrafizi.dewarumah.R;

public class NotifGM extends AppCompatActivity {

    RecyclerAdapterNotifGM rvAdapterNotifGM;

    String [] tier = {

            "SA",
            "SA",
            "SC",
            "SA"

    };

    String [] nama = {

            "Surya",
            "Alan",
            "Herry",
            "Marko"

    };

    String [] content ={

            "Telah Sign Up",
            "memasukan prsopek",
            "Memasukan SA",
            "Prospek telah akad"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_gm);

        setUpRecylerView();

    }

    private void setUpRecylerView() {

        RecyclerView rvListDataGM = (RecyclerView)findViewById(R.id.rvNotifGM);
        rvListDataGM.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvAdapterNotifGM = new RecyclerAdapterNotifGM(getApplicationContext(), tier,nama,content);
        rvListDataGM.setAdapter(rvAdapterNotifGM);

    }
}
