package com.example.chorsiphai.rest;

import com.example.chorsiphai.pojo.Game;
import com.example.chorsiphai.pojo.User;
import com.example.chorsiphai.pojo.UserResource;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("/user/{uid}")
    Call<UserResource> doGetUserResources(@Path("uid") long uid);

    @POST("/user")
    Call<User> createUser(@Body User user);

    @POST("/game")
    Call<Game> createGame(@Body Game game);

}
