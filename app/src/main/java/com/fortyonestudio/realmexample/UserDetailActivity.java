package com.fortyonestudio.realmexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserDetailActivity extends AppCompatActivity {

    @Bind(R.id.et_firstname)
    EditText etFirstname;
    @Bind(R.id.et_lastname)
    EditText etLastname;
    @Bind(R.id.et_country)
    EditText etCountry;

    private int id;
    private int position;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        id = intent.getIntExtra("user_id", 0);
        position = intent.getIntExtra("position", 0);

        user = RealmController.with(this).getUser(id);
        etFirstname.setText(user.getFirst_name());
        etLastname.setText(user.getLast_name());
        etCountry.setText(user.getCountry());

    }

    @OnClick(R.id.btn_save)
    void saveClick(){
        if (etFirstname.getText().toString().trim().equals("") || etLastname.getText().toString().trim().equals("") || etCountry.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Entry not saved, missing some fields", Toast.LENGTH_SHORT).show();
        } else {
            RealmController.with(this).updateUser(new User(id, etFirstname.getText().toString(), etLastname.getText().toString(), etCountry.getText().toString()));
            finish();
        }

    }

    @OnClick(R.id.btn_delete)
    void deleteClick(){
        RealmController.with(this).deleteUserByPosition(position);
        finish();

    }
}
