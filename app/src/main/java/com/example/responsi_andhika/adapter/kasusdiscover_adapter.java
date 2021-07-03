package com.example.responsi_andhika.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_andhika.R;
import com.example.responsi_andhika.model.kasus.ContentItem;

import java.util.ArrayList;

public class kasusdiscover_adapter extends RecyclerView.Adapter<kasusdiscover_adapter.ViewHolder>{

    private ArrayList<ContentItem> kasusDiscoverItems = new ArrayList<>();
    private Context context;


    public kasusdiscover_adapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ContentItem> items){
        kasusDiscoverItems.clear();
        kasusDiscoverItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public kasusdiscover_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_tanggal.setText("Tanggal:"+kasusDiscoverItems.get(position).getTanggal());
        holder.tv_sembuh.setText(String.valueOf("S:"+kasusDiscoverItems.get(position).getConfirmationSelesai()));
        holder.tv_meninggal.setText(String.valueOf("M:"+kasusDiscoverItems.get(position).getConfirmationMeninggal()));
        holder.tv_terkonfirmasi.setText(String.valueOf("K:"+kasusDiscoverItems.get(position).getConfirmationDiisolasi()));

    }

    @Override
    public int getItemCount() {
        return kasusDiscoverItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tanggal,tv_sembuh,tv_meninggal,tv_terkonfirmasi;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tanggal= itemView.findViewById(R.id.tv_tanggal);
            tv_sembuh = itemView.findViewById(R.id.tv_sembuh);
            tv_meninggal = itemView.findViewById(R.id.tv_meninggal);
            tv_terkonfirmasi = itemView.findViewById(R.id.tv_terkonfirmasi);
            cvItem = itemView.findViewById(R.id.cv_itemlist);
        }
    }
}
