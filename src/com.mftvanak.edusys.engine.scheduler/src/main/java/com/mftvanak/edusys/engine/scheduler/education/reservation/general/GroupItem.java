package com.mftvanak.edusys.engine.scheduler.education.reservation.general;

import java.util.ArrayList;
import java.util.List;

public class GroupItem {

	private long id;
	private String name;
	private List<ClassItem> classes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ClassItem> getClasses() {
		if (classes == null) {
			classes = new ArrayList<ClassItem>();
		}
		return classes;
	}

	@Override
	public int hashCode() {
		return (int)id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj instanceof GroupItem) {
			GroupItem groupItem = (GroupItem) obj;
			return this.id == groupItem.getId();
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "G(Id: '" + id + "', Name: '" + name + "')";
	}
}
