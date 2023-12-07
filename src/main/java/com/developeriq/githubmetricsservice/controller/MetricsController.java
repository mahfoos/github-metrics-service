package com.developeriq.githubmetricsservice.controller;

import com.developeriq.githubmetricsservice.dto.DeveloperMetrics;
import com.developeriq.githubmetricsservice.service.GithubDataService;
import com.developeriq.githubmetricsservice.service.MetricsSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    private final GithubDataService githubDataService;
    private final MetricsSendService metricsSendService;

    @Autowired
    public MetricsController(GithubDataService githubDataService, MetricsSendService metricsSendService) {
        this.githubDataService = githubDataService;
        this.metricsSendService = metricsSendService;
    }

    @GetMapping("github/{owner}/{repo}/commits")
    public int getCommitCount(@PathVariable String owner, @PathVariable String repo){
        return githubDataService.getCommitsCount(owner, repo);
    }

    @GetMapping("github/{owner}/{repo}/issues")
    public int getIssuesCount(@PathVariable String owner, @PathVariable String repo){
        return githubDataService.getIssuesCount(owner, repo);
    }

    @GetMapping("github/search/{user}")
    public int getPrCount(@PathVariable String user){
        return githubDataService.getUserPrCount(user);
    }

    @GetMapping("github/search/issue/{user}")
    public int getIssueParticipantCount(@PathVariable String user){
        return githubDataService.getIssueParticipateCount(user);
    }


    @GetMapping("github/metrics/{user}/{repo}")
    public ResponseEntity<?> collectAndSendMetrics(@PathVariable String user, @PathVariable String repo) {
        DeveloperMetrics metrics = new DeveloperMetrics();
        metrics.setUserId(user);
        metrics.setCommitCount(githubDataService.getCommitsCount(user, repo));
        metrics.setIssuesCount(githubDataService.getIssuesCount(user, repo));
        metrics.setPrCount(githubDataService.getUserPrCount(user));
        metrics.setIssueParticipationCount(githubDataService.getIssueParticipateCount(user));

        metricsSendService.sendMetrics(metrics);

        return ResponseEntity.ok().build();
    }

}