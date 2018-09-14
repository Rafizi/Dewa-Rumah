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
import java.util.List;

/**
 * Created by Asus on 9/6/2018.
 */

public class RecyclerViewAdapterProspekSA extends RecyclerView.Adapter<RecyclerViewAdapterProspekSA.ViewHolder> {

    private List<MInputProspek> data;
    RecyclerViewAdapterProspekSA adapter;
    private Context c ;
    private LayoutInflater inflater;
    private DataHelper helper;

    public RecyclerViewAdapterProspekSA(Context c, List<MInputProspek> mList){

        data = mList;
//        this.mNamaPromo = NamaPromo;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);
        this.helper = new DataHelper(c);

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

        holder.nama.setText(namaProspek);
        holder.email.setText(Email);
        holder.SA.setText(Sa);
        holder.notelp.setText(nomorTelpon);
        holder.project.setText(Project);



        holder.cvProspek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteNote(position);
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

    /**
     * Updating note in db and updating
     * item in the list by its position
     */
    private void updateProspek(String note, int position) {
        MInputProspek n = data.get(position);
        // updating note text
        n.setNama_prospek(note);
        n.setProject_prospek(note);
        n.setEmail_prospek(note);
        n.setSa_prospek(note);
        n.setNotelp_prospek(note);

        // updating note in db
        helper.update(n);

        // refreshing the list
        data.set(position, n);
    }

    /**
     * Deleting note from SQLite and removing the
     * item from the list by its position
     */
    private void deleteNote(int position) {
        // deleting the note from db
        helper.delete(data.get(position));

        // removing the note from the list
        data.remove(position);
        notifyItemRemoved(position);
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
