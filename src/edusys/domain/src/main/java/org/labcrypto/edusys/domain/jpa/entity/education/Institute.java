package org.labcrypto.edusys.domain.jpa.entity.education;

import org.labcrypto.edusys.domain.jpa.DomainConstants;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name = "institute", schema = "education")
public class Institute {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "persian_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String persianName;
  @Column (name = "english_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String englishName;
  @Column (name = "phone1", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String phone1;
  @Column (name = "phone2", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String phone2;
  @Column (name = "fax_number", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String faxNumber;
  @Column (name = "web_url1", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String webUrl1;
  @Column (name = "web_url2", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String webUrl2;
  @Column (name = "email1", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String email1;
  @Column (name = "email2", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String email2;
  @OneToMany (fetch = FetchType.EAGER, mappedBy = "institute")
  private Set < Department > departments;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
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

  public String getFaxNumber () {
    return faxNumber;
  }

  public void setFaxNumber (String faxNumber) {
    this.faxNumber = faxNumber;
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

  public Set < Department > getDepartments () {
    return departments;
  }

  public void setDepartments (Set < Department > departments) {
    this.departments = departments;
  }
}
