package com.example.apiallreadwritedeleteupdatemehedivi.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiallreadwritedeleteupdatemehedivi.R;

public class REad_ViewHolder extends RecyclerView.ViewHolder {
    TextView idd,named,phoned;
    public REad_ViewHolder(@NonNull View itemView) {
        super(itemView);
        idd=itemView.findViewById(R.id.id_id);
        named=itemView.findViewById(R.id.name_id);
        phoned=itemView.findViewById(R.id.phone_id);
    }
}
