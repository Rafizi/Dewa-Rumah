package com.naufalrafizi.dewarumah.AfterLogin.SC;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 9/3/2018.
 */

public class ViewPagerAdapterSC extends PagerAdapter {

    Context c;
    LayoutInflater inflater;

    public int imgResource [] = {

            R.drawable.promo1,
            R.drawable.promo2,
            R.drawable.promo3

    };

    public ViewPagerAdapterSC(Context context){

        this.c = context;

    }

    @Override
    public int getCount() {
        return imgResource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.row_vpager,container,false);
        ImageView img = (ImageView)v.findViewById(R.id.imgSlider);
        img.setImageResource(imgResource[position]);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
