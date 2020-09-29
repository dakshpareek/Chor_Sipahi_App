package com.example.chorsiphai.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResource {
    @SerializedName("uid")
    @Expose
    public Integer uid;
    @SerializedName("name")
    @Expose
    public String name;
}
