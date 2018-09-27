package com.naufalrafizi.dewarumah.AfterLogin.GM;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 9/21/2018.
 */

class RecylerViewAdapterGM extends RecyclerView.Adapter<RecylerViewAdapterGM.ViewHolder>{

    private int [] mImagePromo = new int[0];
    private Context c;
    private LayoutInflater inflater;

    public RecylerViewAdapterGM(Context c, int[] ImagePromoGM){

        this.mImagePromo = ImagePromoGM;
//        this.mNamaPromo = NamaPromo;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }

    @Override
    public RecylerViewAdapterGM.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.costum_adapter_recyler_view,parent,false);
        RecylerViewAdapterGM.ViewHolder viewHolder = new RecylerViewAdapterGM.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecylerViewAdapterGM.ViewHolder holder, int position) {

        final int ImageProject = mImagePromo[position];
//        final String NamaProject = mNamaPromo[position];
//        holder.txtListProject.setText(NamaProject);
        holder.imgListProject.setImageResource(ImageProject);
        holder.cvListProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(c, DetailPromoGM.class);
//                i.putExtra("nama",NamaProject);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                c.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mImagePromo.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgListProject;
        TextView txtListProject;
        CardView cvListProject;

        public ViewHolder(View itemView) {
            super(itemView);

            cvListProject = (CardView)itemView.findViewById(R.id.cvListProject);
            imgListProject = (ImageView) itemView.findViewById(R.id.imgListProject);

        }
    }
}
