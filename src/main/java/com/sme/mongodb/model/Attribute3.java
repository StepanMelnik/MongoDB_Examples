package com.sme.mongodb.model;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringStyle;

import com.sme.mongodb.common.Constants;

/**
 * Domain for Attribute3.
 */
public class Attribute3 implements Serializable
{
    private static final long serialVersionUID = Constants.serialVersionUID;

    private Integer attr3Id;
    private String attr3Code;
    private String attr3Desc;

    public Integer getAttr3Id()
    {
        return attr3Id;
    }

    public void setAttr3Id(Integer attr3Id)
    {
        this.attr3Id = attr3Id;
    }

    public String getAttr3Code()
    {
        return attr3Code;
    }

    public void setAttr3Code(String attr3Code)
    {
        this.attr3Code = attr3Code;
    }

    public String getAttr3Desc()
    {
        return attr3Desc;
    }

    public void setAttr3Desc(String attr3Desc)
    {
        this.attr3Desc = attr3Desc;
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
