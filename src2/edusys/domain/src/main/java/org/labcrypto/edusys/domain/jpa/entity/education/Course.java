package org.labcrypto.edusys.domain.jpa.entity.education;


import org.labcrypto.edusys.domain.jpa.DomainConstants;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name = "course", schema = "education")
public class Course {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "code", nullable = true)
  private Integer code;
  @Column (name = "duration", nullable = true)
  private Integer duration;
  @Column (name = "price", nullable = true)
  private Integer price;
  @Column (name = "english_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String englishName;
  @Column (name = "persian_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String persianName;
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
  @Column (name = "short_description", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String shortDescription;
  @Column (name = "full_description", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String fullDescription;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "group_id", nullable = false)
  private Group group;
  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable (name = "course_tags", schema = "education", joinColumns = {@JoinColumn (name = "course_id", nullable = false)}, inverseJoinColumns = {@JoinColumn (name = "tag_id", nullable = false)})
  private Set < Tag > tags;
  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable (name = "course__course_resource", schema = "education", joinColumns = {@JoinColumn (name = "course_id", nullable = false)}, inverseJoinColumns = {@JoinColumn (name = "course_resource_id", nullable = false)})
  private Set < CourseResource > resources;
  @OneToMany (mappedBy = "course")
  private Set < CourseSyllabus > syllabuses;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public Integer getCode () {
    return code;
  }

  public void setCode (Integer code) {
    this.code = code;
  }

  public Integer getDuration () {
    return duration;
  }

  public void setDuration (Integer duration) {
    this.duration = duration;
  }

  public Integer getPrice () {
    return price;
  }

  public void setPrice (Integer price) {
    this.price = price;
  }

  public Group getGroup () {
    return group;
  }

  public void setGroup (Group group) {
    this.group = group;
  }

  public String getEnglishName () {
    return englishName;
  }

  public void setEnglishName (String englishName) {
    this.englishName = englishName;
  }

  public String getPersianName () {
    return persianName;
  }

  public void setPersianName (String persianName) {
    this.persianName = persianName;
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

  public String getShortDescription () {
    return shortDescription;
  }

  public void setShortDescription (String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getFullDescription () {
    return fullDescription;
  }

  public void setFullDescription (String fullDescription) {
    this.fullDescription = fullDescription;
  }

  public Set < Tag > getTags () {
    return tags;
  }

  public void setTags (Set < Tag > tags) {
    this.tags = tags;
  }

  public Set < CourseResource > getResources () {
    return resources;
  }

  public void setResources (Set < CourseResource > resources) {
    this.resources = resources;
  }

  public Set < CourseSyllabus > getSyllabuses () {
    return syllabuses;
  }

  public void setSyllabuses (Set < CourseSyllabus > syllabuses) {
    this.syllabuses = syllabuses;
  }
}
