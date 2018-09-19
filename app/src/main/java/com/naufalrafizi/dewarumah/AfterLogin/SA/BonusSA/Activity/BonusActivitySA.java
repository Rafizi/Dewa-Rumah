package com.naufalrafizi.dewarumah.AfterLogin.SA.BonusSA.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.naufalrafizi.dewarumah.AfterLogin.SA.BonusSA.Fragment.FBonusSA;
import com.naufalrafizi.dewarumah.AfterLogin.SA.BonusSA.Fragment.FPointSA;
import com.naufalrafizi.dewarumah.R;

import java.util.ArrayList;
import java.util.List;

public class BonusActivitySA extends AppCompatActivity {

    TabLayout tabsBonusSA;
    ViewPager vpBonusSA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_sa);

        tabsBonusSA = (TabLayout)findViewById(R.id.tabBonusSA);
        vpBonusSA = (ViewPager)findViewById(R.id.vpBonusSA);

        setUpViewPager(vpBonusSA);
        tabsBonusSA.setupWithViewPager(vpBonusSA);

    }

    private void setUpViewPager(ViewPager vpBonusSA) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FPointSA(),"Poin");
        adapter.addFragment(new FBonusSA(),"Bonus");
        vpBonusSA.setAdapter(adapter);

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> nameList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);

        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment f, String title){

            fragmentList.add(f);
            nameList.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return nameList.get(position);
        }
    }

}