package com.developeriq.githubmetricsservice.client;

import com.developeriq.githubmetricsservice.dto.DeveloperMetrics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "storage-service", url = "http://4.157.158.246:8081/")
public interface StorageServiceClient {

    @PostMapping("/store/metrics")
    public void sendMetrics(@RequestBody DeveloperMetrics metrics);

}

