package ru.msk.java.webfluxmonotest.demo.processing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class Process {
    public Mono<Response> processFuture(CompletableFuture<String> completableFuture) throws InterruptedException, ExecutionException {
        String info = " ====> Future from DB is handling by:";
        log.info(info + Thread.currentThread().getName());

        return Mono.fromFuture(completableFuture)
                .flatMap(f -> {
                    Response response = new Response();
                    response.setResult(f);
                    log.info("processFuture()->fromFuture: " + Thread.currentThread().getName());

                    return Mono.just(response)
                            .flatMap(m -> {
                                String s = m.getResult() + "...";
                                Response response1 = new Response();
                                response1.setResult(s);
                                return Mono.just(response1);
                            })
                            .log("processFuture()->flatMap:  "
                                    + Thread.currentThread().getName());
                });
    }
}


