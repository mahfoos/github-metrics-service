package com.developeriq.githubmetricsservice.controller;

import com.developeriq.githubmetricsservice.dto.GithubData;
import com.developeriq.githubmetricsservice.service.GithubDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    private final GithubDataService githubDataService;

    @Autowired
    public MetricsController(GithubDataService githubDataService) {
        this.githubDataService = githubDataService;
    }

    @GetMapping("/github/{username}")
    public GithubData getGithubData(@PathVariable String username) {
        return githubDataService.getGithubData(username);
    }

    @GetMapping("github/{owner}/{repo}/commits")
    public int getCommitCount(@PathVariable String owner, @PathVariable String repo){
        return githubDataService.getCommitsCount(owner, repo);
    }

    @GetMapping("github/{owner}/{repo}/issues")
    public int getIssuesCount(@PathVariable String owner, @PathVariable String repo){
        return githubDataService.getIssuesCount(owner, repo);
    }

    @GetMapping("/test")
    public String getTest(){
        return "Tesing docker";
    }

}