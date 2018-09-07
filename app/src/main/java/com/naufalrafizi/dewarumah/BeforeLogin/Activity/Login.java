package com.naufalrafizi.dewarumah.BeforeLogin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.naufalrafizi.dewarumah.AfterLogin.GM.MainActivityGM;
import com.naufalrafizi.dewarumah.AfterLogin.SA.MainActivitySAgent;
import com.naufalrafizi.dewarumah.AfterLogin.SC.Activity.MainActivitySConsultan;
import com.naufalrafizi.dewarumah.R;

public class Login extends AppCompatActivity {

    EditText edtNama, edtPassword;
    TextView txtSignUp;
    Button btnLogin;
    String SA, SC, GM, SAP, SCP, GMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtNama = (EditText) findViewById(R.id.edtNamaLogin);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        txtSignUp = (TextView)findViewById(R.id.txtSignUp);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        SA = "Saiful";
        SAP = "saiful100";
        SC = "Yuriva";
        SCP = "Yuriva100";
        GM = "Hermawan";
        GMP = "Hermawan100";

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Nama = edtNama.getText().toString();
                String Password = edtPassword.getText().toString();

                if (Nama.equals(SA) && Password.equals(SAP)){

                    Intent i = new Intent(getApplicationContext(),MainActivitySAgent.class);
                    i.putExtra("nama",Nama);
                    startActivity(i);
                    finish();
                    MainActivity.fa.finish();

                }

                else if (Nama.equalsIgnoreCase(SC) && Password.equalsIgnoreCase(SCP)){

                    Intent i = new Intent(getApplicationContext(),MainActivitySConsultan.class);
                    i.putExtra("nama",Nama);
                    startActivity(i);
                    finish();
                    MainActivity.fa.finish();

                }

                else if (Nama.equalsIgnoreCase(GM) && Password.equalsIgnoreCase(GMP)){

                    Intent i = new Intent(getApplicationContext(),MainActivityGM.class);
                    i.putExtra("nama",Nama);
                    startActivity(i);
                    finish();
                    MainActivity.fa.finish();

                }

                else {
                    Toast.makeText(Login.this, "cek kembali", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}