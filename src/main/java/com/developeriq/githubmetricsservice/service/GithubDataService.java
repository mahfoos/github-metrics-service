package com.developeriq.githubmetricsservice.service;

import com.developeriq.githubmetricsservice.client.GithubClient;
import com.developeriq.githubmetricsservice.dto.GithubResponse;
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

    public int getCommitsCount(String owner, String repo){
        List <Object> commits = githubClient.getCommits(owner,repo);
        return commits.size();
    }

    public int getIssuesCount(String owner, String repo){
        List <Object> issues = githubClient.getIssues(owner, repo);
        return issues.size();
    }

    public int getUserPrCount(String user) {
       GithubResponse response = githubClient.getUserPullRequests(user);
       return response.getTotal_count();
    }


    public int getIssueParticipateCount(String user){
        GithubResponse response = githubClient.getUserIssueParticipation(user);
        return response.getTotal_count();
    }
}