package org.labcrypto.edusys.domain.pg.entity.audit;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.labcrypto.edusys.domain.pg.DomainConstants;


@Entity
@Table (name = "audit_log", schema = "audit")
public class AuditLog {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Long id;
  @Column (name = "log_date_time", nullable = false)
  private long logDateTime;
  @Column (name = "client_date_time", nullable = true)
  private long clientDateTime;
  @Column (name = "operation", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String operation;
  @Column (name = "token_id", nullable = true)
  private Long tokenId;
  @Column (name = "person_id", nullable = true)
  private Long personId;
  @Column (name = "username", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String username;
  @Column (name = "client_mac_address", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String clientMacAddress;
  @Column (name = "client_ip_address", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String clientIpAddress;
  @Column (name = "client_computer_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String clientComputerName;
  @Column (name = "remote_address", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String remoteAddress;
  @Column (name = "local_address", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String localAddress;
  @Column (name = "service", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String service;
  @Column (name = "service_version", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String serviceVersion;
  @Column (name = "application", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String application;
  @Column (name = "details", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String details;
  @Column (name = "description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String description;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public long getLogDateTime () {
    return logDateTime;
  }

  public void setLogDateTime (long logDateTime) {
    this.logDateTime = logDateTime;
  }

  public long getClientDateTime () {
    return clientDateTime;
  }

  public void setClientDateTime (long clientDateTime) {
    this.clientDateTime = clientDateTime;
  }

  public String getOperation () {
    return operation;
  }

  public void setOperation (String operation) {
    this.operation = operation;
  }

  public Long getTokenId () {
    return tokenId;
  }

  public void setTokenId (Long tokenId) {
    this.tokenId = tokenId;
  }

  public Long getPersonId () {
    return personId;
  }

  public void setPersonId (Long personId) {
    this.personId = personId;
  }

  public String getUsername () {
    return username;
  }

  public void setUsername (String username) {
    this.username = username;
  }

  public String getClientMacAddress () {
    return clientMacAddress;
  }

  public void setClientMacAddress (String clientMacAddress) {
    this.clientMacAddress = clientMacAddress;
  }

  public String getClientIpAddress () {
    return clientIpAddress;
  }

  public void setClientIpAddress (String clientIpAddress) {
    this.clientIpAddress = clientIpAddress;
  }

  public String getClientComputerName () {
    return clientComputerName;
  }

  public void setClientComputerName (String clientComputerName) {
    this.clientComputerName = clientComputerName;
  }

  public String getRemoteAddress () {
    return remoteAddress;
  }

  public void setRemoteAddress (String remoteAddress) {
    this.remoteAddress = remoteAddress;
  }

  public String getLocalAddress () {
    return localAddress;
  }

  public void setLocalAddress (String localAddress) {
    this.localAddress = localAddress;
  }

  public String getService () {
    return service;
  }

  public void setService (String service) {
    this.service = service;
  }

  public String getServiceVersion () {
    return serviceVersion;
  }

  public void setServiceVersion (String serviceVersion) {
    this.serviceVersion = serviceVersion;
  }

  public String getApplication () {
    return application;
  }

  public void setApplication (String application) {
    this.application = application;
  }

  public String getDetails () {
    return details;
  }

  public void setDetails (String details) {
    this.details = details;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }
}
