package com.example.liban.rxjavatest.view;

import com.example.liban.rxjavatest.model.Users;

import java.util.List;

public interface View {
    void onData(List<Users> users);
    void onError(String msg);
}
