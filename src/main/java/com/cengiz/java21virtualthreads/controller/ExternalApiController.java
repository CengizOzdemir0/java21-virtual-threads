package com.cengiz.java21virtualthreads.controller;

import com.cengiz.java21virtualthreads.service.ExternalApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExternalApiController {

    private final ExternalApiService externalApiService;

    public ExternalApiController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/external-data-platform")
    public List<String> getExternalDataWithPlatformThreads() {
        long startTime = System.currentTimeMillis();
        List<String> response = externalApiService.fetchExternalDataWithPlatformThreads();
        long endTime = System.currentTimeMillis();

        System.out.println("Platform Threads İşlem Süresi: " + (endTime - startTime) + " ms");

        return response;
    }

    @GetMapping("/external-data-virtual")
    public List<String> getExternalDataWithVirtualThreads() {
        long startTime = System.currentTimeMillis();
        List<String> response = externalApiService.fetchExternalDataWithVirtualThreads();
        long endTime = System.currentTimeMillis();

        System.out.println("Virtual Threads İşlem Süresi: " + (endTime - startTime) + " ms");

        return response;
    }
}
