package com.sme.mongodb.model;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringStyle;

import com.sme.mongodb.common.Constants;

/**
 * Domain for Article.
 */
public class Article implements Serializable
{
    private static final long serialVersionUID = Constants.serialVersionUID;

    private Integer artId;
    private List<ArticleName> articleNames;
    private List<ArticleAttribute> articleAtributes;

    public Integer getArtId()
    {
        return artId;
    }

    public void setArtId(Integer artId)
    {
        this.artId = artId;
    }

    public List<ArticleAttribute> getArticleAtributes()
    {
        return articleAtributes;
    }

    public void setArticleAtributes(List<ArticleAttribute> articleAtributes)
    {
        this.articleAtributes = articleAtributes;
    }

    public List<ArticleName> getArticleNames()
    {
        return articleNames;
    }

    public void setArticleNames(List<ArticleName> articleNames)
    {
        this.articleNames = articleNames;
    }

    @Override
    public int hashCode()
    {
        return reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        return reflectionEquals(this, obj);
    }

    @Override
    public String toString()
    {
        return reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
