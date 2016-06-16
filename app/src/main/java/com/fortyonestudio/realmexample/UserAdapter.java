package com.fortyonestudio.realmexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Riris.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {


    @Bind(R.id.first_name)
    TextView firstName;
    @Bind(R.id.last_name)
    TextView lastName;
    @Bind(R.id.country)
    TextView country;

    private List<User> userList;

    public class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView firstName, lastName, country;

        public UserViewHolder(View view) {
            super(view);
        }
    }

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_row, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = userList.get(position);
        firstName.setText(user.getFirst_name());
        country.setText(user.getCountry());
        lastName.setText(user.getLast_name());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}