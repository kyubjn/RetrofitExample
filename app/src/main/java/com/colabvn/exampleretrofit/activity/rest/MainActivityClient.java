package com.colabvn.exampleretrofit.activity.rest;

import com.colabvn.exampleretrofit.utils.AppConstant;

import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MainActivityClient {

    @GET(AppConstant.ServerURL + AppConstant.GetAllGreenHouseonProvince+"{id}")
    retrofit2.Call<ResponseBody> getGreenHouse(@Path("id") String id);


}
