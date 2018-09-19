package com.naufalrafizi.dewarumah.AfterLogin.SA;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.naufalrafizi.dewarumah.AfterLogin.SA.BonusSA.Activity.BonusActivitySA;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProfilSA.ProfilActivitySA;
import com.naufalrafizi.dewarumah.AfterLogin.SA.TokoSA.TokoActivitySA;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Activity.InputProspekSA;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Activity.ProspekActivitySA;
import com.naufalrafizi.dewarumah.R;

import me.relex.circleindicator.CircleIndicator;

public class MainActivitySAgent extends AppCompatActivity {

    ViewPager viewPagerSA;
    ViewPagerAdapterSA vpAdapterSA;
    CircleIndicator indicator;
    RecylerViewAdapterSA rvAdapterSA;
    ImageView btnToko,btnProfil,btnProspek,btnInput,btnBonus;

    int [] ImagePromoSA = {

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
        setContentView(R.layout.activity_main_sagent);

        inisialisasi();

        setUpViewPager();
        setUpRecylerView();
        setUpMenu();

    }

    private void inisialisasi() {

        btnBonus = (ImageView) findViewById(R.id.btnBonus);
        btnToko = (ImageView) findViewById(R.id.btnToko);
        btnProfil = (ImageView) findViewById(R.id.btnProfil);
        btnInput = (ImageView) findViewById(R.id.btnInputProspek);
        btnProspek = (ImageView) findViewById(R.id.btnProspek);

    }

    private void setUpMenu() {

        btnToko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TokoActivitySA.class));
            }
        });

        btnProspek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),ProspekActivitySA.class));

            }
        });
        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),ProfilActivitySA.class));

            }
        });
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),InputProspekSA.class));

            }
        });
        btnBonus.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),BonusActivitySA.class));

            }

        });

    }

    private void setUpRecylerView() {

        RecyclerView rvListPromoSA = (RecyclerView) findViewById(R.id.rvListPromoSA);
        rvListPromoSA.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvAdapterSA = new RecylerViewAdapterSA(getApplication(),ImagePromoSA);
        rvListPromoSA.setAdapter(rvAdapterSA);

    }

    public void setUpViewPager() {

        viewPagerSA = (ViewPager) findViewById(R.id.vPagerSA);
        indicator = (CircleIndicator)findViewById(R.id.circleSA);
        vpAdapterSA = new ViewPagerAdapterSA(this);
        viewPagerSA.setAdapter(vpAdapterSA);
        indicator.setViewPager(viewPagerSA);

    }
}
