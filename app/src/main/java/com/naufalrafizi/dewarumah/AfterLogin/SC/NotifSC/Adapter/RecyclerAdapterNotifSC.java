package com.naufalrafizi.dewarumah.AfterLogin.SC.NotifSC.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 9/28/2018.
 */

public class RecyclerAdapterNotifSC extends RecyclerView.Adapter<RecyclerAdapterNotifSC.ViewHolder> {

    private String [] mNama =new String[0];
    private String [] mContent = new String[0];
    private Context c;
    LayoutInflater inflater;

    public RecyclerAdapterNotifSC(Context c, String[] nama, String[] content) {

        this.mNama = nama;
        this.mContent = content;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }

    @Override
    public RecyclerAdapterNotifSC.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.costum_list_data_agent_sc,parent,false);
        RecyclerAdapterNotifSC.ViewHolder viewHolder= new RecyclerAdapterNotifSC.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterNotifSC.ViewHolder holder, int position) {

        holder.txtNama.setText(mNama[position]);
        holder.txtContent.setText(mContent[position]);

    }

    @Override
    public int getItemCount() {
        return mNama.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNama,txtContent;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNama = (TextView)itemView.findViewById(R.id.txtNamaAgentSC);
            txtContent = (TextView)itemView.findViewById(R.id.txtProjectAgentSC);

        }
    }
}
