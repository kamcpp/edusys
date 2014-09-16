package org.labcrypto.edusys.domain.mongo.entity;

import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tag {

	@Id
	private ObjectId id;
	private String englishName;
	private String persianName;
	private Tag parent;
	private Set<Tag> children;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getPersianName() {
		return persianName;
	}

	public void setPersianName(String persianName) {
		this.persianName = persianName;
	}

	public Tag getParent() {
		return parent;
	}

	public void setParent(Tag parent) {
		this.parent = parent;
	}

	public Set<Tag> getChildren() {
		return children;
	}

	public void setChildren(Set<Tag> children) {
		this.children = children;
	}
}
