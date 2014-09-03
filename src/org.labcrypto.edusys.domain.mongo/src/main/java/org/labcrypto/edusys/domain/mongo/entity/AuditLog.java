package org.labcrypto.edusys.domain.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class AuditLog {
	@Id
	private ObjectId id;
	private long logDateTime;
	private long clientDateTime;
	private String operation;
	@DBRef
	private Token token;
	@DBRef
	private User user;
	private String username;
	private String clientMacAddress;
	private String clientIpAddress;
	private String clientComputerName;
	private String remoteAddress;
	private String localAddress;
	private String service;
	private String serviceVersion;
	private String application;
	private String details;
	private String description;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public long getLogDateTime() {
		return logDateTime;
	}

	public void setLogDateTime(long logDateTime) {
		this.logDateTime = logDateTime;
	}

	public long getClientDateTime() {
		return clientDateTime;
	}

	public void setClientDateTime(long clientDateTime) {
		this.clientDateTime = clientDateTime;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClientMacAddress() {
		return clientMacAddress;
	}

	public void setClientMacAddress(String clientMacAddress) {
		this.clientMacAddress = clientMacAddress;
	}

	public String getClientIpAddress() {
		return clientIpAddress;
	}

	public void setClientIpAddress(String clientIpAddress) {
		this.clientIpAddress = clientIpAddress;
	}

	public String getClientComputerName() {
		return clientComputerName;
	}

	public void setClientComputerName(String clientComputerName) {
		this.clientComputerName = clientComputerName;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
