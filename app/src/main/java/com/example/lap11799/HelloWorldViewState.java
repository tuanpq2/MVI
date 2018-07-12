package com.example.lap11799;


public interface HelloWorldViewState {

    final class Loading implements HelloWorldViewState {
        public Loading() {
        }
    }

    final class GotGreeting implements HelloWorldViewState {
        public String greeting;

        public GotGreeting(String greeting) {
            this.greeting = greeting;
        }
    }

    final class Error implements HelloWorldViewState {
        public Throwable error;

        public Error(Throwable error) {
            this.error = error;
        }
    }
}
