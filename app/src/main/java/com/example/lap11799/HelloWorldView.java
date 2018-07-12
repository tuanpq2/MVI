package com.example.lap11799;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import io.reactivex.Observable;

public interface HelloWorldView extends MvpView {
    Observable<String> sayHelloWorldIntent();
    void render(HelloWorldViewState state);
}
