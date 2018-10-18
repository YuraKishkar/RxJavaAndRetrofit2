package com.example.liban.rxjavatest;

import android.content.Context;

import java.util.List;

public class Presenter implements Model.postsBack {

    private View mView;
    private Model mModel;
    private Context mContext;


    public Presenter(View mView, Context context) {
        this.mView = mView;
        this.mContext = context;
        mModel = new Model();
        mModel.getPosts(mContext, this);
    }

    public void getPosts(){
        mModel.getPosts(mContext, this);
    }


    @Override
    public void dataPosts(List<Users> users) {
        mView.onData(users);
    }

    @Override
    public void showError(String error) {
        mView.onError(error);
    }

    public void onMainActivityDestroy(){
        mModel.onDispose();
    }
}
