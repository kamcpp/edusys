package org.labcrypto.edusys.domain.pg.entity.education;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.labcrypto.edusys.domain.pg.DomainConstants;
import org.labcrypto.edusys.domain.pg.entity.accounting.Discount;


@Entity
@Table (name = "course_plan", schema = "education")
public class CoursePlan {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "days_not_clear", nullable = false)
  private boolean daysNotClear;
  @Column (name = "on_saturdays", nullable = false)
  private boolean onSaturdays;
  @Column (name = "on_sundays", nullable = false)
  private boolean onSundays;
  @Column (name = "on_mondays", nullable = false)
  private boolean onMondays;
  @Column (name = "on_tuesdays", nullable = false)
  private boolean onTuesdays;
  @Column (name = "on_wednesdays", nullable = false)
  private boolean onWednesdays;
  @Column (name = "on_thursdays", nullable = false)
  private boolean onThursdays;
  @Column (name = "on_fridays", nullable = false)
  private boolean onFridays;
  @Column (name = "times_not_clear", nullable = false)
  private boolean timesNotClear;
  @Column (name = "start_hour_on_staurdays", nullable = false)
  private int startHourOnSaturdays;
  @Column (name = "end_hour_on_staurdays", nullable = false)
  private int endHourOnSaturdays;
  @Column (name = "start_hour_on_sundays", nullable = false)
  private int startHourOnSundays;
  @Column (name = "end_hour_on_sundays", nullable = false)
  private int endHourOnSundays;
  @Column (name = "start_hour_on_mondays", nullable = false)
  private int startHourOnMondays;
  @Column (name = "end_hour_on_mondays", nullable = false)
  private int endHourOnMondays;
  @Column (name = "start_hour_on_tuesdays", nullable = false)
  private int startHourOnTuesdays;
  @Column (name = "end_hour_on_tuesdays", nullable = false)
  private int endHourOnTuesdays;
  @Column (name = "start_hour_on_wednesdays", nullable = false)
  private int startHourOnWednesdays;
  @Column (name = "end_hour_on_wednesdays", nullable = false)
  private int endHourOnWednesdays;
  @Column (name = "start_hour_on_thursdays", nullable = false)
  private int startHourOnThursdays;
  @Column (name = "end_hour_on_thursdays", nullable = false)
  private int endHourOnThursdays;
  @Column (name = "start_hour_on_fridays", nullable = false)
  private int startHourOnFridays;
  @Column (name = "end_hour_on_fridays", nullable = false)
  private int endHourOnFridays;
  @Column (name = "place_not_clear", nullable = true)
  private Boolean placeNotClear;
  @Column (name = "place", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String place;
  @Column (name = "price_not_clear", nullable = true)
  private Boolean priceNotClear;
  @Column (name = "price", nullable = false)
  private int price;
  @Column (name = "show_order", nullable = false)
  private int showOrder;
  @Column (name = "maximum_registers", nullable = true)
  private Integer maximumRegisters;
  @Column (name = "status", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = true)
  private String status;
  @Column (name = "description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String description;
  @Column (name = "teachers_text", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String teachersText;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "course_id", nullable = false)
  private Course course;
  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable (name = "course_plan__teacher", schema = "education", joinColumns = {@JoinColumn (name = "course_plan_id", nullable = false)}, inverseJoinColumns = {@JoinColumn (name = "teacher_id", nullable = false)})
  private Set < Teacher > teachers;
  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable (name = "course_plan__discount", schema = "education", joinColumns = {@JoinColumn (name = "course_plan_id", nullable = false)}, inverseJoinColumns = {@JoinColumn (name = "discount_id", nullable = false)})
  private Set < Discount > discounts;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public boolean isDaysNotClear () {
    return daysNotClear;
  }

  public void setDaysNotClear (boolean daysNotClear) {
    this.daysNotClear = daysNotClear;
  }

  public boolean isOnSaturdays () {
    return onSaturdays;
  }

  public void setOnSaturdays (boolean onSaturdays) {
    this.onSaturdays = onSaturdays;
  }

  public boolean isOnSundays () {
    return onSundays;
  }

  public void setOnSundays (boolean onSundays) {
    this.onSundays = onSundays;
  }

  public boolean isOnMondays () {
    return onMondays;
  }

  public void setOnMondays (boolean onMondays) {
    this.onMondays = onMondays;
  }

  public boolean isOnTuesdays () {
    return onTuesdays;
  }

  public void setOnTuesdays (boolean onTuesdays) {
    this.onTuesdays = onTuesdays;
  }

  public boolean isOnWednesdays () {
    return onWednesdays;
  }

  public void setOnWednesdays (boolean onWednesdays) {
    this.onWednesdays = onWednesdays;
  }

  public boolean isOnThursdays () {
    return onThursdays;
  }

  public void setOnThursdays (boolean onThursdays) {
    this.onThursdays = onThursdays;
  }

  public boolean isOnFridays () {
    return onFridays;
  }

  public void setOnFridays (boolean onFridays) {
    this.onFridays = onFridays;
  }

  public boolean isTimesNotClear () {
    return timesNotClear;
  }

  public void setTimesNotClear (boolean timesNotClear) {
    this.timesNotClear = timesNotClear;
  }

  public int getStartHourOnSaturdays () {
    return startHourOnSaturdays;
  }

  public void setStartHourOnSaturdays (int startHourOnSaturdays) {
    this.startHourOnSaturdays = startHourOnSaturdays;
  }

  public int getEndHourOnSaturdays () {
    return endHourOnSaturdays;
  }

  public void setEndHourOnSaturdays (int endHourOnSaturdays) {
    this.endHourOnSaturdays = endHourOnSaturdays;
  }

  public int getStartHourOnSundays () {
    return startHourOnSundays;
  }

  public void setStartHourOnSundays (int startHourOnSundays) {
    this.startHourOnSundays = startHourOnSundays;
  }

  public int getEndHourOnSundays () {
    return endHourOnSundays;
  }

  public void setEndHourOnSundays (int endHourOnSundays) {
    this.endHourOnSundays = endHourOnSundays;
  }

  public int getStartHourOnMondays () {
    return startHourOnMondays;
  }

  public void setStartHourOnMondays (int startHourOnMondays) {
    this.startHourOnMondays = startHourOnMondays;
  }

  public int getEndHourOnMondays () {
    return endHourOnMondays;
  }

  public void setEndHourOnMondays (int endHourOnMondays) {
    this.endHourOnMondays = endHourOnMondays;
  }

  public int getStartHourOnTuesdays () {
    return startHourOnTuesdays;
  }

  public void setStartHourOnTuesdays (int startHourOnTuesdays) {
    this.startHourOnTuesdays = startHourOnTuesdays;
  }

  public int getEndHourOnTuesdays () {
    return endHourOnTuesdays;
  }

  public void setEndHourOnTuesdays (int endHourOnTuesdays) {
    this.endHourOnTuesdays = endHourOnTuesdays;
  }

  public int getStartHourOnWednesdays () {
    return startHourOnWednesdays;
  }

  public void setStartHourOnWednesdays (int startHourOnWednesdays) {
    this.startHourOnWednesdays = startHourOnWednesdays;
  }

  public int getEndHourOnWednesdays () {
    return endHourOnWednesdays;
  }

  public void setEndHourOnWednesdays (int endHourOnWednesdays) {
    this.endHourOnWednesdays = endHourOnWednesdays;
  }

  public int getStartHourOnThursdays () {
    return startHourOnThursdays;
  }

  public void setStartHourOnThursdays (int startHourOnThursdays) {
    this.startHourOnThursdays = startHourOnThursdays;
  }

  public int getEndHourOnThursdays () {
    return endHourOnThursdays;
  }

  public void setEndHourOnThursdays (int endHourOnThursdays) {
    this.endHourOnThursdays = endHourOnThursdays;
  }

  public int getStartHourOnFridays () {
    return startHourOnFridays;
  }

  public void setStartHourOnFridays (int startHourOnFridays) {
    this.startHourOnFridays = startHourOnFridays;
  }

  public int getEndHourOnFridays () {
    return endHourOnFridays;
  }

  public void setEndHourOnFridays (int endHourOnFridays) {
    this.endHourOnFridays = endHourOnFridays;
  }

  public Boolean getPlaceNotClear () {
    return placeNotClear;
  }

  public void setPlaceNotClear (Boolean placeNotClear) {
    this.placeNotClear = placeNotClear;
  }

  public String getPlace () {
    return place;
  }

  public void setPlace (String place) {
    this.place = place;
  }

  public Boolean getPriceNotClear () {
    return priceNotClear;
  }

  public void setPriceNotClear (Boolean priceNotClear) {
    this.priceNotClear = priceNotClear;
  }

  public int getPrice () {
    return price;
  }

  public void setPrice (int price) {
    this.price = price;
  }

  public int getShowOrder () {
    return showOrder;
  }

  public void setShowOrder (int showOrder) {
    this.showOrder = showOrder;
  }

  public Integer getMaximumRegisters () {
    return maximumRegisters;
  }

  public void setMaximumRegisters (Integer maximumRegisters) {
    this.maximumRegisters = maximumRegisters;
  }

  public String getStatus () {
    return status;
  }

  public void setStatus (String status) {
    this.status = status;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }

  public String getTeachersText () {
    return teachersText;
  }

  public void setTeachersText (String teachersText) {
    this.teachersText = teachersText;
  }

  public Course getCourse () {
    return course;
  }

  public void setCourse (Course course) {
    this.course = course;
  }

  public Set < Teacher > getTeachers () {
    return teachers;
  }

  public void setTeachers (Set < Teacher > teachers) {
    this.teachers = teachers;
  }

  public Set < Discount > getDiscounts () {
    return discounts;
  }

  public void setDiscounts (Set < Discount > discounts) {
    this.discounts = discounts;
  }
}
