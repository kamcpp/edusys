package com.mftvanak.edusys.domain.entity.education;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;

import com.mftvanak.edusys.domain.DomainConstants;


@Entity
@Table (name = "department", schema = "education")
public class Department {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "persian_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String persianName;
  @Column (name = "english_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String englishName;
  @Column (name = "color", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String color;
  @Column (name = "show_order", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private int showOrder;
  @Column (name = "seo_keywords", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String seoKeywords;
  @Column (name = "seo_description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String seoDescription;
  @Column (name = "htmlContent", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String htmlContent;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "institute_id", nullable = false)
  private Institute institute;
  @OneToMany (fetch = FetchType.EAGER, mappedBy = "department")
  private List < Group > groups;

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

  public String getColor () {
    return color;
  }

  public void setColor (String color) {
    this.color = color;
  }

  public int getShowOrder () {
    return showOrder;
  }

  public void setShowOrder (int showOrder) {
    this.showOrder = showOrder;
  }

  public String getSeoKeywords () {
    return seoKeywords;
  }

  public void setSeoKeywords (String seoKeywords) {
    this.seoKeywords = seoKeywords;
  }

  public String getSeoDescription () {
    return seoDescription;
  }

  public void setSeoDescription (String seoDescription) {
    this.seoDescription = seoDescription;
  }

  public String getHtmlContent () {
    return htmlContent;
  }

  public void setHtmlContent (String htmlContent) {
    this.htmlContent = htmlContent;
  }

  public Institute getInstitute () {
    return institute;
  }

  public void setInstitute (Institute institute) {
    this.institute = institute;
  }

  public List < Group > getGroups () {
    if (groups == null) {
      groups = new ArrayList < Group > ();
    }
    return groups;
  }

  public void setGroups (List < Group > groups) {
    this.groups = groups;
  }

  @Override
  public int hashCode () {
    if (this.getId () == null) {
      return 0;
    }
    return this.getId ().hashCode ();
  }

  @Override
  public boolean equals (Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj instanceof Department) {
      Department department = (Department) obj;
      return this.getId () == department.getId ();
    } else {
      return false;
    }
  }
}
