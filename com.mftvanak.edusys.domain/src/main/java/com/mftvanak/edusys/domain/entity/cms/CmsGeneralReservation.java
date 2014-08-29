package com.mftvanak.edusys.domain.entity.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mftvanak.edusys.domain.DomainConstants;


@Entity
@Table (name = "general_reservation", schema = "cms")
public class CmsGeneralReservation {

  @Id
  private Long id;
  @Column (name = "will_register", nullable = true)
  private boolean willRegister;
  @Column (name = "will_registered_with_conditions", nullable = true)
  private boolean willRegisterWithConditions;
  @Column (name = "cancelled", nullable = true)
  private boolean cancelled;
  @Column (name = "not_answered", nullable = true)
  private boolean notAnswered;
  @Column (name = "followed", nullable = true)
  private boolean followed;
  @Column (name = "will_inform_us", nullable = true)
  private boolean willInformUs;
  @Column (name = "has_registered", nullable = true)
  private boolean hasRegisered;
  @Column (name = "seen", nullable = false)
  private boolean seen;
  @Column (name = "called", nullable = false)
  private boolean called;
  @Column (name = "sms_sent", nullable = false)
  private boolean smsSent;
  @Column (name = "date", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String date;
  @Column (name = "calculated_date", nullable = true)
  private long calculatedDate;
  @Column (name = "name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String name;
  @Column (name = "phone", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String phone;
  @Column (name = "email", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String email;
  @Column (name = "text", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String text;
  @Column (name = "description", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String description;
  @Column (name = "source", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String source;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "cms_class_id", nullable = false)
  private CmsClass clazz;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public boolean isWillRegister () {
    return willRegister;
  }

  public void setWillRegister (boolean willRegister) {
    this.willRegister = willRegister;
  }

  public boolean isWillRegisterWithConditions () {
    return willRegisterWithConditions;
  }

  public void setWillRegisterWithConditions (boolean willRegisterWithConditions) {
    this.willRegisterWithConditions = willRegisterWithConditions;
  }

  public boolean isCancelled () {
    return cancelled;
  }

  public void setCancelled (boolean cancelled) {
    this.cancelled = cancelled;
  }

  public boolean isNotAnswered () {
    return notAnswered;
  }

  public void setNotAnswered (boolean notAnswered) {
    this.notAnswered = notAnswered;
  }

  public boolean isFollowed () {
    return followed;
  }

  public void setFollowed (boolean followed) {
    this.followed = followed;
  }

  public boolean isWillInformUs () {
    return willInformUs;
  }

  public void setWillInformUs (boolean willInformUs) {
    this.willInformUs = willInformUs;
  }

  public boolean isHasRegisered () {
    return hasRegisered;
  }

  public void setHasRegisered (boolean hasRegisered) {
    this.hasRegisered = hasRegisered;
  }

  public boolean isSeen () {
    return seen;
  }

  public void setSeen (boolean seen) {
    this.seen = seen;
  }

  public boolean isCalled () {
    return called;
  }

  public void setCalled (boolean called) {
    this.called = called;
  }

  public boolean isSmsSent () {
    return smsSent;
  }

  public void setSmsSent (boolean smsSent) {
    this.smsSent = smsSent;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }

  public String getDate () {
    return date;
  }

  public void setDate (String date) {
    this.date = date;
  }

  public long getCalculatedDate () {
    return calculatedDate;
  }

  public void setCalculatedDate (long calculatedDate) {
    this.calculatedDate = calculatedDate;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getPhone () {
    return phone;
  }

  public void setPhone (String phone) {
    this.phone = phone;
  }

  public String getEmail () {
    return email;
  }

  public void setEmail (String email) {
    this.email = email;
  }

  public String getText () {
    return text;
  }

  public void setText (String text) {
    this.text = text;
  }

  public CmsClass getClazz () {
    return clazz;
  }

  public void setClazz (CmsClass clazz) {
    this.clazz = clazz;
  }

  public String getSource () {
    return source;
  }

  public void setSource (String source) {
    this.source = source;
  }
}
