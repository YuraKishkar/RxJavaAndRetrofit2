package com.example.liban.rxjavatest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private Api api;



    public interface postsBack {

        void dataPosts(List<Users> users);
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

    public void getPosts(final Context context, final postsBack postsBack) {
        api.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Users>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Users> users) {
                        postsBack.dataPosts(users);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("ErrorTag", "This: " + e);
                    }

                    @Override
                    public void onComplete() {


                    }
                });
    }
}
