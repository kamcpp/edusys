package com.mftvanak.edusys.domain.entity.messaging;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mftvanak.edusys.domain.DomainConstants;
import com.mftvanak.edusys.domain.entity.ColorType;
import com.mftvanak.edusys.domain.entity.personnel.Person;


@Entity
@Table (name = "todo_item", schema = "messaging")
public class TodoItem {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "done", nullable = false)
  private boolean done;
  @Enumerated (EnumType.STRING)
  @Column (name = "color", nullable = true)
  private ColorType color;
  @Enumerated (EnumType.STRING)
  @Column (name = "priority", nullable = false)
  private int priority;
  @Column (name = "submit_date", nullable = false)
  private long submitDateTime;
  @Column (name = "deadline_date", nullable = true)
  private Long deadlineDateTime;
  @Column (name = "subject", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String subject;
  @Column (name = "response", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String response;
  @Column (name = "description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String description;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "owner_person_id", nullable = false)
  private Person owner;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "receiver_person_id", nullable = false)
  private Person receiver;
  @OneToMany (mappedBy = "todoItem")
  private List < TodoItemAttachement > attachements;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public boolean isDone () {
    return done;
  }

  public void setDone (boolean done) {
    this.done = done;
  }

  public ColorType getColor () {
    return color;
  }

  public void setColor (ColorType color) {
    this.color = color;
  }

  public int getPriority () {
    return priority;
  }

  public void setPriority (int priority) {
    this.priority = priority;
  }

  public long getSubmitDateTime () {
    return submitDateTime;
  }

  public void setSubmitDateTime (long submitDateTime) {
    this.submitDateTime = submitDateTime;
  }

  public Long getDeadlineDateTime () {
    return deadlineDateTime;
  }

  public void setDeadlineDateTime (Long deadlineDateTime) {
    this.deadlineDateTime = deadlineDateTime;
  }

  public String getSubject () {
    return subject;
  }

  public void setSubject (String subject) {
    this.subject = subject;
  }

  public String getResponse () {
    return response;
  }

  public void setResponse (String response) {
    this.response = response;
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

  public Person getReceiver () {
    return receiver;
  }

  public void setReceiver (Person receiver) {
    this.receiver = receiver;
  }

  public List < TodoItemAttachement > getAttachements () {
    return attachements;
  }

  public void setAttachements (List < TodoItemAttachement > attachements) {
    this.attachements = attachements;
  }
}
