package com.developeriq.githubmetricsservice.client;

import com.developeriq.githubmetricsservice.dto.GithubData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "githubClient", url = "https://api.github.com")
public interface GithubClient {

    @GetMapping("/users/{username}")
    GithubData fetchGithubData(@PathVariable String username);

    @GetMapping("/repos/{owner}/{repo}/commits")
    List<Object> getCommits(@PathVariable String owner, @PathVariable String repo);

    @GetMapping("/repos/{owner}/{repo}/issues")
    List<Object> getIssues(@PathVariable String owner, @PathVariable String repo);
}