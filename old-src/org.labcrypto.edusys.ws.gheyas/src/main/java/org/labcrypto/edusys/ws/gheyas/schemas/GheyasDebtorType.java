//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2014.09.03 à 03:11:33 PM IRDT 
//


package org.labcrypto.edusys.ws.gheyas.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour GheyasDebtorType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="GheyasDebtorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Family" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Phone1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Phone2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShouldPay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Paid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Discount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Debt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GheyasDebtorType", propOrder = {
    "code",
    "name",
    "family",
    "phone1",
    "phone2",
    "email",
    "address",
    "shouldPay",
    "paid",
    "discount",
    "debt"
})
public class GheyasDebtorType {

    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Family", required = true)
    protected String family;
    @XmlElement(name = "Phone1", required = true)
    protected String phone1;
    @XmlElement(name = "Phone2", required = true)
    protected String phone2;
    @XmlElement(name = "Email", required = true)
    protected String email;
    @XmlElement(name = "Address", required = true)
    protected String address;
    @XmlElement(name = "ShouldPay", required = true)
    protected String shouldPay;
    @XmlElement(name = "Paid", required = true)
    protected String paid;
    @XmlElement(name = "Discount", required = true)
    protected String discount;
    @XmlElement(name = "Debt", required = true)
    protected String debt;

    /**
     * Obtient la valeur de la propriété code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Définit la valeur de la propriété code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Obtient la valeur de la propriété name.
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
     * Définit la valeur de la propriété name.
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
     * Obtient la valeur de la propriété family.
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
     * Définit la valeur de la propriété family.
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
     * Obtient la valeur de la propriété phone1.
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
     * Définit la valeur de la propriété phone1.
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
     * Obtient la valeur de la propriété phone2.
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
     * Définit la valeur de la propriété phone2.
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
     * Obtient la valeur de la propriété email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit la valeur de la propriété email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtient la valeur de la propriété address.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Définit la valeur de la propriété address.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Obtient la valeur de la propriété shouldPay.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShouldPay() {
        return shouldPay;
    }

    /**
     * Définit la valeur de la propriété shouldPay.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShouldPay(String value) {
        this.shouldPay = value;
    }

    /**
     * Obtient la valeur de la propriété paid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaid() {
        return paid;
    }

    /**
     * Définit la valeur de la propriété paid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaid(String value) {
        this.paid = value;
    }

    /**
     * Obtient la valeur de la propriété discount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Définit la valeur de la propriété discount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscount(String value) {
        this.discount = value;
    }

    /**
     * Obtient la valeur de la propriété debt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebt() {
        return debt;
    }

    /**
     * Définit la valeur de la propriété debt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebt(String value) {
        this.debt = value;
    }

}
