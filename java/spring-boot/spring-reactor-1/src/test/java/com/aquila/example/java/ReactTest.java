package com.aquila.example.java;


import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;
import reactor.util.context.Context;

import java.time.Duration;

class ReactTest {

    @Test
    void simpleFluxExample1() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        fluxColors.subscribe(System.out::println);
    }

    @Test
    void simpleFluxExample2() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        fluxColors.log().subscribe(System.out::println);
    }

    @Test
    void mapExample() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        fluxColors.map(color -> color.charAt(0)).subscribe(System.out::println);
    }

    @Test
    void zipExample() {
        Flux<String> fluxFruits = Flux.just("apple", "pear", "plum");
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        Flux<Integer> fluxAmounts = Flux.just(10, 20, 30);
        Flux.zip(fluxFruits, fluxColors, fluxAmounts).subscribe(System.out::println);
    }

    @Test
    public void onErrorExample() {
        Flux<String> fluxCalc = Flux.just(-1, 0, 1)
                .map(i -> "10 / " + i + " = " + (10 / i));

        fluxCalc.subscribe(value -> System.out.println("Next: " + value),
                error -> System.err.println("Error: " + error));
    }

    @Test
    public void onErrorReturnExample() {
        Flux<String> fluxCalc = Flux.just(-1, 0, 1)
                .map(i -> "10 / " + i + " = " + (10 / i))
                .onErrorReturn(ArithmeticException.class, "Division by 0 not allowed");

        fluxCalc.subscribe(value -> System.out.println("Next: " + value),
                error -> System.err.println("Error: " + error));

    }

    @Test
    public void stepVerifierTest() {
        Flux<String> fluxCalc = Flux.just(-1, 0, 1)
                .map(i -> "10 / " + i + " = " + (10 / i));

        StepVerifier.create(fluxCalc)
                .expectNextCount(1)
                .expectError(ArithmeticException.class)
                .verify();
    }

    @Test
    public void publishSubscribeExample() {
        Scheduler schedulerA = Schedulers.newParallel("Scheduler A");
        Scheduler schedulerB = Schedulers.newParallel("Scheduler B");
        Scheduler schedulerC = Schedulers.newParallel("Scheduler C");

        Flux.just(1)
                .map(i -> {
                    System.out.println("First map: " + Thread.currentThread().getName());
                    return i;
                })
                .subscribeOn(schedulerA)
                .map(i -> {
                    System.out.println("Second map: " + Thread.currentThread().getName());
                    return i;
                })
                .publishOn(schedulerB)
                .map(i -> {
                    System.out.println("Third map: " + Thread.currentThread().getName());
                    return i;
                })
                .subscribeOn(schedulerC)
                .map(i -> {
                    System.out.println("Fourth map: " + Thread.currentThread().getName());
                    return i;
                })
                .publishOn(schedulerA)
                .map(i -> {
                    System.out.println("Fifth map: " + Thread.currentThread().getName());
                    return i;
                })
                .blockLast();
    }

    @Test
    public void coldPublisherExample() throws InterruptedException {
        Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(1));
        Thread.sleep(2000);
        intervalFlux.subscribe(i -> System.out.println(String.format("Subscriber A, value: %d", i)));
        Thread.sleep(2000);
        intervalFlux.subscribe(i -> System.out.println(String.format("Subscriber B, value: %d", i)));
        Thread.sleep(3000);
    }

    @Test
    public void hotPublisherExample() throws InterruptedException {
        Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(1));
        ConnectableFlux<Long> intervalCF = intervalFlux.publish();
        intervalCF.connect();
        Thread.sleep(2000);
        intervalCF.subscribe(i -> System.out.println(String.format("Subscriber A, value: %d", i)));
        Thread.sleep(2000);
        intervalCF.subscribe(i -> System.out.println(String.format("Subscriber B, value: %d", i)));
        Thread.sleep(3000);
    }

    @Test
    public void backpressureExample() {
        Flux.range(1,5)
                .subscribe(new Subscriber<Integer>() {
                    private Subscription s;
                    int counter;

                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("onSubscribe");
                        this.s = s;
                        System.out.println("Requesting 2 emissions");
                        s.request(2);
                    }

                    @Override
                    public void onNext(Integer i) {
                        System.out.println("onNext " + i);
                        counter++;
                        if (counter % 2 == 0) {
                            System.out.println("Requesting 2 emissions");
                            s.request(2);
                        }
                        if (counter % 3 == 0) {
                            System.out.println("Requesting cancel");
                            s.cancel();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.err.println("onError");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

//    @Test
//    public void contextTest() {
//        String key = "key";
//        Mono<String> mono = Mono.just("anything")
//                .flatMap(s -> Mono.subscriberContext()
//                        .map(ctx -> "Value stored in context: " + ctx.get(key)))
//                .subscriberContext(ctx -> ctx.put(key, "myValue"));
//
//        StepVerifier.create(mono)
//                .expectNext("Value stored in context: myValue")
//                .verifyComplete();
//    }
}
