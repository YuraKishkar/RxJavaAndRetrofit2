package com.example.liban.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;
    private Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_id);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPresenter = new Presenter(this, this);

    }


    @Override
    public void onData(List<Users> users) {
        mRecyclerAdapter = new RecyclerAdapter(users, this);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }
}
