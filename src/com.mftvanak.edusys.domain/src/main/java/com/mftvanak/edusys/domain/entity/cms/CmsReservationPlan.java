package com.mftvanak.edusys.domain.entity.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mftvanak.edusys.domain.DomainConstants;


@Entity
@Table (name = "reservation_plan", schema = "cms")
public class CmsReservationPlan {

  @Id
  private long id;
  @Column (name = "name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String name;

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
}
