package com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DBDataSource;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DataHelper;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model.MInputProspek;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Activity.ProspekActivitySA;
import com.naufalrafizi.dewarumah.R;

import java.util.ArrayList;

/**
 * Created by Asus on 9/6/2018.
 */

public class RecyclerViewAdapterProspekSA extends RecyclerView.Adapter<RecyclerViewAdapterProspekSA.ViewHolder> {

    private ArrayList<MInputProspek> data;
    private Context c;
    private LayoutInflater inflater;
    private DBDataSource dataSource;

    public RecyclerViewAdapterProspekSA(Context c, ArrayList<MInputProspek> mList ){

        data = mList;
//        this.mNamaPromo = NamaPromo;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }

    @Override
    public RecyclerViewAdapterProspekSA.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.costum_list_prospek,parent,false);
        RecyclerViewAdapterProspekSA.ViewHolder viewHolder = new RecyclerViewAdapterProspekSA.ViewHolder(v);

        return viewHolder;

    }



    @Override
    public void onBindViewHolder(RecyclerViewAdapterProspekSA.ViewHolder holder, final int position) {

        final MInputProspek object = data.get(position);

        String namaProspek  = object.getNama_prospek();
        String nomorTelpon = object.getNotelp_prospek();
        String Project = object.getProject_prospek();
        String Sa = object.getSa_prospek();
        String Email = object.getEmail_prospek();

        holder.nama.setText( "Nama : "+namaProspek);
        holder.project.setText("Project : "+Project);
        holder.SA.setText("Sales Agent : "+Sa);
        holder.email.setText("Email : "+Email);
        holder.notelp.setText("Nomer Telpon : "+nomorTelpon);

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                

            }
        });
//        holder.cvProspek.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                final Dialog dialog = new Dialog(c);
//                dialog.setContentView(R.layout.dialog_view);
//                dialog.setTitle("Pilih Aksi");
//                dialog.show();
//
//                Button btnDelete;
//
//                btnDelete = (Button) dialog.findViewById(R.id.btnDelete);
//
//                btnDelete.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        dataSource.delete(object.getId());
//                        no
//
//                    }
//                });
//
//                return true;
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nama,project,SA,email,notelp;
        ImageView btnDelete;
        CardView cvProspek;

        public ViewHolder(View itemView) {
            super(itemView);

            cvProspek = (CardView)itemView.findViewById(R.id.cvProspekSA);
            btnDelete = (ImageView)itemView.findViewById(R.id.btnDelete);
            nama = (TextView)itemView.findViewById(R.id.txtNama);
            project = (TextView)itemView.findViewById(R.id.txtProject);
            SA = (TextView)itemView.findViewById(R.id.txtSA);
            email = (TextView)itemView.findViewById(R.id.txtEmail);
            notelp = (TextView)itemView.findViewById(R.id.txtNoTelp);

        }
    }
}
