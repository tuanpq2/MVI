package com.example.lap11799;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lap11799.mvi.R;
import com.hannesdorfmann.mosby3.mvi.MviActivity;
import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.Observable;

public class MainActivity extends MviActivity<HelloWorldView,HelloWorldPresenter> implements HelloWorldView {

    TextView textView;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    @NonNull
    @Override
    public HelloWorldPresenter createPresenter() {
        return new HelloWorldPresenter();
    }

    @Override
    public Observable<String> sayHelloWorldIntent() {
        return RxView.clicks(button).map(click -> "greeting");
    }

    @Override
    public void render(HelloWorldViewState state) {
        if(state instanceof HelloWorldViewState.Loading)
            renderLoadingState();
        else if(state instanceof HelloWorldViewState.GotGreeting)
            renderDataState((HelloWorldViewState.GotGreeting) state);
        else{
            renderErrorState((HelloWorldViewState.Error) state);
        }
    }

    private void renderLoadingState(){
        progressBar.setVisibility(View.VISIBLE);
    }

    private void renderDataState(HelloWorldViewState.GotGreeting greeting){
        progressBar.setVisibility(View.GONE);
        textView.setText(greeting.greeting);
        System.out.println(greeting.greeting);
    }

    private void renderErrorState(HelloWorldViewState.Error error){
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
    }

}
