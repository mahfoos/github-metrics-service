package com.developeriq.githubmetricsservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeveloperMetrics {
    private String userId;
    private int commitCount;
    private int issuesCount;
    private int prCount;
    private int issueParticipationCount;
}
