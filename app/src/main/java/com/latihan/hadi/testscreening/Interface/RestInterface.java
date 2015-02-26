package com.latihan.hadi.testscreening.Interface;

import com.latihan.hadi.testscreening.model.guestApi;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by SONY on 2/26/2015.
 */
public interface RestInterface {
    @GET("/api/people")
    void getTracks(Callback<List<guestApi>> callback);
}
