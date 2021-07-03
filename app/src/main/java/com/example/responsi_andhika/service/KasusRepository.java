package com.example.responsi_andhika.service;

import com.example.responsi_andhika.model.kasus.KasusDiscoverResponse;
import com.example.responsi_andhika.model.rsrujukan.RsrujukanDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KasusRepository {
    @GET("rekapitulasi_v2/jabar/harian")
    Call<KasusDiscoverResponse> getKasusDiscover();

    @GET("sebaran_v2/jabar/faskes")
    Call<RsrujukanDiscoverResponse> getTvDiscover();
}
