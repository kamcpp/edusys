//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.05 at 01:36:40 PM IRST 
//


package com.mftvanak.edusys.ws.authentication.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PersianFullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EnglishFullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AccountEmail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Phone1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Phone2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Phone3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Email1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Email2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Token" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;sequence>
 *           &lt;element name="Roles" type="{http://authentication.ws.edusys.mftvanak.com/schemas}RoleType" maxOccurs="unbounded"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userId",
    "username",
    "persianFullName",
    "englishFullName",
    "accountEmail",
    "phone1",
    "phone2",
    "phone3",
    "email1",
    "email2",
    "token",
    "roles"
})
@XmlRootElement(name = "AuthenticationResponse")
public class AuthenticationResponse {

    @XmlElement(name = "UserId")
    protected long userId;
    @XmlElement(name = "Username", required = true)
    protected String username;
    @XmlElement(name = "PersianFullName", required = true)
    protected String persianFullName;
    @XmlElement(name = "EnglishFullName", required = true)
    protected String englishFullName;
    @XmlElement(name = "AccountEmail", required = true)
    protected String accountEmail;
    @XmlElement(name = "Phone1", required = true)
    protected String phone1;
    @XmlElement(name = "Phone2", required = true)
    protected String phone2;
    @XmlElement(name = "Phone3", required = true)
    protected String phone3;
    @XmlElement(name = "Email1", required = true)
    protected String email1;
    @XmlElement(name = "Email2", required = true)
    protected String email2;
    @XmlElement(name = "Token", required = true)
    protected String token;
    @XmlElement(name = "Roles", required = true)
    protected List<RoleType> roles;

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
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the persianFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersianFullName() {
        return persianFullName;
    }

    /**
     * Sets the value of the persianFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersianFullName(String value) {
        this.persianFullName = value;
    }

    /**
     * Gets the value of the englishFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishFullName() {
        return englishFullName;
    }

    /**
     * Sets the value of the englishFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishFullName(String value) {
        this.englishFullName = value;
    }

    /**
     * Gets the value of the accountEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountEmail() {
        return accountEmail;
    }

    /**
     * Sets the value of the accountEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountEmail(String value) {
        this.accountEmail = value;
    }

    /**
     * Gets the value of the phone1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     * Sets the value of the phone1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone1(String value) {
        this.phone1 = value;
    }

    /**
     * Gets the value of the phone2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * Sets the value of the phone2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone2(String value) {
        this.phone2 = value;
    }

    /**
     * Gets the value of the phone3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone3() {
        return phone3;
    }

    /**
     * Sets the value of the phone3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone3(String value) {
        this.phone3 = value;
    }

    /**
     * Gets the value of the email1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail1() {
        return email1;
    }

    /**
     * Sets the value of the email1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail1(String value) {
        this.email1 = value;
    }

    /**
     * Gets the value of the email2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail2() {
        return email2;
    }

    /**
     * Sets the value of the email2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail2(String value) {
        this.email2 = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the roles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoleType }
     * 
     * 
     */
    public List<RoleType> getRoles() {
        if (roles == null) {
            roles = new ArrayList<RoleType>();
        }
        return this.roles;
    }

}
