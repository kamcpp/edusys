package com.mftvanak.edusys.domain.entity.cms;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mftvanak.edusys.domain.DomainConstants;


@Entity
@Table (name = "class", schema = "cms")
public class CmsClass {

  @Id
  private Long Id;
  @Column (name = "name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String name;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "cms_group_id", nullable = false)
  private CmsGroup group;
  @OneToMany (fetch = FetchType.EAGER, mappedBy = "clazz")
  private Set < CmsGeneralReservation > generalReservations;

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

  public CmsGroup getGroup () {
    return group;
  }

  public void setGroup (CmsGroup group) {
    this.group = group;
  }

  public Set < CmsGeneralReservation > getGeneralReservations () {
    if (generalReservations == null) {
      generalReservations = new HashSet < CmsGeneralReservation > ();
    }
    return generalReservations;
  }

  public void setGeneralReservations (Set < CmsGeneralReservation > generalReservations) {
    this.generalReservations = generalReservations;
  }
}
