package com.developeriq.githubmetricsservice.repository;

import com.developeriq.githubmetricsservice.entity.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricsRepository extends JpaRepository<Metric, String> {
}