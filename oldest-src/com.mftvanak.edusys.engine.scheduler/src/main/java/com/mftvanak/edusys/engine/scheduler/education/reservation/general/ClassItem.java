package com.mftvanak.edusys.engine.scheduler.education.reservation.general;

import java.util.ArrayList;
import java.util.List;


public class ClassItem {

  private long id;
  private String name;
  private List < GeneralReservationItem > generalReservationItems;

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

  public List < GeneralReservationItem > getGeneralReservationItems () {
    if (generalReservationItems == null) {
      generalReservationItems = new ArrayList < GeneralReservationItem > ();
    }
    return generalReservationItems;
  }

  public void setGeneralReservationItems (List < GeneralReservationItem > generalReservationItems) {
    this.generalReservationItems = generalReservationItems;
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
    if (obj instanceof ClassItem) {
      ClassItem classItem = (ClassItem) obj;
      return this.id == classItem.getId ();
    } else {
      return false;
    }
  }

  @Override
  public String toString () {
    return "C(Id: '" + id + "', Name: '" + name + "')";
  }
}
