package ru.msk.java.webfluxmonotest.demo.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class Simulator {

    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    public CompletableFuture<String> getResult(String str) throws InterruptedException {

        String info = " ====> Before database query handling:";
        log.info(info + Thread.currentThread().getName());
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s = "You've wrote " + str;

            return s;
        }, executorService);

        return completableFuture;
    }
}
