package com.developeriq.githubmetricsservice.service;

import com.developeriq.githubmetricsservice.client.StorageServiceClient;
import com.developeriq.githubmetricsservice.dto.DeveloperMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricsSendService {

    private final StorageServiceClient storageServiceClient;

    @Autowired
    public MetricsSendService(StorageServiceClient storageServiceClient) {
        this.storageServiceClient = storageServiceClient;
    }

    public void sendMetrics(DeveloperMetrics metrics) {
        storageServiceClient.sendMetrics(metrics);
    }
}


