package com.developeriq.githubmetricsservice;

import org.springframework.beans.factory.annotation.Value;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GitHubMetricsServiceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${test.github.owner}")
    private String testGithubOwner;

    @Value("${test.github.repo}")
    private String testGithubRepo;

    @Value("${test.github.user}")
    private String testGithubUser;
    @Test
    public void testGetCommitsCount() {
        ResponseEntity<Integer> response = restTemplate.getForEntity("/metrics/github/" + testGithubOwner + "/" + testGithubRepo + "/commits", Integer.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void testGetIssuesCount() {
        ResponseEntity<Integer> response = restTemplate.getForEntity("/metrics/github/" + testGithubOwner + "/" + testGithubRepo + "/issues", Integer.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void testGetPrCount() {
        ResponseEntity<Integer> response = restTemplate.getForEntity("/metrics/github/search/" + testGithubUser, Integer.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void testGetIssueParticipantCount() {
        ResponseEntity<Integer> response = restTemplate.getForEntity("/metrics/github/search/issue/" + testGithubUser, Integer.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

}