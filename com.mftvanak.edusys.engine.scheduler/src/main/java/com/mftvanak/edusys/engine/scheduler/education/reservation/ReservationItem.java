package com.mftvanak.edusys.engine.scheduler.education.reservation;

public class ReservationItem {

  private long id;
  private long planId;
  private String name;
  private String phone;
  private String email;
  private String text;
  private String date;
  private String time;

  public long getId () {
    return id;
  }

  public void setId (long id) {
    this.id = id;
  }

  public long getPlanId () {
    return planId;
  }

  public void setPlanId (long planId) {
    this.planId = planId;
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

  public String getTime () {
    return time;
  }

  public void setTime (String time) {
    this.time = time;
  }

  @Override
  public String toString () {
    return "R(Id: '" + id + "', PlanId: '" + planId + "', Name: '" + name + "', Phone: '" + phone + "', Email: '" + email + "', Text: '" + text
        + "', Date: '" + date + "', Time: '" + time + "')";
  }
}
