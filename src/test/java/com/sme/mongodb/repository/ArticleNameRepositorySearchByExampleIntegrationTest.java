package com.sme.mongodb.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sme.mongodb.config.MongoDbConfiguration;
import com.sme.mongodb.model.ArticleName;
import com.sme.mongodb.td.ArticleNameTD;
import com.sme.mongodb.util.PojoGenericBuilder;

/**
 * Unit tests of {@link IArticleNameRepository}.
 * <p>
 * All Mongo queries performed by {@link MongoTemplate}.
 * </p>
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {MongoDbConfiguration.class})
public class ArticleNameRepositorySearchByExampleIntegrationTest
{
    @Autowired
    private IArticleNameRepository articleNameRepository;

    @BeforeEach
    public void setUp()
    {
        articleNameRepository.deleteAll();
    }

    @Test
    public void testFindCountByExample() throws Exception
    {
        // db.ArticleName.insert({"activeFlg":true,"artId":1,"description":"Spring t-shirt description","id":"1","langId":1,"linkFriendlyName":"\/articles\/spring-t-shirt","name":"Spring t-shirt"})
        articleNameRepository.saveAll(ArticleNameTD.ARTICLE_NAMES);

        long count = articleNameRepository.count(Example.of(new PojoGenericBuilder<>(ArticleName::new)
                .with(ArticleName::setName, ArticleNameTD.ARTICLE_NAME_2.getName())
                .build()));
        assertEquals(0, count, "Expects zero document");

        long count1 = articleNameRepository.count(Example.of(new PojoGenericBuilder<>(ArticleName::new)
                .with(ArticleName::setName, ArticleNameTD.ARTICLE_NAME_2.getName())
                .with(ArticleName::setDescription, null)        // ignore the field
                .with(ArticleName::setLinkFriendlyName, null)   // ignore the field
                .build()));
        assertEquals(1, count1, "Expects one document");
    }

    @Test
    public void testFindByExampleWithIgnoreProperties() throws Exception
    {
        // db.ArticleName.insert({"activeFlg":true,"artId":1,"description":"Spring t-shirt description","id":"1","langId":1,"linkFriendlyName":"\/articles\/spring-t-shirt","name":"Spring t-shirt"})
        articleNameRepository.saveAll(ArticleNameTD.ARTICLE_NAMES);

        Example<ArticleName> example = Example.of(new PojoGenericBuilder<>(ArticleName::new)
                .with(ArticleName::setName, ArticleNameTD.ARTICLE_NAME_2.getName())
                .with(ArticleName::setDescription, "another description")       // no matching on the field
                .with(ArticleName::setLinkFriendlyName, "another link")         // no matching on the field
                .build(),
                ExampleMatcher.matching()
                        .withIgnorePaths("description", "linkFriendlyName"));

        assertEquals(ArticleNameTD.ARTICLE_NAME_2, articleNameRepository.findOne(example).get());
    }

    @Test
    public void testFindByExampleWithSubstringMatching() throws Exception
    {
        // db.ArticleName.insert({"activeFlg":true,"artId":1,"description":"Spring t-shirt description","id":"1","langId":1,"linkFriendlyName":"\/articles\/spring-t-shirt","name":"Spring t-shirt"})
        articleNameRepository.saveAll(ArticleNameTD.ARTICLE_NAMES);

        Example<ArticleName> example = Example.of(new PojoGenericBuilder<>(ArticleName::new)
                .with(ArticleName::setName, ArticleNameTD.ARTICLE_NAME_2.getName().substring(5))
                .with(ArticleName::setDescription, "another description")       // no matching on the field
                .with(ArticleName::setLinkFriendlyName, "another link")         // no matching on the field
                .build(),
                ExampleMatcher.matching()
                        .withIgnorePaths("description", "linkFriendlyName")
                        .withStringMatcher(StringMatcher.ENDING));

        assertEquals(ArticleNameTD.ARTICLE_NAME_2, articleNameRepository.findOne(example).get());
    }

    @Test
    public void testFindByExampleWithRegexpMatching() throws Exception
    {
        // db.ArticleName.insert({"activeFlg":true,"artId":1,"description":"Spring t-shirt description","id":"1","langId":1,"linkFriendlyName":"\/articles\/spring-t-shirt","name":"Spring t-shirt"})
        articleNameRepository.saveAll(ArticleNameTD.ARTICLE_NAMES);

        Example<ArticleName> example = Example.of(new PojoGenericBuilder<>(ArticleName::new)
                .with(ArticleName::setName, ".+t-shirt .+")
                .with(ArticleName::setDescription, "another description")       // no matching on the field
                .with(ArticleName::setLinkFriendlyName, "another link")         // no matching on the field
                .build(),
                ExampleMatcher.matching()
                        .withIgnorePaths("description", "linkFriendlyName")
                        .withMatcher("name", matcher -> matcher.regex()));

        assertEquals(Arrays.asList(ArticleNameTD.ARTICLE_NAME_2, ArticleNameTD.ARTICLE_NAME_3), articleNameRepository.findAll(example));
    }
}
