package com.naufalrafizi.dewarumah.AfterLogin.SA.TokoSA.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 9/19/2018.
 */

public class RecyclerViewAdapterTokoSA extends RecyclerView.Adapter<RecyclerViewAdapterTokoSA.ViewHolder>{

    private int[] mGambarBarang = new int[0];
    private String[] mNamaBarng = new String[0];
    private String[] mHargaBarang = new String[0];
    private Context c;
    private LayoutInflater inflater;

    public RecyclerViewAdapterTokoSA(Context c, int[] gambarBarang, String[] namaBarang, String[] hargaBarang) {

        this.mGambarBarang = gambarBarang;
        this.mNamaBarng = namaBarang;
        this.mHargaBarang = hargaBarang;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }

    @Override
    public RecyclerViewAdapterTokoSA.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.costum_list_image_text,parent,false);
        RecyclerViewAdapterTokoSA.ViewHolder viewHolder = new RecyclerViewAdapterTokoSA.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterTokoSA.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
