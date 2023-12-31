package com.developeriq.githubmetricsservice.client;

import com.developeriq.githubmetricsservice.dto.DeveloperMetrics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "storage-service", url = "http://data-storage-service:8081")
public interface StorageServiceClient {
    @PostMapping("/storage/metrics")
    public void sendMetrics(@RequestBody DeveloperMetrics metrics);

}
