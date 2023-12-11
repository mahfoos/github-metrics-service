package com.developeriq.githubmetricsservice;

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

    @Test
    public void testGetCommitsCount() {
        String owner = "mahfoos";
        String repo = "keploy";
        ResponseEntity<Integer> response = restTemplate.getForEntity("/metrics/github/" + owner + "/" + repo + "/commits", Integer.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void testGetIssuesCount() {
        String owner = "mahfoos";
        String repo = "keploy";
        ResponseEntity<Integer> response = restTemplate.getForEntity("/metrics/github/" + owner + "/" + repo + "/issues", Integer.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void testGetPrCount() {
        String user = "mahfoos";
        ResponseEntity<Integer> response = restTemplate.getForEntity("/metrics/github/search/" + user, Integer.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void testGetIssueParticipantCount() {
        String user = "mahfoos";
        ResponseEntity<Integer> response = restTemplate.getForEntity("/metrics/github/search/issue/" + user, Integer.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }
//    @Test
//    public void testGetMetrics() {
//        String user = "mahfoos";
//        String repo = "keploy";
//        ResponseEntity<String> response = restTemplate.getForEntity("/metrics/github/" + user + "/" + repo, String.class);
//
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }

}