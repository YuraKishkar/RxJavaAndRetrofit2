package com.example.liban.rxjavatest.api;

import com.example.liban.rxjavatest.model.Users;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface Api {
    @GET("posts")
    Single<List<Users>> getUsers();
}
