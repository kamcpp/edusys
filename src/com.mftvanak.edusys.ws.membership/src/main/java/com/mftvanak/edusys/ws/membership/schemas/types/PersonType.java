//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.17 at 08:40:04 PM IRDT 
//


package com.mftvanak.edusys.ws.membership.schemas.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EnglishName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Family" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EnglishFamily" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FatherName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShSh" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShLocation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NationalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Gender" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Contacts" type="{http://membership.ws.edusys.mftvanak.com/schemas/types}ContactType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonType", propOrder = {
    "id",
    "name",
    "englishName",
    "family",
    "englishFamily",
    "fatherName",
    "shSh",
    "shLocation",
    "nationalCode",
    "dateOfBirth",
    "gender",
    "contacts"
})
public class PersonType {

    @XmlElement(name = "Id")
    protected long id;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "EnglishName", required = true)
    protected String englishName;
    @XmlElement(name = "Family", required = true)
    protected String family;
    @XmlElement(name = "EnglishFamily", required = true)
    protected String englishFamily;
    @XmlElement(name = "FatherName", required = true)
    protected String fatherName;
    @XmlElement(name = "ShSh", required = true)
    protected String shSh;
    @XmlElement(name = "ShLocation", required = true)
    protected String shLocation;
    @XmlElement(name = "NationalCode", required = true)
    protected String nationalCode;
    @XmlElement(name = "DateOfBirth")
    protected long dateOfBirth;
    @XmlElement(name = "Gender", required = true)
    protected String gender;
    @XmlElement(name = "Contacts", required = true)
    protected List<ContactType> contacts;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the englishName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * Sets the value of the englishName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishName(String value) {
        this.englishName = value;
    }

    /**
     * Gets the value of the family property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamily() {
        return family;
    }

    /**
     * Sets the value of the family property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamily(String value) {
        this.family = value;
    }

    /**
     * Gets the value of the englishFamily property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishFamily() {
        return englishFamily;
    }

    /**
     * Sets the value of the englishFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishFamily(String value) {
        this.englishFamily = value;
    }

    /**
     * Gets the value of the fatherName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * Sets the value of the fatherName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatherName(String value) {
        this.fatherName = value;
    }

    /**
     * Gets the value of the shSh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShSh() {
        return shSh;
    }

    /**
     * Sets the value of the shSh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShSh(String value) {
        this.shSh = value;
    }

    /**
     * Gets the value of the shLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShLocation() {
        return shLocation;
    }

    /**
     * Sets the value of the shLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShLocation(String value) {
        this.shLocation = value;
    }

    /**
     * Gets the value of the nationalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalCode() {
        return nationalCode;
    }

    /**
     * Sets the value of the nationalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalCode(String value) {
        this.nationalCode = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     */
    public long getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     */
    public void setDateOfBirth(long value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the contacts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contacts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContacts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactType }
     * 
     * 
     */
    public List<ContactType> getContacts() {
        if (contacts == null) {
            contacts = new ArrayList<ContactType>();
        }
        return this.contacts;
    }

}
