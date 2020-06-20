package com.sme.mongodb.model;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringStyle;

import com.sme.mongodb.common.Constants;

/**
 * Domain for ArticlePrice.
 */
public class ArticlePrice implements Serializable
{
    private static final long serialVersionUID = Constants.serialVersionUID;

    private Integer artId;
    private Integer attr1Id;
    private Integer attr2Id;
    private Integer attr3Id;

    /**
     * Value added tax identification number.
     */
    private Float vat;

    /**
     * Sales price including VAT.
     */
    private BigDecimal salesPrice;

    /**
     * Recommended price.
     */
    private BigDecimal recommendedPrice;

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

    public Float getVat()
    {
        return vat;
    }

    public void setVat(Float vat)
    {
        this.vat = vat;
    }

    public BigDecimal getSalesPrice()
    {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice)
    {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getRecommendedPrice()
    {
        return recommendedPrice;
    }

    public void setRecommendedPrice(BigDecimal recommendedPrice)
    {
        this.recommendedPrice = recommendedPrice;
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
