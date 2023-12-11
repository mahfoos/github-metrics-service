package com.developeriq.githubmetricsservice.controller;

public class EnvTest {
    public static void main(String[] args) {
        System.out.println("DB_URL: " + System.getenv("DB_URL"));
        System.out.println("DB_USERNAME: " + System.getenv("DB_USERNAME"));
        System.out.println("DB_PASSWORD: " + System.getenv("DB_PASSWORD"));
    }
}
