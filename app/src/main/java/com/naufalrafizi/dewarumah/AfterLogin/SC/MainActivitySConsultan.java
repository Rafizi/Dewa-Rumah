package com.naufalrafizi.dewarumah.AfterLogin.SC;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Activity.ProspekActivitySA;
import com.naufalrafizi.dewarumah.AfterLogin.SC.DataAgentSC.Activity.DataAgentSC;
import com.naufalrafizi.dewarumah.R;

import me.relex.circleindicator.CircleIndicator;

public class MainActivitySConsultan extends AppCompatActivity {

    ViewPager viewPagerSc;
    ViewPagerAdapterSC vpAdapterSC;
    CircleIndicator indicatorSC;
    RecyclerViewAdapterSC rvAdapterSC;
    ImageView btnDataAgentSC,btnDataProspek;

    int [] ImagePromoSC = {

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
        setContentView(R.layout.activity_main_sconsultan);

        inisialisasi();

        setUpViewPager();
        setUpRecylerView();
        setMenu();

    }

    private void setMenu() {

        btnDataAgentSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DataAgentSC.class));
            }
        });

        btnDataProspek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProspekActivitySA.class));
            }
        });

    }

    private void inisialisasi() {

        btnDataAgentSC = (ImageView)findViewById(R.id.btnDataAgentSC);
        btnDataProspek = (ImageView)findViewById(R.id.btnDataProspek);

    }

    private void setUpViewPager() {
        viewPagerSc = (ViewPager) findViewById(R.id.vPagerSC);
        indicatorSC = (CircleIndicator)findViewById(R.id.circleSC);
        vpAdapterSC = new ViewPagerAdapterSC(this);
        viewPagerSc.setAdapter(vpAdapterSC);
        indicatorSC.setViewPager(viewPagerSc);
    }

    private void setUpRecylerView() {

        RecyclerView rvListPromoSA = (RecyclerView) findViewById(R.id.rvListPromoSC);
        rvListPromoSA.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvAdapterSC = new RecyclerViewAdapterSC(getApplication(),ImagePromoSC);
        rvListPromoSA.setAdapter(rvAdapterSC);

    }
}