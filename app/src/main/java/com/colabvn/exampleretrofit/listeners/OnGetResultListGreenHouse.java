package com.colabvn.exampleretrofit.listeners;

import com.colabvn.exampleretrofit.model.GreenHouse;

import java.util.ArrayList;

public interface OnGetResultListGreenHouse {
    void onSucess(ArrayList<GreenHouse> arr);
    void onFailed(String s);
}
