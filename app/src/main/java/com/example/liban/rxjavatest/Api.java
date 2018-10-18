package com.example.liban.rxjavatest;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Api {
    @GET("posts")
    Observable<List<Users>> getUsers();
}
