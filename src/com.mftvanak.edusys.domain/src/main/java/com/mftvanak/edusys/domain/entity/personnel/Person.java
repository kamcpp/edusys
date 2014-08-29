package com.mftvanak.edusys.domain.entity.personnel;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import com.mftvanak.edusys.domain.DomainConstants;


@Entity
@Table (name = "person", schema = "personnel")
public class Person {

  public enum GenderType {
    NotClear (0),
    Male (1),
    Female (2),
    Others (3);

    private int code;

    private GenderType (int code) {
      this.code = code;
    }

    public int getCode () {
      return code;
    }
  }

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "birth_date", nullable = true)
  private long birthDate;
  @Enumerated (EnumType.ORDINAL)
  @Column (name = "gender", nullable = false)
  private GenderType gender;
  @Column (name = "persian_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String persianName;
  @Column (name = "english_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String englishName;
  @Column (name = "persian_family", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String persianFamily;
  @Column (name = "english_family", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String englishFamily;
  @Column (name = "father_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String fatherName;
  @Column (name = "national_code", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String nationalCode;
  @Column (name = "sh_sh", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String shSh;
  @Column (name = "sh_location", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String shLocation;
  @Column (name = "phone1", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String phone1;
  @Column (name = "phone2", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String phone2;
  @Column (name = "phone3", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String phone3;
  @Column (name = "email1", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String email1;
  @Column (name = "email2", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String email2;
  @Column (name = "web_url1", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String webUrl1;
  @Column (name = "web_url2", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String webUrl2;
  @Column (name = "address1", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String address1;
  @Column (name = "address2", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String address2;
  @Column (name = "description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String description;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public long getBirthDate () {
    return birthDate;
  }

  public void setBirthDate (long birthDate) {
    this.birthDate = birthDate;
  }

  public GenderType getGender () {
    return gender;
  }

  public void setGender (GenderType gender) {
    this.gender = gender;
  }

  public String getPersianName () {
    return persianName;
  }

  public void setPersianName (String persianName) {
    this.persianName = persianName;
  }

  public String getEnglishName () {
    return englishName;
  }

  public void setEnglishName (String englishName) {
    this.englishName = englishName;
  }

  public String getPersianFamily () {
    return persianFamily;
  }

  public void setPersianFamily (String persianFamily) {
    this.persianFamily = persianFamily;
  }

  public String getEnglishFamily () {
    return englishFamily;
  }

  public void setEnglishFamily (String englishFamily) {
    this.englishFamily = englishFamily;
  }

  public String getFatherName () {
    return fatherName;
  }

  public void setFatherName (String fatherName) {
    this.fatherName = fatherName;
  }

  public String getNationalCode () {
    return nationalCode;
  }

  public void setNationalCode (String nationalCode) {
    this.nationalCode = nationalCode;
  }

  public String getShSh () {
    return shSh;
  }

  public void setShSh (String shSh) {
    this.shSh = shSh;
  }

  public String getShLocation () {
    return shLocation;
  }

  public void setShLocation (String shLocation) {
    this.shLocation = shLocation;
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

  public String getPhone3 () {
    return phone3;
  }

  public void setPhone3 (String phone3) {
    this.phone3 = phone3;
  }

  public String getEmail1 () {
    return email1;
  }

  public void setEmail1 (String email1) {
    this.email1 = email1;
  }

  public String getEmail2 () {
    return email2;
  }

  public void setEmail2 (String email2) {
    this.email2 = email2;
  }

  public String getWebUrl1 () {
    return webUrl1;
  }

  public void setWebUrl1 (String webUrl1) {
    this.webUrl1 = webUrl1;
  }

  public String getWebUrl2 () {
    return webUrl2;
  }

  public void setWebUrl2 (String webUrl2) {
    this.webUrl2 = webUrl2;
  }

  public String getAddress1 () {
    return address1;
  }

  public void setAddress1 (String address1) {
    this.address1 = address1;
  }

  public String getAddress2 () {
    return address2;
  }

  public void setAddress2 (String address2) {
    this.address2 = address2;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }
}
