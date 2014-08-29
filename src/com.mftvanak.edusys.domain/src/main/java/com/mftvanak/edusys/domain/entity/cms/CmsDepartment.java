package com.mftvanak.edusys.domain.entity.cms;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mftvanak.edusys.domain.DomainConstants;


@Entity
@Table (name = "department", schema = "cms")
public class CmsDepartment {

  @Id
  private Long Id;
  @Column (name = "name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String name;
  @OneToMany (fetch = FetchType.EAGER, mappedBy = "department")
  private Set < CmsGroup > groups;
  @OneToMany (fetch = FetchType.EAGER, mappedBy = "department")
  private Set < CmsReservation > reservations;

  public Long getId () {
    return Id;
  }

  public void setId (Long id) {
    Id = id;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public Set < CmsGroup > getGroups () {
    if (groups == null) {
      groups = new HashSet < CmsGroup > ();
    }
    return groups;
  }

  public void setGroups (Set < CmsGroup > groups) {
    this.groups = groups;
  }

  public Set < CmsReservation > getReservations () {
    if (reservations == null) {
      reservations = new HashSet < CmsReservation > ();
    }
    return reservations;
  }

  public void setReservations (Set < CmsReservation > reservations) {
    this.reservations = reservations;
  }
}
