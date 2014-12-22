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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClientDateTimeYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ClientDateTimeMonth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ClientDateTimeDay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ClientDateTimeHour" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ClientDateTimeMinute" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ClientDateTimeSecond" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ClientDateTimeMilliSecond" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ClientMacAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClientIpAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClientComputerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ApplicationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Token" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InstituteId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ClassCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "clientDateTimeYear",
    "clientDateTimeMonth",
    "clientDateTimeDay",
    "clientDateTimeHour",
    "clientDateTimeMinute",
    "clientDateTimeSecond",
    "clientDateTimeMilliSecond",
    "clientMacAddress",
    "clientIpAddress",
    "clientComputerName",
    "applicationName",
    "token",
    "instituteId",
    "classCode"
})
@XmlRootElement(name = "GetStudentsRequest")
public class GetStudentsRequest {

    @XmlElement(name = "ClientDateTimeYear")
    protected int clientDateTimeYear;
    @XmlElement(name = "ClientDateTimeMonth")
    protected int clientDateTimeMonth;
    @XmlElement(name = "ClientDateTimeDay")
    protected int clientDateTimeDay;
    @XmlElement(name = "ClientDateTimeHour")
    protected int clientDateTimeHour;
    @XmlElement(name = "ClientDateTimeMinute")
    protected int clientDateTimeMinute;
    @XmlElement(name = "ClientDateTimeSecond")
    protected int clientDateTimeSecond;
    @XmlElement(name = "ClientDateTimeMilliSecond")
    protected int clientDateTimeMilliSecond;
    @XmlElement(name = "ClientMacAddress", required = true)
    protected String clientMacAddress;
    @XmlElement(name = "ClientIpAddress", required = true)
    protected String clientIpAddress;
    @XmlElement(name = "ClientComputerName", required = true)
    protected String clientComputerName;
    @XmlElement(name = "ApplicationName", required = true)
    protected String applicationName;
    @XmlElement(name = "Token", required = true)
    protected String token;
    @XmlElement(name = "InstituteId")
    protected int instituteId;
    @XmlElement(name = "ClassCode", required = true)
    protected String classCode;

    /**
     * Obtient la valeur de la propriété clientDateTimeYear.
     * 
     */
    public int getClientDateTimeYear() {
        return clientDateTimeYear;
    }

    /**
     * Définit la valeur de la propriété clientDateTimeYear.
     * 
     */
    public void setClientDateTimeYear(int value) {
        this.clientDateTimeYear = value;
    }

    /**
     * Obtient la valeur de la propriété clientDateTimeMonth.
     * 
     */
    public int getClientDateTimeMonth() {
        return clientDateTimeMonth;
    }

    /**
     * Définit la valeur de la propriété clientDateTimeMonth.
     * 
     */
    public void setClientDateTimeMonth(int value) {
        this.clientDateTimeMonth = value;
    }

    /**
     * Obtient la valeur de la propriété clientDateTimeDay.
     * 
     */
    public int getClientDateTimeDay() {
        return clientDateTimeDay;
    }

    /**
     * Définit la valeur de la propriété clientDateTimeDay.
     * 
     */
    public void setClientDateTimeDay(int value) {
        this.clientDateTimeDay = value;
    }

    /**
     * Obtient la valeur de la propriété clientDateTimeHour.
     * 
     */
    public int getClientDateTimeHour() {
        return clientDateTimeHour;
    }

    /**
     * Définit la valeur de la propriété clientDateTimeHour.
     * 
     */
    public void setClientDateTimeHour(int value) {
        this.clientDateTimeHour = value;
    }

    /**
     * Obtient la valeur de la propriété clientDateTimeMinute.
     * 
     */
    public int getClientDateTimeMinute() {
        return clientDateTimeMinute;
    }

    /**
     * Définit la valeur de la propriété clientDateTimeMinute.
     * 
     */
    public void setClientDateTimeMinute(int value) {
        this.clientDateTimeMinute = value;
    }

    /**
     * Obtient la valeur de la propriété clientDateTimeSecond.
     * 
     */
    public int getClientDateTimeSecond() {
        return clientDateTimeSecond;
    }

    /**
     * Définit la valeur de la propriété clientDateTimeSecond.
     * 
     */
    public void setClientDateTimeSecond(int value) {
        this.clientDateTimeSecond = value;
    }

    /**
     * Obtient la valeur de la propriété clientDateTimeMilliSecond.
     * 
     */
    public int getClientDateTimeMilliSecond() {
        return clientDateTimeMilliSecond;
    }

    /**
     * Définit la valeur de la propriété clientDateTimeMilliSecond.
     * 
     */
    public void setClientDateTimeMilliSecond(int value) {
        this.clientDateTimeMilliSecond = value;
    }

    /**
     * Obtient la valeur de la propriété clientMacAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientMacAddress() {
        return clientMacAddress;
    }

    /**
     * Définit la valeur de la propriété clientMacAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientMacAddress(String value) {
        this.clientMacAddress = value;
    }

    /**
     * Obtient la valeur de la propriété clientIpAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientIpAddress() {
        return clientIpAddress;
    }

    /**
     * Définit la valeur de la propriété clientIpAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientIpAddress(String value) {
        this.clientIpAddress = value;
    }

    /**
     * Obtient la valeur de la propriété clientComputerName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientComputerName() {
        return clientComputerName;
    }

    /**
     * Définit la valeur de la propriété clientComputerName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientComputerName(String value) {
        this.clientComputerName = value;
    }

    /**
     * Obtient la valeur de la propriété applicationName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Définit la valeur de la propriété applicationName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationName(String value) {
        this.applicationName = value;
    }

    /**
     * Obtient la valeur de la propriété token.
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
     * Définit la valeur de la propriété token.
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
     * Obtient la valeur de la propriété instituteId.
     * 
     */
    public int getInstituteId() {
        return instituteId;
    }

    /**
     * Définit la valeur de la propriété instituteId.
     * 
     */
    public void setInstituteId(int value) {
        this.instituteId = value;
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

}
