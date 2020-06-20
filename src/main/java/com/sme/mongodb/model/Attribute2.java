package com.sme.mongodb.model;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringStyle;

import com.sme.mongodb.common.Constants;

/**
 * Domain for Attribute2.
 */
public class Attribute2 implements Serializable
{
    private static final long serialVersionUID = Constants.serialVersionUID;

    private Integer attr2Id;
    private String attr2Code;
    private String attr2Desc;

    public Integer getAttr2Id()
    {
        return attr2Id;
    }

    public void setAttr2Id(Integer attr2Id)
    {
        this.attr2Id = attr2Id;
    }

    public String getAttr2Code()
    {
        return attr2Code;
    }

    public void setAttr2Code(String attr2Code)
    {
        this.attr2Code = attr2Code;
    }

    public String getAttr2Desc()
    {
        return attr2Desc;
    }

    public void setAttr2Desc(String attr2Desc)
    {
        this.attr2Desc = attr2Desc;
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
