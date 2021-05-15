package com.technorizen.crysco.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;
import com.technorizen.crysco.Interfaces.onSelectNearBy;
import com.technorizen.crysco.Model.ModelHealth;
import com.technorizen.crysco.R;

import java.util.ArrayList;

public class AdapterHealth extends RecyclerView.Adapter<AdapterHealth.mView>{
    Context context;
    ArrayList<ModelHealth> data;
    private onSelectNearBy callback;

    public AdapterHealth(Context context, ArrayList<ModelHealth> data) {
        this.context = context;
        this.data = data;
    }
    public AdapterHealth Callback(onSelectNearBy callback){
        this.callback=callback;
        return this;
    }

    @NonNull
    @Override
    public mView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_health,parent,false);
        return new mView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mView holder, int position) {
        holder.tv_title.setText(data.get(position).getTitle());
        holder.tv_title.setText(data.get(position).getDescription());
        Picasso.get().load(data.get(position).getImage()).placeholder(R.drawable.profile).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class mView extends RecyclerView.ViewHolder{
        RoundedImageView image;
        TextView tv_title,tv_des;
        public mView(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_des=itemView.findViewById(R.id.tv_des);
        }
    }
}
