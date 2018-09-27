package com.naufalrafizi.dewarumah.BeforeLogin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

public class SignUpSuccess extends AppCompatActivity {

    TextView txtNama;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_success);

        nama = getIntent().getStringExtra("nama");

        txtNama = (TextView)findViewById(R.id.txtNamaSuccesSignUp);
        txtNama.setText(nama);

    }
}
