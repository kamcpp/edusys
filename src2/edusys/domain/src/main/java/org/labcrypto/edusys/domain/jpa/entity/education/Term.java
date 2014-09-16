package org.labcrypto.edusys.domain.jpa.entity.education;

import org.labcrypto.edusys.domain.jpa.DomainConstants;

import javax.persistence.*;


@Entity
@Table (name = "term", schema = "education")
public class Term {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "persian_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String persianName;
  @Column (name = "english_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String englishName;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "institute_id", nullable = false)
  private Institute institute;
  
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
  
  public Institute getInstitute () {
    return institute;
  }
  
  public void setInstitute (Institute institute) {
    this.institute = institute;
  }
}
