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
 * <p>Classe Java pour GheyasClassType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="GheyasClassType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TeacherTarafHesabCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TeacherName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TeacherFamily" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TeacherPhone1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TeacherPhone2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TeacherEmail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ActiveDays" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NumberOfStudents" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GheyasClassType", propOrder = {
    "code",
    "name",
    "teacherTarafHesabCode",
    "teacherName",
    "teacherFamily",
    "teacherPhone1",
    "teacherPhone2",
    "teacherEmail",
    "description",
    "activeDays",
    "startDate",
    "endDate",
    "numberOfStudents"
})
public class GheyasClassType {

    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "TeacherTarafHesabCode", required = true)
    protected String teacherTarafHesabCode;
    @XmlElement(name = "TeacherName", required = true)
    protected String teacherName;
    @XmlElement(name = "TeacherFamily", required = true)
    protected String teacherFamily;
    @XmlElement(name = "TeacherPhone1", required = true)
    protected String teacherPhone1;
    @XmlElement(name = "TeacherPhone2", required = true)
    protected String teacherPhone2;
    @XmlElement(name = "TeacherEmail", required = true)
    protected String teacherEmail;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "ActiveDays", required = true)
    protected String activeDays;
    @XmlElement(name = "StartDate", required = true)
    protected String startDate;
    @XmlElement(name = "EndDate", required = true)
    protected String endDate;
    @XmlElement(name = "NumberOfStudents")
    protected int numberOfStudents;

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
     * Obtient la valeur de la propriété teacherTarafHesabCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeacherTarafHesabCode() {
        return teacherTarafHesabCode;
    }

    /**
     * Définit la valeur de la propriété teacherTarafHesabCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeacherTarafHesabCode(String value) {
        this.teacherTarafHesabCode = value;
    }

    /**
     * Obtient la valeur de la propriété teacherName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * Définit la valeur de la propriété teacherName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeacherName(String value) {
        this.teacherName = value;
    }

    /**
     * Obtient la valeur de la propriété teacherFamily.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeacherFamily() {
        return teacherFamily;
    }

    /**
     * Définit la valeur de la propriété teacherFamily.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeacherFamily(String value) {
        this.teacherFamily = value;
    }

    /**
     * Obtient la valeur de la propriété teacherPhone1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeacherPhone1() {
        return teacherPhone1;
    }

    /**
     * Définit la valeur de la propriété teacherPhone1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeacherPhone1(String value) {
        this.teacherPhone1 = value;
    }

    /**
     * Obtient la valeur de la propriété teacherPhone2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeacherPhone2() {
        return teacherPhone2;
    }

    /**
     * Définit la valeur de la propriété teacherPhone2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeacherPhone2(String value) {
        this.teacherPhone2 = value;
    }

    /**
     * Obtient la valeur de la propriété teacherEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeacherEmail() {
        return teacherEmail;
    }

    /**
     * Définit la valeur de la propriété teacherEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeacherEmail(String value) {
        this.teacherEmail = value;
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
     * Obtient la valeur de la propriété activeDays.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActiveDays() {
        return activeDays;
    }

    /**
     * Définit la valeur de la propriété activeDays.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActiveDays(String value) {
        this.activeDays = value;
    }

    /**
     * Obtient la valeur de la propriété startDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Définit la valeur de la propriété startDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Obtient la valeur de la propriété endDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Définit la valeur de la propriété endDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Obtient la valeur de la propriété numberOfStudents.
     * 
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * Définit la valeur de la propriété numberOfStudents.
     * 
     */
    public void setNumberOfStudents(int value) {
        this.numberOfStudents = value;
    }

}
