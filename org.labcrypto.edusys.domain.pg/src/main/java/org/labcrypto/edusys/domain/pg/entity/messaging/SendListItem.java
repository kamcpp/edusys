package org.labcrypto.edusys.domain.pg.entity.messaging;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.labcrypto.edusys.domain.pg.DomainConstants;
import org.labcrypto.edusys.domain.pg.entity.personnel.Person;


@Entity
@Table (name = "sendlist", schema = "messaging")
public class SendListItem {

  public enum SendListItemType {
    Sms (1),
    Email (2);

    private int code;

    SendListItemType (int code) {
      this.code = code;
    }

    public int getCode () {
      return code;
    }
  }

  public enum SendListItemStatusType {
    New (1),
    Retry (2),
    Sent (3),
    Failed (4),
    Cancelled (5);

    private int code;

    SendListItemStatusType (int code) {
      this.code = code;
    }

    public int getCode () {
      return code;
    }
  }

  public enum SendListItemDeliveryType {
    NotSentYet (1),
    NotDelivered (2),
    DeliveredSuccessfully (3),
    FailedToDeliver (4);

    private int code;

    SendListItemDeliveryType (int code) {
      this.code = code;
    }

    public int getCode () {
      return code;
    }
  }

  public enum SendListItemContentType {
    PlainText (1),
    Html (2);

    private int code;

    SendListItemContentType (int code) {
      this.code = code;
    }

    public int getCode () {
      return code;
    }
  }

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "ref_id", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String refId;
  @Column (name = "type", nullable = false)
  private int type;
  @Column (name = "content_type", nullable = false)
  private int contentType;
  @Column (name = "status", nullable = false)
  private int status;
  @Column (name = "delivery", nullable = false)
  private int delivery;
  @Column (name = "number_of_tries", nullable = false)
  private int numberOfTries;
  @Column (name = "client_submit_date_time", nullable = false)
  private long clientSubmitDateTime;
  @Column (name = "server_submit_date_time", nullable = false)
  private long serverSubmitDateTime;
  @Column (name = "last_try_date_time", nullable = true)
  private Long lastTryDateTime;
  @Column (name = "`to`", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String to;
  @Column (name = "`from`", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String from;
  @Column (name = "subject", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String subject;
  @Column (name = "body", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String body;
  @Column (name = "description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String description;
  @Column (name = "retry_reason", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String retryReason;
  @Column (name = "cancellation_reason", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String cancellationReason;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "send_request_id", nullable = false)
  private SendRequest sendRequest;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "owner_person_id", nullable = false)
  private Person owner;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public String getRefId () {
    return refId;
  }

  public void setRefId (String refId) {
    this.refId = refId;
  }

  public int getType () {
    return type;
  }

  public void setType (int type) {
    this.type = type;
  }

  public int getContentType () {
    return contentType;
  }

  public void setContentType (int contentType) {
    this.contentType = contentType;
  }

  public int getStatus () {
    return status;
  }

  public void setStatus (int status) {
    this.status = status;
  }

  public int getDelivery () {
    return delivery;
  }

  public void setDelivery (int delivery) {
    this.delivery = delivery;
  }

  public int getNumberOfTries () {
    return numberOfTries;
  }

  public void setNumberOfTries (int numberOfTries) {
    this.numberOfTries = numberOfTries;
  }

  public long getClientSubmitDateTime () {
    return clientSubmitDateTime;
  }

  public void setClientSubmitDateTime (long clientSubmitDateTime) {
    this.clientSubmitDateTime = clientSubmitDateTime;
  }

  public long getServerSubmitDateTime () {
    return serverSubmitDateTime;
  }

  public void setServerSubmitDateTime (long serverSubmitDateTime) {
    this.serverSubmitDateTime = serverSubmitDateTime;
  }

  public Long getLastTryDateTime () {
    return lastTryDateTime;
  }

  public void setLastTryDateTime (Long lastTryDateTime) {
    this.lastTryDateTime = lastTryDateTime;
  }

  public String getTo () {
    return to;
  }

  public void setTo (String to) {
    this.to = to;
  }

  public String getFrom () {
    return from;
  }

  public void setFrom (String from) {
    this.from = from;
  }

  public String getSubject () {
    return subject;
  }

  public void setSubject (String subject) {
    this.subject = subject;
  }

  public String getBody () {
    return body;
  }

  public void setBody (String body) {
    this.body = body;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }

  public String getRetryReason () {
    return retryReason;
  }

  public void setRetryReason (String retryReason) {
    this.retryReason = retryReason;
  }

  public String getCancellationReason () {
    return cancellationReason;
  }

  public void setCancellationReason (String cancellationReason) {
    this.cancellationReason = cancellationReason;
  }

  public SendRequest getSendRequest () {
    return sendRequest;
  }

  public void setSendRequest (SendRequest sendRequest) {
    this.sendRequest = sendRequest;
  }

  public Person getOwner () {
    return owner;
  }

  public void setOwner (Person owner) {
    this.owner = owner;
  }
}
