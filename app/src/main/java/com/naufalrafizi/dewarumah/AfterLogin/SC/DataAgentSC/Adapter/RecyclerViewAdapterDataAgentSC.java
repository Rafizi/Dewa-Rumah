package com.naufalrafizi.dewarumah.AfterLogin.SC.DataAgentSC.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 9/17/2018.
 */

public class RecyclerViewAdapterDataAgentSC extends RecyclerView.Adapter<RecyclerViewAdapterDataAgentSC.ViewHolder> {

    private String [] mNamaAgent = new String[0];
    private String [] mProject = new String[0];
    private Context c;
    private LayoutInflater inflater;

    public RecyclerViewAdapterDataAgentSC(Context c, String[] namaAgent, String[] projectAgent) {

        this.mNamaAgent = namaAgent;
        this.mProject = projectAgent;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }


    @Override
    public RecyclerViewAdapterDataAgentSC.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.costum_list_data_agent_sc,parent,false);
        RecyclerViewAdapterDataAgentSC.ViewHolder viewHolder= new RecyclerViewAdapterDataAgentSC.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterDataAgentSC.ViewHolder holder, int position) {

        final String nama = mNamaAgent[position];
        final String project = mProject[position];

        holder.txtNamaAgentSC.setText(nama);
        holder.txtProjectAgentSC.setText(project);

    }

    @Override
    public int getItemCount() {
        return mNamaAgent.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNamaAgentSC,txtProjectAgentSC;

        public ViewHolder(View itemView) {

            super(itemView);

            txtNamaAgentSC = (TextView)itemView.findViewById(R.id.txtNamaAgentSC);
            txtProjectAgentSC = (TextView)itemView.findViewById(R.id.txtProjectAgentSC);

        }



    }
}
