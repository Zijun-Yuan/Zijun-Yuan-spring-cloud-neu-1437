package com.b430.admintaskservice.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.b430.admintaskservice.service")
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchConfig.class);

    private String elasticsearchHost = "localhost";

    private int elasticsearchPort = 9200;

    private String elasticsearchUsername = "root";

    private String elasticsearchPassword = "123456";

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        logger.info("elasticsearch.host: {}", elasticsearchHost);
        logger.info("elasticsearch.port: {}", elasticsearchPort);
        logger.info("elasticsearch.username: {}", elasticsearchUsername);
        logger.info("elasticsearch.password: {}", elasticsearchPassword);

        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(elasticsearchUsername, elasticsearchPassword));

        RestClientBuilder builder = RestClient.builder(
                        new HttpHost(elasticsearchHost, elasticsearchPort, "http"))
                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));

        return new RestHighLevelClient(builder);
    }

    @Bean
    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
}
