package com.mftvanak.edusys.engine.scheduler.education.reservation;

import java.util.ArrayList;
import java.util.List;

import com.mftvanak.edusys.engine.scheduler.education.reservation.general.GroupItem;


public class DepartmentItem {

  private long id;
  private String name;
  private List < GroupItem > groups;
  private List < ReservationItem > reservations;

  public long getId () {
    return id;
  }

  public void setId (long id) {
    this.id = id;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public List < GroupItem > getGroups () {
    if (groups == null) {
      groups = new ArrayList < GroupItem > ();
    }
    return groups;
  }

  public List < ReservationItem > getReservations () {
    if (reservations == null) {
      reservations = new ArrayList < ReservationItem > ();
    }
    return reservations;
  }

  public void setReservations (List < ReservationItem > reservations) {
    this.reservations = reservations;
  }

  public void setGroups (List < GroupItem > groups) {
    this.groups = groups;
  }

  @Override
  public int hashCode () {
    return (int) id;
  }

  @Override
  public boolean equals (Object obj) {
    if (obj == null) {
      return false;
    }
    if (this == obj) {
      return true;
    }
    if (obj instanceof DepartmentItem) {
      DepartmentItem departmentItem = (DepartmentItem) obj;
      return this.id == departmentItem.getId ();
    } else {
      return false;
    }
  }

  @Override
  public String toString () {
    return "D(Id: '" + id + "', Name: '" + name + "')";
  }
}
