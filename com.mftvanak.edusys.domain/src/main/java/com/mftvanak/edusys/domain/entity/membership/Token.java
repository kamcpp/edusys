package com.mftvanak.edusys.domain.entity.membership;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

import com.mftvanak.edusys.domain.DomainConstants;


@Entity
@Table (name = "token", schema = "membership")
public class Token {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "active", nullable = false)
  private boolean active;
  @Column (name = "submit_date", nullable = false)
  private long submitDate;
  @Column (name = "last_access_date", nullable = false)
  private long lastAccessDate;
  @Column (name = "expire_date", nullable = false)
  private Long expireDate;
  @Column (name = "deactivity_maximum_duration_in_minutes", nullable = false)
  private Long deactivityMaximumDurationInMinutes;
  @Column (name = "value", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String value;
  @Column (name = "description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String description;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "user_id", nullable = false)
  private User user;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public boolean isActive () {
    return active;
  }

  public void setActive (boolean active) {
    this.active = active;
  }

  public long getSubmitDate () {
    return submitDate;
  }

  public void setSubmitDate (long submitDate) {
    this.submitDate = submitDate;
  }

  public long getLastAccessDate () {
    return lastAccessDate;
  }

  public void setLastAccessDate (long lastAccessDate) {
    this.lastAccessDate = lastAccessDate;
  }

  public Long getExpireDate () {
    return expireDate;
  }

  public void setExpireDate (Long expireDate) {
    this.expireDate = expireDate;
  }

  public Long getDeactivityMaximumDurationInMinutes () {
    return deactivityMaximumDurationInMinutes;
  }

  public void setDeactivityMaximumDurationInMinutes (Long deactivityMaximumDurationInMinutes) {
    this.deactivityMaximumDurationInMinutes = deactivityMaximumDurationInMinutes;
  }

  public String getValue () {
    return value;
  }

  public void setValue (String value) {
    this.value = value;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }

  public User getUser () {
    return user;
  }

  public void setUser (User user) {
    this.user = user;
  }
}
