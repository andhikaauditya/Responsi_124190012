package com.example.responsi_andhika.view.fragment;

import android.annotation.SuppressLint;
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
import com.example.responsi_andhika.adapter.kasusdiscover_adapter;
import com.example.responsi_andhika.model.kasus.ContentItem;
import com.example.responsi_andhika.view.viewmodel.kasus_viewmodel;

import java.util.ArrayList;

public class kasusfragment extends Fragment {

    private com.example.responsi_andhika.adapter.kasusdiscover_adapter kasusdiscover_adapter;
    private RecyclerView rvkasusdiscover;
    private kasus_viewmodel kasus_viewmodel;

    public kasusfragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus, container, false);
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        kasusdiscover_adapter = new kasusdiscover_adapter(getContext());
        kasusdiscover_adapter.notifyDataSetChanged();

        rvkasusdiscover = view.findViewById(R.id.rv_fragmentkasus);
        rvkasusdiscover.setLayoutManager(new GridLayoutManager(getContext(),2));

        kasus_viewmodel = new ViewModelProvider(this).get(kasus_viewmodel.class);
        kasus_viewmodel.setKasusDiscover();
        kasus_viewmodel.getKasusDiscover().observe(this,getMovieDiscover);

        rvkasusdiscover.setAdapter(kasusdiscover_adapter);
    }
    private Observer<ArrayList<ContentItem>> getMovieDiscover = new Observer<ArrayList<ContentItem>>() {
        @Override
        public void onChanged(ArrayList<ContentItem> contentItem) {
            if (contentItem != null){
                kasusdiscover_adapter.setData(contentItem);
            }
        }
    };



}
