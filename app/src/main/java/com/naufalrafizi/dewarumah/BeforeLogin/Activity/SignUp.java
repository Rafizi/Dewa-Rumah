package com.naufalrafizi.dewarumah.BeforeLogin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.naufalrafizi.dewarumah.R;

public class SignUp extends AppCompatActivity {

    Button btnSignUp;
    String nama,notelp,email,project,password;
    EditText edtNamaLogin,edtNomorTelpon,edtEmail,edtProject,edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSignUp = (Button)findViewById(R.id.btnSiginUp);

        edtNamaLogin = (EditText)findViewById(R.id.edtNamaSignUp);
        edtNomorTelpon = (EditText)findViewById(R.id.edtNomorTelpon);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtProject = (EditText)findViewById(R.id.edtProject);
        edtPass = (EditText)findViewById(R.id.edtPassword);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama = edtNamaLogin.getText().toString();
                notelp = edtNomorTelpon.getText().toString();
                email = edtEmail.getText().toString();
                project = edtProject.getText().toString();
                password = edtPass.getText().toString();

                if (nama.isEmpty() || notelp.isEmpty() || email.isEmpty() || project.isEmpty() || password.isEmpty()){

                    Toast.makeText(SignUp.this, "Kosong!!", Toast.LENGTH_SHORT).show();

                }else {

                    Intent i = new Intent(getApplicationContext(),SignUpSuccess.class);
                    i.putExtra("nama",nama);
                    i.putExtra("nomor",notelp);
                    i.putExtra("email",email);
                    i.putExtra("project",project);
                    startActivity(i);

                }
            }
        });

    }
}
