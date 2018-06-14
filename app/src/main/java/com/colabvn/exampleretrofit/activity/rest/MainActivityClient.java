package com.colabvn.exampleretrofit.activity.rest;

import com.colabvn.exampleretrofit.utils.AppConstant;

import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MainActivityClient {

    @GET(AppConstant.ServerURL + AppConstant.GetAllGreenHouseonProvince+"{id}")
    retrofit2.Call<ResponseBody> getGreenHouse(@Path("id") String id);

    @FormUrlEncoded
    @POST(AppConstant.ServerURL+AppConstant.login)
    retrofit2.Call<ResponseBody> loginapi(@Field("email") String username,@Field("password") String password);

}
