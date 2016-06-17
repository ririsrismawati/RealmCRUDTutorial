package com.fortyonestudio.realmexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddUserActivity extends AppCompatActivity {

    @Bind(R.id.et_firstname)
    EditText etFirstname;
    @Bind(R.id.et_lastname)
    EditText etLastname;
    @Bind(R.id.et_country)
    EditText etCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_save)
    void saveClick(){

        if (etFirstname.getText().toString().trim().equals("") || etLastname.getText().toString().trim().equals("") || etCountry.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Entry not saved, missing some fields", Toast.LENGTH_SHORT).show();
        } else {
            RealmController.with(this).createUser(new User(etFirstname.getText().toString(), etLastname.getText().toString(), etCountry.getText().toString()));
            finish();
        }

    }
}
