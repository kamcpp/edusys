package org.labcrypto.edusys.domain.jpa.dao.phonebook;

import org.labcrypto.edusys.domain.jpa.entity.ColorType;

import java.util.ArrayList;
import java.util.List;


public class PhoneEntrySearchPredicate {

  private Long departmentId;
  private Long ownerId;
  private Long submitDateStart;
  private Long submitDateEnd;
  private String name;
  private String number;
  private String description;
  private List < String > followUpTypes;
  private List < ColorType > colors;
  private List < Integer > methodesDeConnaissance;

  public Long getDepartmentId () {
    return departmentId;
  }

  public void setDepartmentId (Long departmentId) {
    this.departmentId = departmentId;
  }

  public Long getOwnerId () {
    return ownerId;
  }

  public void setOwnerId (Long ownerId) {
    this.ownerId = ownerId;
  }

  public Long getSubmitDateStart () {
    return submitDateStart;
  }

  public void setSubmitDateStart (Long submitDateStart) {
    this.submitDateStart = submitDateStart;
  }

  public Long getSubmitDateEnd () {
    return submitDateEnd;
  }

  public void setSubmitDateEnd (Long submitDateEnd) {
    this.submitDateEnd = submitDateEnd;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getNumber () {
    return number;
  }

  public void setNumber (String number) {
    this.number = number;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }

  public List < String > getFollowUpTypes () {
    if (followUpTypes == null) {
      followUpTypes = new ArrayList < String > ();
    }
    return followUpTypes;
  }

  public void setFollowUpTypes (List < String > followUpTypes) {
    this.followUpTypes = followUpTypes;
  }

  public List < ColorType > getColors () {
    if (colors == null) {
      colors = new ArrayList < ColorType > ();
    }
    return colors;
  }

  public void setColors (List < ColorType > colors) {
    this.colors = colors;
  }

  public List < Integer > getMethodesDeConnaissance () {
    if (methodesDeConnaissance == null) {
      methodesDeConnaissance = new ArrayList < Integer > ();
    }
    return methodesDeConnaissance;
  }

  public void setMethodesDeConnaissance (List < Integer > methodesDeConnaissance) {
    this.methodesDeConnaissance = methodesDeConnaissance;
  }
}
