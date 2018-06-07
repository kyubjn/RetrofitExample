package com.colabvn.exampleretrofit.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GreenHouse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private String image;
    @SerializedName("user_id")
    private Integer user_id;
    @SerializedName("province_id")
    private Integer province_id;
    @SerializedName("address")
    private String address;
    @SerializedName("status")
    private Integer status;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("updatedAt")
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    private GreenHouse UserGreenHouse;

    public GreenHouse getUserGreenHouse() {
        return UserGreenHouse;
    }

    public void setUserGreenHouse(GreenHouse userGreenHouse) {
        UserGreenHouse = userGreenHouse;
    }


    public static GreenHouse getGreenHouse(JSONObject obj) {
        return new Gson().fromJson(obj.toString(), GreenHouse.class);
    }

    public static ArrayList<GreenHouse> getAllGreenHouse(JSONArray arr) throws JSONException {
        ArrayList<GreenHouse> ret = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            ret.add(getGreenHouse(arr.getJSONObject(i)));
        }
        return ret;
    }
}
