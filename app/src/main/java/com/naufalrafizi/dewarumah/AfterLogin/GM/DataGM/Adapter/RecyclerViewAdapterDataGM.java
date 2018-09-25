package com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 9/24/2018.
 */

public class RecyclerViewAdapterDataGM extends RecyclerView.Adapter<RecyclerViewAdapterDataGM.ViewHolder> {

    private String [] mSA =new String[0];
    private String [] mSCsaiful =new String[0];
    private String [] mProspek = new String[0];
    private Context c;
    LayoutInflater inflater;


    public RecyclerViewAdapterDataGM(Context c, String[] SA, String[] SCsaiful, String[] prospek) {

        this.mSA = SA;
        this.mSCsaiful = SCsaiful;
        this.mProspek = prospek;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }

    @Override
    public RecyclerViewAdapterDataGM.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.costum_list_text,parent,false);
        RecyclerViewAdapterDataGM.ViewHolder viewHolder = new RecyclerViewAdapterDataGM.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapterDataGM.ViewHolder holder, int position) {

        holder.txtDataSCGM.setText("SC : " + mSCsaiful[position]);
        holder.txtDataSAGM.setText("SA : "+ mSA[position]);
        holder.txtDataProspekGM.setText("Prospek : " + mProspek[position]);
        holder.cvDataGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mSA.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cvDataGM;
        TextView txtDataSAGM,txtDataSCGM,txtDataProspekGM;

        public ViewHolder(View itemView) {
            super(itemView);

            cvDataGM = (CardView)itemView.findViewById(R.id.cvDataGM);
            txtDataSAGM = (TextView)itemView.findViewById(R.id.txtDataSA);
            txtDataProspekGM = (TextView)itemView.findViewById(R.id.txtDataProspek);
            txtDataSCGM = (TextView)itemView.findViewById(R.id.txtDataSC);

        }
    }
}
