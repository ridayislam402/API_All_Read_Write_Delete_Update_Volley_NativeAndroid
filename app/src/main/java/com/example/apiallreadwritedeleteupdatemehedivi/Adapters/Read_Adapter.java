package com.example.apiallreadwritedeleteupdatemehedivi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiallreadwritedeleteupdatemehedivi.Model.read_model;
import com.example.apiallreadwritedeleteupdatemehedivi.R;

import java.util.List;

public class Read_Adapter extends RecyclerView.Adapter<REad_ViewHolder> {
    Context context;
    List<read_model> read_data;

    public Read_Adapter(Context context, List<read_model> read_data) {
        this.context = context;
        this.read_data = read_data;
    }

    @NonNull
    @Override
    public REad_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.read_style,parent,false);
        return new REad_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull REad_ViewHolder h, int position) {
        read_model data=read_data.get(position);
        h.idd.setText(String.valueOf(data.getId()));
        h.named.setText(data.getName());
        h.phoned.setText(data.getPhone());

    }

    @Override
    public int getItemCount() {
        return read_data.size();
    }
}
