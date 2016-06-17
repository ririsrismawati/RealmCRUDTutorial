package com.fortyonestudio.realmexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Riris.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;
    Context context;

    public class UserViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.first_name)
        TextView firstName;
        @Bind(R.id.last_name)
        TextView lastName;
        @Bind(R.id.country)
        TextView country;



        public UserViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }

    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_row, parent, false);


        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        final User user = userList.get(position);
        holder.firstName.setText(user.getFirst_name());
        holder.country.setText(user.getCountry());
        holder.lastName.setText(user.getLast_name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, UserDetailActivity.class);
                intent.putExtra("user_id", user.getUser_id());
                intent.putExtra("position", position);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}