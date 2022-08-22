package com.spring.s3.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Value("${ACCESS_KEY}")
    private String access_key;

    @Value("${SECRET_KEY}")
    private String secret_key;

    @Bean
    public AmazonS3 s3Client() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(access_key, secret_key);
        return AmazonS3ClientBuilder.standard()
                .withRegion(String.valueOf(Region.US_East_2))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

    }
}
