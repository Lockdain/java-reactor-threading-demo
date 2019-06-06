package ru.msk.java.webfluxmonotest.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.msk.java.webfluxmonotest.demo.db.Simulator;
import ru.msk.java.webfluxmonotest.demo.processing.Process;
import ru.msk.java.webfluxmonotest.demo.processing.Response;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/")
@Slf4j
public class HelloController {

    @Autowired
    Process process;

    @Autowired
    Simulator simulator;

    @GetMapping(value = "/test")
    public Mono<Response> getTest() throws InterruptedException, ExecutionException {
        String info = "====> HTTP request: ";
        log.info(info + Thread.currentThread().getName());

        return process.processFuture(simulator.getResult("Hey!"))
                .log("====> HTTP response: " + Thread.currentThread().getName());

    }
}
