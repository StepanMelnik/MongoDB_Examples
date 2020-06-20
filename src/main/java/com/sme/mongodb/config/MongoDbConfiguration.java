package com.sme.mongodb.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.mapping.event.LoggingEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.sme.mongodb.model.ArticleName;

/**
 * Spring boot configuration to work with Mongo DB.
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "com.sme.mongodb")
public class MongoDbConfiguration
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDbConfiguration.class);

    @Autowired
    private MongoOperations mongoOperations;

    @Bean
    public LoggingEventListener mongoEventListener()
    {
        return new LoggingEventListener();
    }

    @PostConstruct
    private void postConstruct()
    {
        IndexResolver indexResolver = IndexResolver.create(mongoOperations.getConverter().getMappingContext());
        indexResolver.resolveIndexFor(ArticleName.class)
                .forEach(id ->
                {
                    LOGGER.debug("Process {} Index Definition", id);
                    mongoOperations.indexOps(ArticleName.class).ensureIndex(id);
                });
    }
}
