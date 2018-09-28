package com.naufalrafizi.dewarumah.AfterLogin.GM;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Activity.DataGMActivity;
import com.naufalrafizi.dewarumah.AfterLogin.GM.NotifGM.Activity.NotifGM;
import com.naufalrafizi.dewarumah.R;

import me.relex.circleindicator.CircleIndicator;

public class MainActivityGM extends AppCompatActivity {

    ViewPager viewPagerGM;
    ViewPagerAdapterGm vpAdapterGM;
    CircleIndicator indicatorGM;
    RecylerViewAdapterGM rvAdapterSA;
    ImageView btnDataGM,btnNotifGM;

    int [] ImagePromoGM = {

            R.drawable.alana,
            R.drawable.ayana,
            R.drawable.rgv,
            R.drawable.felfest,
            R.drawable.felhill,
            R.drawable.gd2,
            R.drawable.gd3,
            R.drawable.gd4,
            R.drawable.rgdi

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_gm);

        inisialisasi();

        setUpViewPager();
        setUpRecylerView();
        setUpMenu();

    }

    private void setUpMenu() {

        btnNotifGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),NotifGM.class));
            }
        });

        btnDataGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DataGMActivity.class));
            }
        });

    }

    private void setUpRecylerView() {

        RecyclerView rvListPromoGM = (RecyclerView) findViewById(R.id.rvListPromoGM);
        rvListPromoGM.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvAdapterSA = new RecylerViewAdapterGM(getApplication(),ImagePromoGM);
        rvListPromoGM.setAdapter(rvAdapterSA);

    }

    private void setUpViewPager() {

        viewPagerGM = (ViewPager) findViewById(R.id.vPagerGM);
        indicatorGM = (CircleIndicator)findViewById(R.id.circleGM);
        vpAdapterGM = new ViewPagerAdapterGm(this);
        viewPagerGM.setAdapter(vpAdapterGM);
        indicatorGM.setViewPager(viewPagerGM);

    }

    private void inisialisasi() {

        btnNotifGM = (ImageView)findViewById(R.id.notifGM);
        btnDataGM = (ImageView)findViewById(R.id.btnDataGM);

    }
}
