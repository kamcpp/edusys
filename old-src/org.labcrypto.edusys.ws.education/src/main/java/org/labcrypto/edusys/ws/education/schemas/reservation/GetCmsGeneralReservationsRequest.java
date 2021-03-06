//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2013.10.12 at 01:52:53 AM IRST
//

package org.labcrypto.edusys.ws.education.schemas.reservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
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
 *         &lt;element name="DepartmentId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="GroupId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ClassId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Count" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType (XmlAccessType.FIELD)
@XmlType (name = "", propOrder = {"clientDateTimeYear", "clientDateTimeMonth", "clientDateTimeDay",
    "clientDateTimeHour", "clientDateTimeMinute", "clientDateTimeSecond", "clientDateTimeMilliSecond",
    "clientMacAddress", "clientIpAddress", "clientComputerName", "applicationName", "token", "departmentId", "groupId",
    "classId", "count"})
@XmlRootElement (name = "GetCmsGeneralReservationsRequest")
public class GetCmsGeneralReservationsRequest {

  @XmlElement (name = "ClientDateTimeYear")
  protected int clientDateTimeYear;
  @XmlElement (name = "ClientDateTimeMonth")
  protected int clientDateTimeMonth;
  @XmlElement (name = "ClientDateTimeDay")
  protected int clientDateTimeDay;
  @XmlElement (name = "ClientDateTimeHour")
  protected int clientDateTimeHour;
  @XmlElement (name = "ClientDateTimeMinute")
  protected int clientDateTimeMinute;
  @XmlElement (name = "ClientDateTimeSecond")
  protected int clientDateTimeSecond;
  @XmlElement (name = "ClientDateTimeMilliSecond")
  protected int clientDateTimeMilliSecond;
  @XmlElement (name = "ClientMacAddress", required = true)
  protected String clientMacAddress;
  @XmlElement (name = "ClientIpAddress", required = true)
  protected String clientIpAddress;
  @XmlElement (name = "ClientComputerName", required = true)
  protected String clientComputerName;
  @XmlElement (name = "ApplicationName", required = true)
  protected String applicationName;
  @XmlElement (name = "Token", required = true)
  protected String token;
  @XmlElement (name = "DepartmentId")
  protected long departmentId;
  @XmlElement (name = "GroupId", required = true, type = Long.class, nillable = true)
  protected Long groupId;
  @XmlElement (name = "ClassId", required = true, type = Long.class, nillable = true)
  protected Long classId;
  @XmlElement (name = "Count", required = true, type = Integer.class, nillable = true)
  protected Integer count;

  /**
   * Gets the value of the clientDateTimeYear property.
   * 
   */
  public int getClientDateTimeYear () {
    return clientDateTimeYear;
  }

  /**
   * Sets the value of the clientDateTimeYear property.
   * 
   */
  public void setClientDateTimeYear (int value) {
    this.clientDateTimeYear = value;
  }

  /**
   * Gets the value of the clientDateTimeMonth property.
   * 
   */
  public int getClientDateTimeMonth () {
    return clientDateTimeMonth;
  }

  /**
   * Sets the value of the clientDateTimeMonth property.
   * 
   */
  public void setClientDateTimeMonth (int value) {
    this.clientDateTimeMonth = value;
  }

  /**
   * Gets the value of the clientDateTimeDay property.
   * 
   */
  public int getClientDateTimeDay () {
    return clientDateTimeDay;
  }

  /**
   * Sets the value of the clientDateTimeDay property.
   * 
   */
  public void setClientDateTimeDay (int value) {
    this.clientDateTimeDay = value;
  }

  /**
   * Gets the value of the clientDateTimeHour property.
   * 
   */
  public int getClientDateTimeHour () {
    return clientDateTimeHour;
  }

  /**
   * Sets the value of the clientDateTimeHour property.
   * 
   */
  public void setClientDateTimeHour (int value) {
    this.clientDateTimeHour = value;
  }

  /**
   * Gets the value of the clientDateTimeMinute property.
   * 
   */
  public int getClientDateTimeMinute () {
    return clientDateTimeMinute;
  }

  /**
   * Sets the value of the clientDateTimeMinute property.
   * 
   */
  public void setClientDateTimeMinute (int value) {
    this.clientDateTimeMinute = value;
  }

  /**
   * Gets the value of the clientDateTimeSecond property.
   * 
   */
  public int getClientDateTimeSecond () {
    return clientDateTimeSecond;
  }

  /**
   * Sets the value of the clientDateTimeSecond property.
   * 
   */
  public void setClientDateTimeSecond (int value) {
    this.clientDateTimeSecond = value;
  }

  /**
   * Gets the value of the clientDateTimeMilliSecond property.
   * 
   */
  public int getClientDateTimeMilliSecond () {
    return clientDateTimeMilliSecond;
  }

  /**
   * Sets the value of the clientDateTimeMilliSecond property.
   * 
   */
  public void setClientDateTimeMilliSecond (int value) {
    this.clientDateTimeMilliSecond = value;
  }

  /**
   * Gets the value of the clientMacAddress property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getClientMacAddress () {
    return clientMacAddress;
  }

  /**
   * Sets the value of the clientMacAddress property.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setClientMacAddress (String value) {
    this.clientMacAddress = value;
  }

  /**
   * Gets the value of the clientIpAddress property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getClientIpAddress () {
    return clientIpAddress;
  }

  /**
   * Sets the value of the clientIpAddress property.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setClientIpAddress (String value) {
    this.clientIpAddress = value;
  }

  /**
   * Gets the value of the clientComputerName property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getClientComputerName () {
    return clientComputerName;
  }

  /**
   * Sets the value of the clientComputerName property.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setClientComputerName (String value) {
    this.clientComputerName = value;
  }

  /**
   * Gets the value of the applicationName property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getApplicationName () {
    return applicationName;
  }

  /**
   * Sets the value of the applicationName property.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setApplicationName (String value) {
    this.applicationName = value;
  }

  /**
   * Gets the value of the token property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getToken () {
    return token;
  }

  /**
   * Sets the value of the token property.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setToken (String value) {
    this.token = value;
  }

  /**
   * Gets the value of the departmentId property.
   * 
   */
  public long getDepartmentId () {
    return departmentId;
  }

  /**
   * Sets the value of the departmentId property.
   * 
   */
  public void setDepartmentId (long value) {
    this.departmentId = value;
  }

  /**
   * Gets the value of the groupId property.
   * 
   * @return possible object is {@link Long }
   * 
   */
  public Long getGroupId () {
    return groupId;
  }

  /**
   * Sets the value of the groupId property.
   * 
   * @param value
   *          allowed object is {@link Long }
   * 
   */
  public void setGroupId (Long value) {
    this.groupId = value;
  }

  /**
   * Gets the value of the classId property.
   * 
   * @return possible object is {@link Long }
   * 
   */
  public Long getClassId () {
    return classId;
  }

  /**
   * Sets the value of the classId property.
   * 
   * @param value
   *          allowed object is {@link Long }
   * 
   */
  public void setClassId (Long value) {
    this.classId = value;
  }

  /**
   * Gets the value of the count property.
   * 
   * @return possible object is {@link Integer }
   * 
   */
  public Integer getCount () {
    return count;
  }

  /**
   * Sets the value of the count property.
   * 
   * @param value
   *          allowed object is {@link Integer }
   * 
   */
  public void setCount (Integer value) {
    this.count = value;
  }

}
