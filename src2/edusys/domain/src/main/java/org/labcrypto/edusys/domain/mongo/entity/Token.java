package org.labcrypto.edusys.domain.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Token {

	@Id
	private ObjectId id;
	private boolean active;
	private long submitDate;
	private long lastAccessDate;
	private Long expireDate;
	private Long deactivityMaximumDurationInMinutes;
	private String value;
	private String description;
	@DBRef
	private User user;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(long submitDate) {
		this.submitDate = submitDate;
	}

	public long getLastAccessDate() {
		return lastAccessDate;
	}

	public void setLastAccessDate(long lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	public Long getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Long expireDate) {
		this.expireDate = expireDate;
	}

	public Long getDeactivityMaximumDurationInMinutes() {
		return deactivityMaximumDurationInMinutes;
	}

	public void setDeactivityMaximumDurationInMinutes(
			Long deactivityMaximumDurationInMinutes) {
		this.deactivityMaximumDurationInMinutes = deactivityMaximumDurationInMinutes;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
