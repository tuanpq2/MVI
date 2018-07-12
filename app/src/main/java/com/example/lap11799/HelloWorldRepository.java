package com.example.lap11799;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.reactivex.Observable;

public class HelloWorldRepository {
    public Observable<String> loadHelloWorldText(){
        return Observable.just(getRandomMessage());
    }
    private String getRandomMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Hello World");
        messages.add("Hola Mundo");
        messages.add("Chào Thế Giới");
        messages.add("Ciao Mondo");
        messages.add("Bonjour le monde");
        return messages.get(new Random().nextInt(messages.size()));
    }
}
