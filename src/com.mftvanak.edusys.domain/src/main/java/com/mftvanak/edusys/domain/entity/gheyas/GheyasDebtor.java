package com.mftvanak.edusys.domain.entity.gheyas;

public class GheyasDebtor {

  private int instituteId;
  private String code;
  private String name;
  private String family;
  private String phone1;
  private String phone2;
  private String email;
  private String address;
  private String shouldPay;
  private String paid;
  private String discount;
  private String debt;

  public int getInstituteId () {
    return instituteId;
  }

  public void setInstituteId (int instituteId) {
    this.instituteId = instituteId;
  }

  public String getCode () {
    return code;
  }

  public void setCode (String code) {
    this.code = code;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getFamily () {
    return family;
  }

  public void setFamily (String family) {
    this.family = family;
  }

  public String getPhone1 () {
    return phone1;
  }

  public void setPhone1 (String phone1) {
    this.phone1 = phone1;
  }

  public String getPhone2 () {
    return phone2;
  }

  public void setPhone2 (String phone2) {
    this.phone2 = phone2;
  }

  public String getEmail () {
    return email;
  }

  public void setEmail (String email) {
    this.email = email;
  }

  public String getAddress () {
    return address;
  }

  public void setAddress (String address) {
    this.address = address;
  }

  public String getShouldPay () {
    return shouldPay;
  }

  public void setShouldPay (String shouldPay) {
    this.shouldPay = shouldPay;
  }

  public String getPaid () {
    return paid;
  }

  public void setPaid (String paid) {
    this.paid = paid;
  }

  public String getDiscount () {
    return discount;
  }

  public void setDiscount (String discount) {
    this.discount = discount;
  }

  public String getDebt () {
    return debt;
  }

  public void setDebt (String debt) {
    this.debt = debt;
  }
}
