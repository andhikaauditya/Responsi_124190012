package com.example.responsi_andhika.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi_andhika.model.rsrujukan.DataItem;
import com.example.responsi_andhika.model.rsrujukan.RsrujukanDiscoverResponse;
import com.example.responsi_andhika.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class rsrujukan_viewmodel extends ViewModel {

    private ApiMain apiMain;

    private MutableLiveData<ArrayList<DataItem>> listDiscoverTv = new MutableLiveData<>();

    public void setTvDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiKasus().getTvDiscover().enqueue(new Callback<RsrujukanDiscoverResponse>() {
            @Override
            public void onResponse(Call<RsrujukanDiscoverResponse> call, Response<RsrujukanDiscoverResponse> response) {
                RsrujukanDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getData() != null){
                    ArrayList<DataItem> dataItems = responseDiscover.getData();
                    listDiscoverTv.postValue(dataItems);

                }
            }

            @Override
            public void onFailure(Call<RsrujukanDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<DataItem>> getTvDiscover(){
        return listDiscoverTv;
    }

}
