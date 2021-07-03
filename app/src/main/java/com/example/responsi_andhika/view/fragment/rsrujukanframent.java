package com.example.responsi_andhika.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_andhika.R;
import com.example.responsi_andhika.adapter.rsrujukdiscover_adapter;
import com.example.responsi_andhika.model.rsrujukan.DataItem;
import com.example.responsi_andhika.view.viewmodel.rsrujukan_viewmodel;

import java.util.ArrayList;

public class rsrujukanframent extends Fragment {

    private rsrujukdiscover_adapter rsrujukadapter;
    private RecyclerView rvTvDiscover;
    private com.example.responsi_andhika.view.viewmodel.rsrujukan_viewmodel rsrujukan_viewmodel;


    public rsrujukanframent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rsrujukan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rsrujukadapter = new rsrujukdiscover_adapter(getActivity(), new ArrayList<>());
        rsrujukadapter.notifyDataSetChanged();

        rvTvDiscover = view.findViewById(R.id.rv_fragmentrsrujukan);
        rvTvDiscover.setLayoutManager(new GridLayoutManager(getContext(), 2));

        rsrujukan_viewmodel = new ViewModelProvider(this).get(rsrujukan_viewmodel.class);
        rsrujukan_viewmodel.setTvDiscover();
        rsrujukan_viewmodel.getTvDiscover().observe(this,getTvDiscover);

        rvTvDiscover.setAdapter(rsrujukadapter);
    }

    private Observer<ArrayList<DataItem>> getTvDiscover = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> TvDiscoverResultsItems) {
            if (TvDiscoverResultsItems != null){
                rsrujukadapter.setData(TvDiscoverResultsItems);
            }
        }
    };
}
