package com.mftvanak.edusys.engine.scheduler.education.reservation.general;

public class GeneralReservationItem {

  private long id;
  private String name;
  private String phone;
  private String email;
  private String text;
  private String date;
  private String source;

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

  public String getPhone () {
    return phone;
  }

  public void setPhone (String phone) {
    this.phone = phone;
  }

  public String getEmail () {
    return email;
  }

  public void setEmail (String email) {
    this.email = email;
  }

  public String getText () {
    return text;
  }

  public void setText (String text) {
    this.text = text;
  }

  public String getDate () {
    return date;
  }

  public void setDate (String date) {
    this.date = date;
  }

  public String getSource () {
    return source;
  }

  public void setSource (String source) {
    this.source = source;
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
    if (obj instanceof GeneralReservationItem) {
      GeneralReservationItem reserveItem = (GeneralReservationItem) obj;
      return this.id == reserveItem.getId ();
    } else {
      return false;
    }
  }

  @Override
  public String toString () {
    return "R(Id: '" + id + "', Name: '" + name + "', Phone: '" + phone + "', Email: '" + email + "', Text: '" + text + "', Date: '" + date + "')";
  }
}
