package com.colabvn.exampleretrofit.activity.rest;

import android.app.Activity;

import com.colabvn.exampleretrofit.activity.MainActivity;
import com.colabvn.exampleretrofit.listeners.OnGetResultListGreenHouse;
import com.colabvn.exampleretrofit.model.GreenHouse;
import com.colabvn.exampleretrofit.utils.AppConstant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityClientIml {
    private static MainActivityClientIml instance;
    private MainActivityClient client;
    private Activity mainActivity;
    private Retrofit retrofit;

    public static MainActivityClientIml getInstance(Activity at) {
        if (instance == null) {
            instance = new MainActivityClientIml(at);
        }
        return instance;
    }

    public MainActivityClientIml(Activity ac) {
       // client = ServiceGenerator.createService(DashboardClient.class);
        retrofit = new Retrofit.Builder().baseUrl(AppConstant.ServerURL).build();

        this.mainActivity = ac;
    }

    public void getListGreenhouse(String provinceid,final OnGetResultListGreenHouse callback){
       final  String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiNzUiLCJleHAiOjE1Mjg0NzI4MDl9.YhLEUiH_p91I7LQVuUrbcu7uk5yJ0ubxRZFpQrHop7o";
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header(AppConstant.Authorization,AppConstant.Base)
                        .header(AppConstant.Authorization2,AppConstant.ILYRA+token)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl(AppConstant.ServerURL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();
        MainActivityClient client =retrofit.create(MainActivityClient.class);
        retrofit2.Call<ResponseBody> ret=client.getGreenHouse(provinceid);
        ret.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    String s=response.body().string();
                    JSONObject object=new JSONObject(s);
                    String data=object.getString("msg");

                    int status= Integer.parseInt(object.getString("status"));
                    if(status==200)
                    {
                        JSONArray arr = new JSONArray(data);
                        ArrayList<GreenHouse> ret = GreenHouse.getAllGreenHouse(arr);
                        ret.size();
                        callback.onSucess(ret);
                    }
                    else if(status==400)
                    {
                        callback.onFailed("Error");
                    }
                    else
                    {
                        callback.onFailed("Error");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {

            }
        });

    }

}
