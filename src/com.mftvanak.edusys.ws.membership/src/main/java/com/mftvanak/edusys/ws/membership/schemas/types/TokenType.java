//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.19 at 01:05:32 AM IRDT 
//


package com.mftvanak.edusys.ws.membership.schemas.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TokenType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TokenType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DeactivityMaximumDurationInMinutes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ExpireDate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LastAccessDate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SubmitDate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TokenType", propOrder = {

})
public class TokenType {

    @XmlElement(name = "Id")
    protected long id;
    @XmlElement(name = "UserId")
    protected long userId;
    @XmlElement(name = "Active")
    protected boolean active;
    @XmlElement(name = "DeactivityMaximumDurationInMinutes")
    protected int deactivityMaximumDurationInMinutes;
    @XmlElement(name = "ExpireDate")
    protected long expireDate;
    @XmlElement(name = "LastAccessDate")
    protected long lastAccessDate;
    @XmlElement(name = "SubmitDate")
    protected long submitDate;
    @XmlElement(name = "Value", required = true)
    protected String value;
    @XmlElement(name = "Description", required = true)
    protected String description;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(long value) {
        this.userId = value;
    }

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the deactivityMaximumDurationInMinutes property.
     * 
     */
    public int getDeactivityMaximumDurationInMinutes() {
        return deactivityMaximumDurationInMinutes;
    }

    /**
     * Sets the value of the deactivityMaximumDurationInMinutes property.
     * 
     */
    public void setDeactivityMaximumDurationInMinutes(int value) {
        this.deactivityMaximumDurationInMinutes = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     */
    public long getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     */
    public void setExpireDate(long value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the lastAccessDate property.
     * 
     */
    public long getLastAccessDate() {
        return lastAccessDate;
    }

    /**
     * Sets the value of the lastAccessDate property.
     * 
     */
    public void setLastAccessDate(long value) {
        this.lastAccessDate = value;
    }

    /**
     * Gets the value of the submitDate property.
     * 
     */
    public long getSubmitDate() {
        return submitDate;
    }

    /**
     * Sets the value of the submitDate property.
     * 
     */
    public void setSubmitDate(long value) {
        this.submitDate = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
