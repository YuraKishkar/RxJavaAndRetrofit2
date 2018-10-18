package com.example.liban.rxjavatest;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private Api api;
    private Disposable disposable;



    public interface postsBack {

        void dataPosts(List<Users> users);
        void showError(String error);
    }


    public Model() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);


    }

    @SuppressLint("CheckResult")
    public void getPosts(final Context context, final postsBack postsBack) {
        disposable = api.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Users>>() {
                    @Override
                    public void accept(List<Users> users) throws Exception {
                        postsBack.dataPosts(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        postsBack.showError(throwable.getMessage());
                    }
                }
    );
    }

    public void onDispose(){
        disposable.dispose();
    }
}
