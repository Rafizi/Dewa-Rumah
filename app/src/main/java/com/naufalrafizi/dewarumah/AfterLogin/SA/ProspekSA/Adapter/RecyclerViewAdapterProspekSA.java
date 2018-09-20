package com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Activity.InputProspekSA;
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
    private Context context;
    private LayoutInflater inflater;
    private DataHelper helper;

    public RecyclerViewAdapterProspekSA(Context c, List<MInputProspek> mList) {

        data = mList;
//        this.mNamaPromo = NamaPromo;
        this.context = c.getApplicationContext();
        this.inflater = LayoutInflater.from(context);
        this.helper = new DataHelper(c);

    }

    @Override
    public RecyclerViewAdapterProspekSA.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.costum_list_prospek, parent, false);
        RecyclerViewAdapterProspekSA.ViewHolder viewHolder = new RecyclerViewAdapterProspekSA.ViewHolder(v);

        return viewHolder;

    }


    @Override
    public void onBindViewHolder(RecyclerViewAdapterProspekSA.ViewHolder holder, final int position) {

        final MInputProspek object = data.get(position);

        final String namaProspek = object.getNama_prospek();
        final String nomorTelpon = object.getNotelp_prospek();
        final String Project = object.getProject_prospek();
        final String Sa = object.getSa_prospek();
        final String Email = object.getEmail_prospek();

        holder.nama.setText("Nama   : " + namaProspek);
        holder.email.setText("Email : " + Email);
        holder.SA.setText("SA   : " + Sa);
        holder.notelp.setText("No Telp  : " + nomorTelpon);
        holder.project.setText("Project : " + Project);

        holder.ivUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = inflater.inflate(R.layout.dialog_prospek, null);
                AlertDialog.Builder b = new AlertDialog.Builder(view.getRootView().getContext());
                b.setView(v);

                final EditText edtNama = (EditText) v.findViewById(R.id.evNamaP);
                final EditText edtEmail = (EditText) v.findViewById(R.id.evEmailP);
                final EditText edtPhone = (EditText) v.findViewById(R.id.evNohpP);
                final EditText edtSa = (EditText) v.findViewById(R.id.evSaP);
                final EditText edtProject = (EditText) v.findViewById(R.id.evProjectP);

                if (object != null) {
                    edtNama.setText(object.getNama_prospek());
                    edtEmail.setText(object.getEmail_prospek());
                    edtPhone.setText(object.getNotelp_prospek());
                    edtSa.setText(object.getSa_prospek());
                    edtProject.setText(object.getProject_prospek());
                }
                b.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        updateProspek(
                                edtNama.getText().toString(),
                                edtEmail.getText().toString(),
                                edtSa.getText().toString(),
                                edtPhone.getText().toString(),
                                edtProject.getText().toString(),
                                position
                        );
                        Toast.makeText(context, "Data Berhasil di update", Toast.LENGTH_SHORT).show();
                    }
                });
                b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = b.create();
                dialog.show();
            }
        });

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteNote(position);
            }
        });

//        holder.cvProspek.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(final View view) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
//                builder.create()
//                        .setCancelable(false);
//                builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        View v = inflater.inflate(R.layout.dialog_prospek, null);
//                        AlertDialog.Builder b = new AlertDialog.Builder(view.getRootView().getContext());
//                        b.setView(v);
//
//                        final EditText edtNama = (EditText) v.findViewById(R.id.evNamaP);
//                        final EditText edtEmail = (EditText) v.findViewById(R.id.evEmailP);
//                        final EditText edtPhone = (EditText) v.findViewById(R.id.evNohpP);
//                        final EditText edtSa = (EditText) v.findViewById(R.id.evSaP);
//                        final EditText edtProject = (EditText) v.findViewById(R.id.evProjectP);
//
//                        if (object != null) {
//                            edtNama.setText(object.getNama_prospek());
//                            edtEmail.setText(object.getEmail_prospek());
//                            edtPhone.setText(object.getNotelp_prospek());
//                            edtSa.setText(object.getSa_prospek());
//                            edtProject.setText(object.getProject_prospek());
//                        }
//                        b.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                updateProspek(
//                                        edtNama.getText().toString(),
//                                        edtEmail.getText().toString(),
//                                        edtSa.getText().toString(),
//                                        edtPhone.getText().toString(),
//                                        edtProject.getText().toString(),
//                                        position
//                                );
//                            }
//                        });
//                        AlertDialog dialog = b.create();
//                        dialog.show();
//                    }
//                });
//                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                builder.show();
//                return true;
//            }
//        });


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

    private void dialogUpdate(MInputProspek p, final int position) {
        View v = inflater.inflate(R.layout.dialog_prospek, null);
        final AlertDialog.Builder updateUserInput;
        updateUserInput = new AlertDialog.Builder(context);
        updateUserInput.setView(v);

        final EditText edtNama = (EditText) v.findViewById(R.id.evNamaP);
        final EditText edtEmail = (EditText) v.findViewById(R.id.evEmailP);
        final EditText edtPhone = (EditText) v.findViewById(R.id.evNohpP);
        final EditText edtSa = (EditText) v.findViewById(R.id.evSaP);
        final EditText edtProject = (EditText) v.findViewById(R.id.evProjectP);
        p = new MInputProspek();

        edtNama.setHint(p.getNama_prospek());
        edtEmail.setHint(p.getEmail_prospek());
        edtPhone.setHint(p.getNotelp_prospek());
        edtSa.setHint(p.getSa_prospek());
        edtProject.setHint(p.getProject_prospek());

        updateUserInput.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                updateProspek(
                        edtNama.getText().toString(),
                        edtEmail.getText().toString(),
                        edtPhone.getText().toString(),
                        edtSa.getText().toString(),
                        edtProject.getText().toString(), position
                );
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        final AlertDialog alertDialog = updateUserInput.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();

    }

    /**
     * Updating note in db and updating
     * item in the list by its position
     */


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

    private void updateProspek(String nama, String email, String sa, String notelp, String project, int position) {
        MInputProspek n = data.get(position);
        // updating note text
        n.setNama_prospek(nama);
        n.setEmail_prospek(email);
        n.setSa_prospek(sa);
        n.setNotelp_prospek(notelp);
        n.setProject_prospek(project);

        // updating note in db
        helper.update(n);

        // refreshing the list
        data.set(position, n);
        notifyItemChanged(position);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nama, project, SA, email, notelp;
        ImageView ivUpdate,ivDelete;
        CardView cvProspek;

        public ViewHolder(View itemView) {
            super(itemView);

            cvProspek = (CardView) itemView.findViewById(R.id.cvProspekSA);
            nama = (TextView) itemView.findViewById(R.id.txtNama);
            project = (TextView) itemView.findViewById(R.id.txtProject);
            SA = (TextView) itemView.findViewById(R.id.txtSA);
            email = (TextView) itemView.findViewById(R.id.txtEmail);
            notelp = (TextView) itemView.findViewById(R.id.txtNoTelp);
            ivDelete = (ImageView)itemView.findViewById(R.id.ivDelete);
            ivUpdate = (ImageView)itemView.findViewById(R.id.ivUpdate);

        }
    }
}
