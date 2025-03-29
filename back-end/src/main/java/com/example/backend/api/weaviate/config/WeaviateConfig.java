package com.example.backend.api.weaviate.config;

import io.weaviate.client.Config;
import io.weaviate.client.WeaviateAuthClient;
import io.weaviate.client.WeaviateClient;
import io.weaviate.client.v1.auth.exception.AuthException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeaviateConfig {

    @Value("${WCD_HOSTNAME}")
    private String host;

    @Value("${WCD_API_KEY}")
    private String apiKey;

    @Bean
    public WeaviateClient weaviateClient() throws AuthException {
        Config config = new Config("https", host);
        return WeaviateAuthClient.apiKey(config, apiKey);
    }
}
