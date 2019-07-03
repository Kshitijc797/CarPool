package com.example.user.projectwork;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RideAdapter extends RecyclerView.Adapter<RideAdapter.RideViewHolder> {

    private Context mCtx;
    private List<AdminRide> rideList;

    public RideAdapter(Context mCtx, List<AdminRide> rideList) {
        this.mCtx = mCtx;
        this.rideList = rideList;
    }

    @NonNull
    @Override
    public RideViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.ride_details, null);
        return new RideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RideViewHolder rideViewHolder, int position) {

        AdminRide user = rideList.get(position);

        rideViewHolder.ViewPick.setText(user.getPick());
        rideViewHolder.ViewDrop.setText(user.getDrop());
        rideViewHolder.ViewEmail.setText(user.getEmail());
        rideViewHolder.ViewPdate.setText(user.getPick_date());
        rideViewHolder.ViewRdate.setText(user.getReturn_date());
    }

    @Override
    public int getItemCount() {
        return rideList.size();
    }

    public class RideViewHolder extends RecyclerView.ViewHolder {

        TextView ViewPick, ViewDrop, ViewEmail, ViewPdate, ViewRdate;

        public RideViewHolder(@NonNull View itemView) {
            super(itemView);

            ViewPick = itemView.findViewById(R.id.textViewPick);
            ViewDrop = itemView.findViewById(R.id.textViewDrop);
            ViewEmail = itemView.findViewById(R.id.textViewEmail);
            ViewPdate = itemView.findViewById(R.id.textViewPick_date);
            ViewRdate = itemView.findViewById(R.id.textViewReturn_date);
        }
    }
}
