package com.colabvn.exampleretrofit.activity.presenter;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.colabvn.exampleretrofit.activity.MainActivity;
import com.colabvn.exampleretrofit.activity.rest.MainActivityClientIml;
import com.colabvn.exampleretrofit.adapter.GreenHouseAdapter;
import com.colabvn.exampleretrofit.listeners.OnGetResultListGreenHouse;
import com.colabvn.exampleretrofit.model.GreenHouse;

import java.util.ArrayList;

public class MainActivityPresenter   {
    private MainActivity mActivity;
    private MainActivityClientIml client;
    private ArrayList<GreenHouse> arrGreenhouse;
    private GreenHouseAdapter adapter;


    public MainActivityPresenter(MainActivity mainActivity) {
        arrGreenhouse=new ArrayList<>();
        client = MainActivityClientIml.getInstance(mainActivity);
        mActivity=mainActivity;
        adapter=new GreenHouseAdapter(mainActivity,0,arrGreenhouse);
    }
public void getListGreenhouse(String province_id) {
    client.getListGreenhouse(province_id,new OnGetResultListGreenHouse() {
        @Override
        public void onSucess(ArrayList<GreenHouse> arr) {
            setData(arr);
        }

        @Override
        public void onFailed(String s) {
            Toast.makeText(mActivity,s,Toast.LENGTH_LONG).show();

        }
    });
}

    private void setData(ArrayList<GreenHouse> arr) {
        arrGreenhouse.clear();
        arrGreenhouse.addAll(arr);
        adapter.notifyDataSetChanged();
    }

    public GreenHouseAdapter getAdapter() {
        return adapter;
    }
}
