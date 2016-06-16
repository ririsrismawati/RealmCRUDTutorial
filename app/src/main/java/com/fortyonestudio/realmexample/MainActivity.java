package com.fortyonestudio.realmexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    private Realm realm;
    private RecyclerView recycler;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //get realm instance
        this.realm = RealmController.with(this).getRealm();


        setRealmData();
    }

    private void setRealmData() {
        List<User> users = new ArrayList<>();

        User user = new User();
        user.setUser_id((int) (1 + System.currentTimeMillis()));
        user.setFirst_name("John");
        user.setLast_name("Doe");
        user.setCountry("Indonesia");
        users.add(user);

        user = new User();
        user.setUser_id((int) (2 + System.currentTimeMillis()));
        user.setFirst_name("Ashtony");
        user.setLast_name("Doe");
        user.setCountry("Alaska");
        users.add(user);

        user = new User();
        user.setUser_id((int) (3 + System.currentTimeMillis()));
        user.setFirst_name("Queen");
        user.setLast_name("Doe");
        user.setCountry("Caribian");
        users.add(user);

        for (User b : users) {
            // Persist your data easily
            realm.beginTransaction();
            realm.copyToRealm(b);
            realm.commitTransaction();
        }

        Toast.makeText(this, users.size() + "", Toast.LENGTH_SHORT).show();

        // refresh the realm instance
        RealmController.with(this).refresh();

        adapter = new UserAdapter(RealmController.with(this).getUsers());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


    }



}
