package com.naufalrafizi.dewarumah.AfterLogin.GM.NotifGM.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 9/28/2018.
 */

public class RecyclerAdapterNotifGM extends RecyclerView.Adapter<RecyclerAdapterNotifGM.ViewHolder> {

    private String [] mTier =new String[0];
    private String [] mNama =new String[0];
    private String [] mContent = new String[0];
    private Context c;
    LayoutInflater inflater;

    public RecyclerAdapterNotifGM(Context c, String[] tier, String[] nama, String[] content) {

        this.mTier = tier;
        this.mNama = nama;
        this.mContent = content;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }

    @Override
    public RecyclerAdapterNotifGM.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.costum_list_text,parent,false);
        RecyclerAdapterNotifGM.ViewHolder viewHolder = new RecyclerAdapterNotifGM.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterNotifGM.ViewHolder holder, int position) {

        holder.txtTier.setText(mTier[position]);
        holder.txtNama.setText(mNama[position]);
        holder.txtContent.setText(mContent[position]);

    }

    @Override
    public int getItemCount() {
        return mTier.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cvDataGM;
        TextView txtNama,txtTier,txtContent;

        public ViewHolder(View itemView) {
            super(itemView);

            cvDataGM = (CardView)itemView.findViewById(R.id.cvDataGM);
            txtTier = (TextView)itemView.findViewById(R.id.txtDataSA);
            txtContent = (TextView)itemView.findViewById(R.id.txtDataProspek);
            txtNama = (TextView)itemView.findViewById(R.id.txtDataSC);

        }
    }
}
