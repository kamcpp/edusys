package org.labcrypto.edusys.domain.pg.entity.cms;

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

import org.labcrypto.edusys.domain.pg.DomainConstants;


@Entity
@Table (name = "group", schema = "cms")
public class CmsGroup {

  @Id
  private Long Id;
  @Column (name = "name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String name;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "cms_department_id", nullable = false)
  private CmsDepartment department;
  @OneToMany (fetch = FetchType.EAGER, mappedBy = "group")
  private Set < CmsClass > classes;

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

  public CmsDepartment getDepartment () {
    return department;
  }

  public void setDepartment (CmsDepartment department) {
    this.department = department;
  }

  public Set < CmsClass > getClasses () {
    if (classes == null) {
      classes = new HashSet < CmsClass > ();
    }
    return classes;
  }

  public void setClasses (Set < CmsClass > classes) {
    this.classes = classes;
  }
}
