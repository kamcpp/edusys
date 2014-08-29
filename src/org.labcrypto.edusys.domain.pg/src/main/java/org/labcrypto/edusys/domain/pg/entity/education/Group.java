package org.labcrypto.edusys.domain.pg.entity.education;

import java.util.HashSet;
import java.util.Set;

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

import org.labcrypto.edusys.domain.pg.DomainConstants;


@Entity
@Table (name = "group", schema = "education")
public class Group {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "persian_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String persianName;
  @Column (name = "english_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String englishName;
  @Column (name = "show_order", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private int showOrder;
  @Column (name = "seo_keywords", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String seoKeywords;
  @Column (name = "seo_description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String seoDescription;
  @Column (name = "htmlContent", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String htmlContent;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "department_id", nullable = false)
  private Department department;
  @OneToMany (mappedBy = "group")
  private Set < Course > courses;

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

  public Department getDepartment () {
    return department;
  }

  public void setDepartment (Department department) {
    this.department = department;
  }

  public Set < Course > getCourses () {
    if (courses == null) {
      courses = new HashSet < Course > ();
    }
    return courses;
  }

  public void setCourses (Set < Course > courses) {
    this.courses = courses;
  }
}
