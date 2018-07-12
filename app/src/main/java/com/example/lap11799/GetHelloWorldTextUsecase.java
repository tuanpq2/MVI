package com.example.lap11799;


import io.reactivex.Observable;

public class GetHelloWorldTextUsecase {
    public Observable<HelloWorldViewState> getHelloWorldText() {
        return new HelloWorldRepository().loadHelloWorldText()
                .map(HelloWorldViewState.GotGreeting::new);
    }
}
