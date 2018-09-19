package com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DBDataSource;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DataHelper;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model.MInputProspek;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Activity.ProspekActivitySA;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Adapter.RecyclerViewAdapterProspekSA;
import com.naufalrafizi.dewarumah.R;

import java.util.ArrayList;
import java.util.List;

public class InputProspekSA extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText edtNamaInputProspek, edtProjectInputProspek, edtEmailInputProspek, edtSAInputProspek, edtNomorTelponInputProspek;
    Button btnSubmitInputProspek, btnRead;
    DataHelper helper;
    List<MInputProspek> pList = new ArrayList<>();
    RecyclerViewAdapterProspekSA adapter;
    MInputProspek p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_prospek_sa);

        Inisialisasi();

        btnSubmitInputProspek.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        p = new MInputProspek();


        helper = new DataHelper(this);


        //membuat sambungan baru ke database


    }


    private void Inisialisasi() {
        btnSubmitInputProspek = (Button) findViewById(R.id.btnSubmitInputProspek);
        btnRead = (Button) findViewById(R.id.btnRead);

        edtNamaInputProspek = (TextInputEditText) findViewById(R.id.edtNamaInputProspek);
        edtProjectInputProspek = (TextInputEditText) findViewById(R.id.edtProjectInputProspek);
        edtEmailInputProspek = (TextInputEditText) findViewById(R.id.edtEmailInputProspek);
        edtSAInputProspek = (TextInputEditText) findViewById(R.id.edtSAInputProspek);
        edtNomorTelponInputProspek = (TextInputEditText) findViewById(R.id.edtNomorTelponInputProspek);

    }

    @Override
    public void onClick(View v) {

        String nama, email, nomor, sa, project;

        switch (v.getId()) {
            case R.id.btnSubmitInputProspek:
                //insert data barang baru
                nama = edtNamaInputProspek.getText().toString();
                email = edtEmailInputProspek.getText().toString();
                nomor = edtNomorTelponInputProspek.getText().toString();
                sa = edtSAInputProspek.getText().toString();
                project = edtProjectInputProspek.getText().toString();

                if (nama.isEmpty() || email.isEmpty() || nomor.isEmpty() || sa.isEmpty() || project.isEmpty()){
                    Toast.makeText(this, "Masukin yang bener woi", Toast.LENGTH_SHORT).show();
                }
                else {
                    createNote(
                            edtNamaInputProspek.getText().toString(),
                            edtEmailInputProspek.getText().toString(),
                            edtNomorTelponInputProspek.getText().toString(),
                            edtSAInputProspek.getText().toString(),
                            edtProjectInputProspek.getText().toString()
                    );

                            Toast.makeText(this, "Data Masuk :"
                                            + p.getId() + ",\t"
                                            + p.getNama_prospek() + ",\t"
                                            + p.getEmail_prospek() + ",\t"
                                            + p.getNotelp_prospek() + ",\t"
                                            + p.getSa_prospek() + ",\t"
                                            + p.getProject_prospek() + ",\t"
                                    , Toast.LENGTH_SHORT).show();

                }


                break;

            case R.id.btnRead:
                startActivity(new Intent(getApplicationContext(), ProspekActivitySA.class));
        }
    }


    private void createNote(String nama, String email, String notelp, String sa, String project) {
        // inserting note in db and getting
        // newly inserted note id
        long id = helper.createProspek(nama, email, notelp, sa, project);

        // get the newly inserted note from db
        MInputProspek n = helper.getProspek(id);

        if (n != null) {
            // adding new note to array list at 0 position
            pList.add(0, n);
            // refreshing the list


        }
    }


    /**
     * Updating note in db and updating
     * item in the list by its position
     */


    /**
     * Deleting note from SQLite and removing the
     * item from the list by its position
     */
}
