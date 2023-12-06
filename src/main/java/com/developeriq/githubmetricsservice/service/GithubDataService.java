package com.developeriq.githubmetricsservice.service;

import com.developeriq.githubmetricsservice.client.GithubClient;
import com.developeriq.githubmetricsservice.dto.GithubData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubDataService {

    private final GithubClient githubClient;

    @Autowired
    public GithubDataService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public GithubData getGithubData(String username) {
        return githubClient.fetchGithubData(username);
    }

    public int getCommitsCount(String owner, String repo){
        List <Object> commits = githubClient.getCommits(owner,repo);
        return commits.size();
    }

    public int getIssuesCount(String owner, String repo){
        List <Object> issues = githubClient.getIssues(owner, repo);
        return issues.size();
    }
}