package com.technorizen.crysco.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.technorizen.crysco.Interfaces.onSelectNearBy;
import com.technorizen.crysco.Model.ModelNearBy;
import com.technorizen.crysco.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterNearbyDoctor extends RecyclerView.Adapter<AdapterNearbyDoctor.mView>{
    Context context;
    ArrayList<ModelNearBy> data;
    private onSelectNearBy callback;

    public AdapterNearbyDoctor(Context context, ArrayList<ModelNearBy> data) {
        this.context = context;
        this.data = data;
    }
    public AdapterNearbyDoctor Callback(onSelectNearBy callback){
        this.callback=callback;
        return this;
    }
    @NonNull
    @Override
    public mView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_doctor,parent,false);
        return new mView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mView holder, int position) {
        holder.tv_doctor_name.setText(data.get(position).getFirst_name());
        holder.tv_distance.setText(data.get(position).getDistance()+" Km away");
        holder.itemView.setOnClickListener(v->{
            callback.onSelect(data.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class mView extends RecyclerView.ViewHolder{
        CircleImageView ivDoctorNearby;
        TextView tv_doctor_name,tv_distance;
        public mView(@NonNull View itemView) {
            super(itemView);
            ivDoctorNearby=itemView.findViewById(R.id.ivDoctorNearby);
            tv_doctor_name=itemView.findViewById(R.id.tv_doctor_name);
            tv_distance=itemView.findViewById(R.id.tv_distance);
        }
    }
}
