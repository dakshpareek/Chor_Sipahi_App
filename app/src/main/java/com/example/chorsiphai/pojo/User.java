package com.example.chorsiphai.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {


    @SerializedName("name")
    public String name;

    @SerializedName("uid")
    public long uid;

    public User()
    {

    }
    public User(String name) {
        this.name = name;
    }

}
