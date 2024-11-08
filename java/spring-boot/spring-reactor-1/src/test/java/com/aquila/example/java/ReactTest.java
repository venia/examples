package com.aquila.example.java;


import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

class ReactTest {

    @Test
    void simpleFluxExample() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        fluxColors.subscribe(System.out::println);
    }
}
