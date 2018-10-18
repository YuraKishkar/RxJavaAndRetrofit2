package com.example.liban.rxjavatest;

import java.util.List;

interface View {
    void onData(List<Users> users);
    void onError(String msg);
}
