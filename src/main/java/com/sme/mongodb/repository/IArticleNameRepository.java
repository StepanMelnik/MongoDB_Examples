package com.sme.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sme.mongodb.model.ArticleName;

/**
 * Provides Mongo repository to work with {@link ArticleName} domain.
 */
@Repository
public interface IArticleNameRepository extends MongoRepository<ArticleName, String>
{
    /**
     * Fetch all list of {@link ArticleName}.
     */
    @Override
    List<ArticleName> findAll();

    /**
     * Search by text criteria.
     * 
     * @param criteria The text criteria filter;
     * @return Returns the searched documents.
     */
    List<ArticleName> findAllBy(TextCriteria criteria);

    /**
     * Search by text criteria list and order by name.
     * 
     * @param criteria The text criteria filter;
     * @return Returns the searched documents.
     */
    List<ArticleName> findAllByOrderByName(TextCriteria criteria);
}
