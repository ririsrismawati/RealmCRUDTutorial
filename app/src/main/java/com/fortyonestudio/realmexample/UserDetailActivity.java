package com.fortyonestudio.realmexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        User user = new User();
        user.setUser_id((int) (1 + System.currentTimeMillis()));
        user.setFirst_name("John");
        user.setLast_name("Doe");
        user.setCountry("Indonesia");
    }
}
