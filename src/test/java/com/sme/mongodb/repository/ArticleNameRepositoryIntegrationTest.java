package com.sme.mongodb.repository;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
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
public class ArticleNameRepositoryIntegrationTest
{
    @Autowired
    private IArticleNameRepository articleNameRepository;

    @BeforeEach
    public void setUp()
    {
        articleNameRepository.deleteAll();
    }

    @Test
    public void testSave() throws Exception
    {
        // db.ArticleName.insert({"activeFlg":true,"artId":1,"description":"Spring t-shirt description","id":"1","langId":1,"linkFriendlyName":"\/articles\/spring-t-shirt","name":"Spring t-shirt"})
        articleNameRepository.save(ArticleNameTD.ARTICLE_NAME_1);

        // db.ArticleName.findOne({ "id" : "1"})
        Optional<ArticleName> articleName = articleNameRepository.findById(ArticleNameTD.ARTICLE_NAME_1.getId());
        assertEquals(ArticleNameTD.ARTICLE_NAME_1, articleName.get());
    }

    @Test
    public void testFindAll() throws Exception
    {
        // db.ArticleName.insert({"activeFlg":true,"artId":1,"description":"Spring t-shirt description","id":"1","langId":1,"linkFriendlyName":"\/articles\/spring-t-shirt","name":"Spring t-shirt"})
        articleNameRepository.saveAll(ArticleNameTD.ARTICLE_NAMES);

        // db.ArticleName.find().pretty()
        assertEquals(ArticleNameTD.ARTICLE_NAMES, articleNameRepository.findAll());
    }

    @Test
    public void testDelete() throws Exception
    {
        // db.ArticleName.insert({"activeFlg":true,"artId":1,"description":"Spring t-shirt description","id":"1","langId":1,"linkFriendlyName":"\/articles\/spring-t-shirt","name":"Spring t-shirt"})
        articleNameRepository.saveAll(ArticleNameTD.ARTICLE_NAMES);

        // db.ArticleName.deleteOne({"_id":1})
        articleNameRepository.delete(ArticleNameTD.ARTICLE_NAME_1);

        // db.ArticleName.find().pretty()
        assertEquals(asList(ArticleNameTD.ARTICLE_NAME_2, ArticleNameTD.ARTICLE_NAME_3), articleNameRepository.findAll());
    }
}
