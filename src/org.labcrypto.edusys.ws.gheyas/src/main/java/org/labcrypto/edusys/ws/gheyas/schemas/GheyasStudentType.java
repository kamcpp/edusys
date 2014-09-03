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
 * <p>Classe Java pour GheyasStudentType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="GheyasStudentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KaramuzCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TarafHesabCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Family" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EmergencyPhone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Paid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Payment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Reshteh" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Daneshgah" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClassCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClassName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GheyasStudentType", propOrder = {
    "karamuzCode",
    "tarafHesabCode",
    "name",
    "family",
    "birthDate",
    "address",
    "phone",
    "emergencyPhone",
    "email",
    "paid",
    "payment",
    "paymentDate",
    "paymentDiscount",
    "description",
    "reshteh",
    "daneshgah",
    "classCode",
    "className",
    "state"
})
public class GheyasStudentType {

    @XmlElement(name = "KaramuzCode", required = true)
    protected String karamuzCode;
    @XmlElement(name = "TarafHesabCode", required = true)
    protected String tarafHesabCode;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Family", required = true)
    protected String family;
    @XmlElement(name = "BirthDate", required = true)
    protected String birthDate;
    @XmlElement(name = "Address", required = true)
    protected String address;
    @XmlElement(name = "Phone", required = true)
    protected String phone;
    @XmlElement(name = "EmergencyPhone", required = true)
    protected String emergencyPhone;
    @XmlElement(name = "Email", required = true)
    protected String email;
    @XmlElement(name = "Paid", required = true)
    protected String paid;
    @XmlElement(name = "Payment", required = true)
    protected String payment;
    @XmlElement(name = "PaymentDate", required = true)
    protected String paymentDate;
    @XmlElement(name = "PaymentDiscount", required = true)
    protected String paymentDiscount;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Reshteh", required = true)
    protected String reshteh;
    @XmlElement(name = "Daneshgah", required = true)
    protected String daneshgah;
    @XmlElement(name = "ClassCode", required = true)
    protected String classCode;
    @XmlElement(name = "ClassName", required = true)
    protected String className;
    @XmlElement(name = "State", required = true)
    protected String state;

    /**
     * Obtient la valeur de la propriété karamuzCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKaramuzCode() {
        return karamuzCode;
    }

    /**
     * Définit la valeur de la propriété karamuzCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKaramuzCode(String value) {
        this.karamuzCode = value;
    }

    /**
     * Obtient la valeur de la propriété tarafHesabCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarafHesabCode() {
        return tarafHesabCode;
    }

    /**
     * Définit la valeur de la propriété tarafHesabCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarafHesabCode(String value) {
        this.tarafHesabCode = value;
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
     * Obtient la valeur de la propriété birthDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Définit la valeur de la propriété birthDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(String value) {
        this.birthDate = value;
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
     * Obtient la valeur de la propriété phone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Définit la valeur de la propriété phone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Obtient la valeur de la propriété emergencyPhone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    /**
     * Définit la valeur de la propriété emergencyPhone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergencyPhone(String value) {
        this.emergencyPhone = value;
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
     * Obtient la valeur de la propriété payment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayment() {
        return payment;
    }

    /**
     * Définit la valeur de la propriété payment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayment(String value) {
        this.payment = value;
    }

    /**
     * Obtient la valeur de la propriété paymentDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * Définit la valeur de la propriété paymentDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDate(String value) {
        this.paymentDate = value;
    }

    /**
     * Obtient la valeur de la propriété paymentDiscount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDiscount() {
        return paymentDiscount;
    }

    /**
     * Définit la valeur de la propriété paymentDiscount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDiscount(String value) {
        this.paymentDiscount = value;
    }

    /**
     * Obtient la valeur de la propriété description.
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
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété reshteh.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReshteh() {
        return reshteh;
    }

    /**
     * Définit la valeur de la propriété reshteh.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReshteh(String value) {
        this.reshteh = value;
    }

    /**
     * Obtient la valeur de la propriété daneshgah.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDaneshgah() {
        return daneshgah;
    }

    /**
     * Définit la valeur de la propriété daneshgah.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDaneshgah(String value) {
        this.daneshgah = value;
    }

    /**
     * Obtient la valeur de la propriété classCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * Définit la valeur de la propriété classCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassCode(String value) {
        this.classCode = value;
    }

    /**
     * Obtient la valeur de la propriété className.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Définit la valeur de la propriété className.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * Obtient la valeur de la propriété state.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Définit la valeur de la propriété state.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

}
