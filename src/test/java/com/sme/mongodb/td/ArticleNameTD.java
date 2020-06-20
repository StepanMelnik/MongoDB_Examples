package com.sme.mongodb.td;

import static java.util.Arrays.asList;

import java.util.List;

import com.sme.mongodb.model.ArticleName;
import com.sme.mongodb.util.PojoGenericBuilder;

/**
 * ArticleName test data.
 */
public class ArticleNameTD
{
    public static final ArticleName ARTICLE_NAME_1 = new PojoGenericBuilder<>(ArticleName::new)
            .with(ArticleName::setId, "1")
            .with(ArticleName::setArtId, 1)
            .with(ArticleName::setActiveFlg, true)
            .with(ArticleName::setDescription, "Spring t-shirt description")
            .with(ArticleName::setLangId, 1)
            .with(ArticleName::setLinkFriendlyName, "/articles/spring-t-shirt")
            .with(ArticleName::setName, "Spring t-shirt")
            .build();

    public static final ArticleName ARTICLE_NAME_2 = new PojoGenericBuilder<>(ArticleName::new)
            .with(ArticleName::setId, "2")
            .with(ArticleName::setArtId, 1)
            .with(ArticleName::setActiveFlg, true)
            .with(ArticleName::setDescription, "Omega t-shirt description (NO language)")
            .with(ArticleName::setLangId, 2)
            .with(ArticleName::setLinkFriendlyName, "/no/articles/spring-t-shirt")
            .with(ArticleName::setName, "Omega t-shirt (NO language)")
            .build();

    public static final ArticleName ARTICLE_NAME_3 = new PojoGenericBuilder<>(ArticleName::new)
            .with(ArticleName::setId, "3")
            .with(ArticleName::setArtId, 1)
            .with(ArticleName::setActiveFlg, true)
            .with(ArticleName::setDescription, "Simple t-shirt description (UA language)")
            .with(ArticleName::setLangId, 2)
            .with(ArticleName::setLinkFriendlyName, "/ua/articles/spring-t-shirt")
            .with(ArticleName::setName, "Simple t-shirt (UA language)")
            .build();

    public static final List<ArticleName> ARTICLE_NAMES = asList(ARTICLE_NAME_1, ARTICLE_NAME_2, ARTICLE_NAME_3);

    private ArticleNameTD()
    {
    }
}
