package com.sme.mongodb.model;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringStyle;

import com.sme.mongodb.common.Constants;

/**
 * Domain for Attribute1.
 */
public class Attribute1 implements Serializable
{
    private static final long serialVersionUID = Constants.serialVersionUID;

    private Integer attr1Id;
    private String attr1Code;
    private String attr1Desc;
    private String attr1No;
    private String rgbCode;

    public Integer getAttr1Id()
    {
        return attr1Id;
    }

    public void setAttr1Id(Integer attr1Id)
    {
        this.attr1Id = attr1Id;
    }

    public String getAttr1Code()
    {
        return attr1Code;
    }

    public void setAttr1Code(String attr1Code)
    {
        this.attr1Code = attr1Code;
    }

    public String getAttr1Desc()
    {
        return attr1Desc;
    }

    public void setAttr1Desc(String attr1Desc)
    {
        this.attr1Desc = attr1Desc;
    }

    public String getAttr1No()
    {
        return attr1No;
    }

    public void setAttr1No(String attr1No)
    {
        this.attr1No = attr1No;
    }

    public String getRgbCode()
    {
        return rgbCode;
    }

    public void setRgbCode(String rgbCode)
    {
        this.rgbCode = rgbCode;
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
