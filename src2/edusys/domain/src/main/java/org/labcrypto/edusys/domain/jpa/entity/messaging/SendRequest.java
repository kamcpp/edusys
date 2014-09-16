package org.labcrypto.edusys.domain.jpa.entity.messaging;

import org.labcrypto.edusys.domain.jpa.DomainConstants;
import org.labcrypto.edusys.domain.jpa.entity.personnel.Person;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name = "send_request", schema = "messaging")
public class SendRequest {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "submit_date_time", nullable = false)
  private long submitDateTime;
  @Column (name = "name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String name;
  @Column (name = "description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String description;
  @Column (name = "number_of_sendlist_items", nullable = false)
  private int numberOfSendListItems;
  @Column (name = "number_of_delivered_sendlist_items", nullable = false)
  private int numberOfDeliveredSendListItems;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "owner_person_id", nullable = false)
  private Person owner;
  @OneToMany (mappedBy = "sendRequest")
  private List < SendListItem > sendListItems;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
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

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }

  public int getNumberOfSendListItems () {
    return numberOfSendListItems;
  }

  public void setNumberOfSendListItems (int numberOfSendListItems) {
    this.numberOfSendListItems = numberOfSendListItems;
  }

  public int getNumberOfDeliveredSendListItems () {
    return numberOfDeliveredSendListItems;
  }

  public void setNumberOfDeliveredSendListItems (int numberOfDeliveredSendListItems) {
    this.numberOfDeliveredSendListItems = numberOfDeliveredSendListItems;
  }

  public Person getOwner () {
    return owner;
  }

  public void setOwner (Person owner) {
    this.owner = owner;
  }

  public List < SendListItem > getSendListItems () {
    return sendListItems;
  }

  public void setSendListItems (List < SendListItem > sendListItems) {
    this.sendListItems = sendListItems;
  }
}
