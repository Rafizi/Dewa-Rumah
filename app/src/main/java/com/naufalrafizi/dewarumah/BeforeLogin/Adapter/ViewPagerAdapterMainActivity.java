package com.naufalrafizi.dewarumah.BeforeLogin.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.naufalrafizi.dewarumah.R;

public class ViewPagerAdapterMainActivity extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public int imgResource [] = {
            R.drawable.promo1,
            R.drawable.promo2,
            R.drawable.promo3
    };

    public ViewPagerAdapterMainActivity(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgResource.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.row_vpager,container,false);
        ImageView img = (ImageView)v.findViewById(R.id.imgSlider);
        img.setImageResource(imgResource[position]);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
