package com.sme.mongodb.model;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sme.mongodb.common.Constants;

/**
 * Domain for {@link ArticleName}.
 */
@Document(collection = "ArticleName")
public class ArticleName implements Serializable
{
    private static final long serialVersionUID = Constants.serialVersionUID;

    @Id
    private String id;
    private Integer artId;
    private Integer langId;
    private @TextIndexed(weight = 2) String name = "";
    private @TextIndexed(weight = 3) String description = "";
    private String linkFriendlyName = "";
    private boolean activeFlg = true;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Integer getArtId()
    {
        return artId;
    }

    public void setArtId(Integer artId)
    {
        this.artId = artId;
    }

    public Integer getLangId()
    {
        return langId;
    }

    public void setLangId(Integer langId)
    {
        this.langId = langId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLinkFriendlyName()
    {
        return linkFriendlyName;
    }

    public void setLinkFriendlyName(String linkFriendlyName)
    {
        this.linkFriendlyName = linkFriendlyName;
    }

    public boolean isActiveFlg()
    {
        return activeFlg;
    }

    public void setActiveFlg(boolean activeFlg)
    {
        this.activeFlg = activeFlg;
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
