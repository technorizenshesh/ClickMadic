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

public class AdapterNearbyClinic extends RecyclerView.Adapter<AdapterNearbyClinic.mView>{
    Context context;
    ArrayList<ModelNearBy> data;
    private onSelectNearBy callback;

    public AdapterNearbyClinic(Context context, ArrayList<ModelNearBy> data) {
        this.context = context;
        this.data = data;
    }
    public AdapterNearbyClinic Callback(onSelectNearBy callback){
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
        holder.tv_name.setText(data.get(position).getFirst_name());
        holder.itemView.setOnClickListener(v->{
            callback.onSelect(data.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class mView extends RecyclerView.ViewHolder{
        CircleImageView ivClinicProfile;
        TextView tv_name;
        public mView(@NonNull View itemView) {
            super(itemView);
            ivClinicProfile=itemView.findViewById(R.id.ivClinicProfile);
            tv_name=itemView.findViewById(R.id.tv_name);
        }
    }
}
