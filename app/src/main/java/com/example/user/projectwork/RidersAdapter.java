package com.example.user.projectwork;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RidersAdapter extends RecyclerView.Adapter<RidersAdapter.RidersViewHolder> {

    private Context mCtx;
    private List<Riders> ridersList;

    public RidersAdapter(Context mCtx, List<Riders> ridersList) {
        this.mCtx = mCtx;
        this.ridersList = ridersList;
    }

    @NonNull
    @Override
    public RidersAdapter.RidersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.ride_list, null);
        return new RidersAdapter.RidersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RidersAdapter.RidersViewHolder holder, int position) {

        Riders user = ridersList.get(position);

        holder.ViewFirstname.setText(user.getFirstname());
        holder.ViewLastname.setText(user.getLastname());
        holder.ViewMobile.setText(user.getMobile());
    }

    @Override
    public int getItemCount() {
        return ridersList.size();
    }

    class RidersViewHolder extends RecyclerView.ViewHolder{

        TextView ViewFirstname, ViewLastname, ViewMobile;

        public RidersViewHolder(View itemView) {
            super(itemView);

            ViewFirstname = itemView.findViewById(R.id.textViewFirstname);
            ViewLastname = itemView.findViewById(R.id.textViewLastname);
            ViewMobile = itemView.findViewById(R.id.textViewMobile);
        }
    }
}
