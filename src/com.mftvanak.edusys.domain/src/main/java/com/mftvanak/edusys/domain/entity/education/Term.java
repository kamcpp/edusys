package com.mftvanak.edusys.domain.entity.education;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mftvanak.edusys.domain.DomainConstants;


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
