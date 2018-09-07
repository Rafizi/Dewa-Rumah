package com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DBDataSource;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model.MInputProspek;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Activity.ProspekActivitySA;
import com.naufalrafizi.dewarumah.R;

public class InputProspekSA extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText edtNamaInputProspek,edtProjectInputProspek,edtEmailInputProspek,edtSAInputProspek,edtNomorTelponInputProspek;
    Button btnSubmitInputProspek,btnRead;
    DBDataSource dbDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_prospek_sa);

        Inisialisasi();

        btnSubmitInputProspek.setOnClickListener(this);
        btnRead.setOnClickListener(this);


        dbDataSource = new DBDataSource(this);

        //membuat sambungan baru ke database
        dbDataSource.open();

    }

    private void Inisialisasi() {
        btnSubmitInputProspek = (Button)findViewById(R.id.btnSubmitInputProspek);
        btnRead = (Button)findViewById(R.id.btnRead);

        edtNamaInputProspek= (TextInputEditText)findViewById(R.id.edtNamaInputProspek);
        edtProjectInputProspek= (TextInputEditText)findViewById(R.id.edtProjectInputProspek);
        edtEmailInputProspek= (TextInputEditText)findViewById(R.id.edtEmailInputProspek);
        edtSAInputProspek = (TextInputEditText)findViewById(R.id.edtSAInputProspek);
        edtNomorTelponInputProspek = (TextInputEditText)findViewById(R.id.edtNomorTelponInputProspek);

    }

    @Override
    public void onClick(View v) {

        String nama;
        String project;
        String email;
        String  sa;
        String  notelp;

        //inisialisai model
        MInputProspek mInputProspek = null;

            nama = edtNamaInputProspek.getText().toString();
            email = edtEmailInputProspek.getText().toString();
            project = edtProjectInputProspek.getText().toString();
            sa = edtSAInputProspek.getText().toString();
            notelp = edtNomorTelponInputProspek.getText().toString();



        switch (v.getId()){
            case R.id.btnSubmitInputProspek :
                //insert data barang baru

                if (nama.isEmpty() && email.isEmpty() && project.isEmpty() && sa.isEmpty() && notelp.isEmpty()){

                    Toast.makeText(this, "yeay", Toast.LENGTH_SHORT).show();

                }else {

                    mInputProspek = dbDataSource.createProspek(nama,email,notelp,sa,project);

                    //konfirmasi kesuksesan
                    Toast.makeText(this, "Masuk Barang \n"+
                            " nama :  " +mInputProspek.getNama_prospek()+
                            " email : "+mInputProspek.getEmail_prospek()+
                            " notelp : "+mInputProspek.getNotelp_prospek()+
                            " sa : "+mInputProspek.getSa_prospek()+
                            " project : "+mInputProspek.getProject_prospek(), Toast.LENGTH_LONG).show();

                }


                break;

            case R.id.btnRead:
                startActivity(new Intent(getApplicationContext(), ProspekActivitySA.class));
        }
    }
}
