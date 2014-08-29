package com.mftvanak.edusys.domain.entity.messaging;

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
import com.mftvanak.edusys.domain.entity.personnel.Person;


@Entity
@Table (name = "message_template", schema = "messaging")
public class MessageTemplate {

  public enum MessageTemplateType {
    Sms (1),
    Email (2);

    private int code;

    MessageTemplateType (int code) {
      this.code = code;
    }

    public int getCode () {
      return code;
    }
  }

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "type", nullable = false)
  private int type;
  @Column (name = "submit_date_time", nullable = false)
  private long submitDateTime;
  @Column (name = "name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String name;
  @Column (name = "text", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = false)
  private String text;
  @Column (name = "description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String description;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "owner_person_id", nullable = false)
  private Person owner;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public int getType () {
    return type;
  }

  public void setType (int type) {
    this.type = type;
  }

  public long getSubmitDateTime () {
    return submitDateTime;
  }

  public void setSubmitDateTime (long submitDateTime) {
    this.submitDateTime = submitDateTime;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getText () {
    return text;
  }

  public void setText (String text) {
    this.text = text;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }

  public Person getOwner () {
    return owner;
  }

  public void setOwner (Person owner) {
    this.owner = owner;
  }
}
