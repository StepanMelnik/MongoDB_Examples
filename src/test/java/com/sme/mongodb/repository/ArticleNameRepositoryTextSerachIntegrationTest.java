package com.sme.mongodb.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sme.mongodb.config.MongoDbConfiguration;
import com.sme.mongodb.model.ArticleName;
import com.sme.mongodb.td.ArticleNameTD;

/**
 * Unit tests of {@link IArticleNameRepository}.
 * <p>
 * All Mongo queries performed by {@link MongoTemplate}.
 * </p>
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {MongoDbConfiguration.class})
public class ArticleNameRepositoryTextSerachIntegrationTest
{
    @Autowired
    private IArticleNameRepository articleNameRepository;

    @BeforeEach
    public void setUp()
    {
        articleNameRepository.deleteAll();
    }

    @Test
    public void testFindByTextCriteria() throws Exception
    {
        // db.ArticleName.insert({"activeFlg":true,"artId":1,"description":"Spring t-shirt description","id":"1","langId":1,"linkFriendlyName":"\/articles\/spring-t-shirt","name":"Spring t-shirt"})
        articleNameRepository.saveAll(ArticleNameTD.ARTICLE_NAMES);

        TextCriteria criteria = TextCriteria.forDefaultLanguage().matching("t-shirt");
        List<ArticleName> list = articleNameRepository.findAllBy(criteria);

        assertEquals(ArticleNameTD.ARTICLE_NAMES, list);
    }

    @Test
    public void testFindByTextCriteriaWithNotMatching() throws Exception
    {
        // db.ArticleName.insert({"activeFlg":true,"artId":1,"description":"Spring t-shirt description","id":"1","langId":1,"linkFriendlyName":"\/articles\/spring-t-shirt","name":"Spring t-shirt"})
        articleNameRepository.saveAll(ArticleNameTD.ARTICLE_NAMES);

        TextCriteria criteria = TextCriteria.forDefaultLanguage().matching("t-shirt").notMatching("Simple");
        List<ArticleName> list = articleNameRepository.findAllBy(criteria);

        assertEquals(Arrays.asList(ArticleNameTD.ARTICLE_NAME_1, ArticleNameTD.ARTICLE_NAME_2), list);
    }
}
