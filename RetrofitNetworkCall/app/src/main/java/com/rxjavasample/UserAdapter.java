package com.rxjavasample;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjavasample.model.UserResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Divya on 3/30/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    ArrayList<UserResponse> usersList;
    Context context;

    public UserAdapter(ArrayList<UserResponse> usersList, Context context) {
        this.usersList = usersList;
        this.context = context;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.user_name)
        TextView userName;
        @BindView(R.id.user_image)
        ImageView imageView;
        @BindView(R.id.container_layout)
        ConstraintLayout container;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.container_layout)
        void clickItem() {

        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.userName.setText(usersList.get(position).getLogin());
        Picasso.with(context)
                .load(usersList.get(position).getAvatarUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
