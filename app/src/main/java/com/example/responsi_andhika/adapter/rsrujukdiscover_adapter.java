package com.example.responsi_andhika.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_andhika.R;
import com.example.responsi_andhika.model.rsrujukan.DataItem;

import java.util.ArrayList;
import java.util.List;

public class rsrujukdiscover_adapter extends RecyclerView.Adapter<rsrujukdiscover_adapter.ViewHolder> {

    private ArrayList<DataItem> dataItems = new ArrayList<>();
    private Context context;

    public rsrujukdiscover_adapter(Context context, List<DataItem> dataItems) {
        this.context = context;
        this.dataItems = (ArrayList<DataItem>) dataItems;
    }

    public void setData(ArrayList<DataItem> items){
        dataItems.clear();
        dataItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public rsrujukdiscover_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rsrujukdiscover_adapter.ViewHolder holder, int position) {
        holder.tvRS.setText("Rumah Sakit:"+dataItems.get(position).getNama());
        holder.tvAlamat.setText("Alamat:"+dataItems.get(position).getAlamat());
        holder.bMaps.setOnClickListener(view -> {
            String address = String.format("geo: 0, 0?q= %s", dataItems.get(position).getNama());
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
            intent.setPackage("com.google.android.apps.maps");
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRS, tvAlamat;
        private Button bMaps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRS = itemView.findViewById(R.id.tv_namars);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            bMaps = itemView.findViewById(R.id.btn_maps);
        }
    }
}
