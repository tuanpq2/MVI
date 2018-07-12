package com.example.lap11799;

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HelloWorldPresenter extends MviBasePresenter<HelloWorldView,HelloWorldViewState> {

    @Override
    protected void bindIntents() {
        Observable<HelloWorldViewState> helloWorldState = intent(HelloWorldView::sayHelloWorldIntent)
                .switchMap(input -> new GetHelloWorldTextUsecase().getHelloWorldText())
                .startWith(new HelloWorldViewState.Loading())
                .onErrorReturn(HelloWorldViewState.Error::new)
                .subscribeOn(Schedulers.io());
        subscribeViewState(helloWorldState,HelloWorldView::render);
    }
}
