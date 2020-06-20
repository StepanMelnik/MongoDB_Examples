package com.sme.mongodb.model;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringStyle;

import com.sme.mongodb.common.Constants;

/**
 * Domain for ArticleAttribute.
 */
public class ArticleAttribute implements Serializable
{
    private static final long serialVersionUID = Constants.serialVersionUID;

    private Integer id;
    private Integer artId;
    private Integer attr1Id;
    private Integer attr2Id;
    private Integer attr3Id;
    private String pluno;
    private String ean13;
    private String extra1 = "";
    private String extra2 = "";
    private String extra3 = "";
    private Boolean inStock;

    private Attribute1 attribute1;
    private Attribute2 attribute2;
    private Attribute3 attribute3;

    private ArticlePrice articlePrice;

    private double weight;
    private double width;
    private double height;
    private double length;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
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

    public Integer getAttr1Id()
    {
        return attr1Id;
    }

    public void setAttr1Id(Integer attr1Id)
    {
        this.attr1Id = attr1Id;
    }

    public Integer getAttr2Id()
    {
        return attr2Id;
    }

    public void setAttr2Id(Integer attr2Id)
    {
        this.attr2Id = attr2Id;
    }

    public Integer getAttr3Id()
    {
        return attr3Id;
    }

    public void setAttr3Id(Integer attr3Id)
    {
        this.attr3Id = attr3Id;
    }

    public String getPluno()
    {
        return pluno;
    }

    public void setPluno(String pluno)
    {
        this.pluno = pluno;
    }

    public String getEan13()
    {
        return ean13;
    }

    public void setEan13(String ean13)
    {
        this.ean13 = ean13;
    }

    public String getExtra1()
    {
        return extra1;
    }

    public void setExtra1(String extra1)
    {
        this.extra1 = extra1;
    }

    public String getExtra2()
    {
        return extra2;
    }

    public void setExtra2(String extra2)
    {
        this.extra2 = extra2;
    }

    public String getExtra3()
    {
        return extra3;
    }

    public void setExtra3(String extra3)
    {
        this.extra3 = extra3;
    }

    public Boolean getInStock()
    {
        return inStock;
    }

    public void setInStock(Boolean inStock)
    {
        this.inStock = inStock;
    }

    public Attribute1 getAttribute1()
    {
        return attribute1;
    }

    public void setAttribute1(Attribute1 attribute1)
    {
        this.attribute1 = attribute1;
    }

    public Attribute2 getAttribute2()
    {
        return attribute2;
    }

    public void setAttribute2(Attribute2 attribute2)
    {
        this.attribute2 = attribute2;
    }

    public Attribute3 getAttribute3()
    {
        return attribute3;
    }

    public void setAttribute3(Attribute3 attribute3)
    {
        this.attribute3 = attribute3;
    }

    public ArticlePrice getArticlePrice()
    {
        return articlePrice;
    }

    public void setArticlePrice(ArticlePrice articlePrice)
    {
        this.articlePrice = articlePrice;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
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
