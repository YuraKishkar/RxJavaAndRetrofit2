package com.example.liban.rxjavatest;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;
    private Presenter mPresenter;
    private ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.main_constraint);
        mRecyclerView = findViewById(R.id.recycler_id);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPresenter = new Presenter(this, this);

    }


    @Override
    public void onData(List<Users> users) {
        mRecyclerAdapter = new RecyclerAdapter(users, this);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    @Override
    public void onError(String msg) {
        Snackbar.make(constraintLayout, msg, Snackbar.LENGTH_INDEFINITE)
        .setAction("Retry!", new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                mPresenter.getPosts();
            }
        }).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onMainActivityDestroy();
    }
}
