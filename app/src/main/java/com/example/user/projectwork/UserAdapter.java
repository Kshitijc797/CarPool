package com.example.user.projectwork;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context mCtx;
    private List<AdminUser> userList;

    public UserAdapter(Context mCtx, List<AdminUser> userList) {
        this.mCtx = mCtx;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.user_details, null);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        AdminUser user = userList.get(position);

        holder.ViewFirstname.setText(user.getFirstname());
        holder.ViewLastname.setText(user.getLastname());
        holder.ViewEmail.setText(user.getEmail());
        holder.ViewUsername.setText(user.getUsername());
        holder.ViewMobile.setText(user.getMobile());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{

        TextView ViewFirstname, ViewLastname, ViewEmail, ViewUsername, ViewMobile;

        public UserViewHolder(View itemView) {
            super(itemView);

            ViewFirstname = itemView.findViewById(R.id.textViewFirstname);
            ViewLastname = itemView.findViewById(R.id.textViewLastname);
            ViewEmail = itemView.findViewById(R.id.textViewEmail);
            ViewUsername = itemView.findViewById(R.id.textViewUsername);
            ViewMobile = itemView.findViewById(R.id.textViewMobile);
        }
    }
}
