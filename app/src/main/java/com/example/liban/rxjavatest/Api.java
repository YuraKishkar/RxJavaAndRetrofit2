package com.example.liban.rxjavatest;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface Api {
    @GET("posts")
    Single<List<Users>> getUsers();
}
