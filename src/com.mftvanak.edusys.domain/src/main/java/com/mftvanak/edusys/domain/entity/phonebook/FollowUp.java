package com.mftvanak.edusys.domain.entity.phonebook;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mftvanak.edusys.domain.DomainConstants;
import com.mftvanak.edusys.domain.entity.ColorType;
import com.mftvanak.edusys.domain.entity.official.Employee;


@Entity
@Table (name = "follow_up", schema = "phonebook")
public class FollowUp {

  public enum StatusType {
    New,
    Called,
    Finished
  }

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "answered", nullable = false)
  private boolean answered;
  @Column (name = "phone_number_is_not_active", nullable = false)
  private boolean phoneNumberIsNotActive;
  @Enumerated (EnumType.STRING)
  @Column (name = "status", nullable = false)
  private StatusType status;
  @Enumerated (EnumType.STRING)
  @Column (name = "color", nullable = false)
  private ColorType color;
  @Column (name = "submit_date", nullable = false)
  private long submitDate;
  @Column (name = "question", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String question;
  @Column (name = "desired_courses", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String desiredCourses;
  @Column (name = "desired_times", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String desiredTimes;
  @Column (name = "description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String description;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "owner_id", nullable = false)
  private Employee owner;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "phone_entry_id", nullable = false)
  private PhoneEntry phoneEntry;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public StatusType getStatus () {
    return status;
  }

  public void setStatus (StatusType status) {
    this.status = status;
  }

  public ColorType getColor () {
    return color;
  }

  public void setColor (ColorType color) {
    this.color = color;
  }

  public long getSubmitDate () {
    return submitDate;
  }

  public void setSubmitDate (long submitDate) {
    this.submitDate = submitDate;
  }

  public String getQuestion () {
    return question;
  }

  public void setQuestion (String question) {
    this.question = question;
  }

  public String getDesiredCourses () {
    return desiredCourses;
  }

  public void setDesiredCourses (String desiredCourses) {
    this.desiredCourses = desiredCourses;
  }

  public String getDesiredTimes () {
    return desiredTimes;
  }

  public void setDesiredTimes (String desiredTimes) {
    this.desiredTimes = desiredTimes;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }

  public Employee getOwner () {
    return owner;
  }

  public void setOwner (Employee owner) {
    this.owner = owner;
  }

  public PhoneEntry getPhoneEntry () {
    return phoneEntry;
  }

  public void setPhoneEntry (PhoneEntry phoneEntry) {
    this.phoneEntry = phoneEntry;
  }
}
