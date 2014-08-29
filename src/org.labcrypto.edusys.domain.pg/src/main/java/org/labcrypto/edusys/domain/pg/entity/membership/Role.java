package org.labcrypto.edusys.domain.pg.entity.membership;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.labcrypto.edusys.domain.pg.DomainConstants;


@Entity
@Table (name = "role", schema = "membership")
public class Role {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String name;

  public Role () {
    name = "";
  }

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  @Override
  public int hashCode () {
    return name.hashCode ();
  }

  @Override
  public boolean equals (Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj instanceof Role) {
      Role role = (Role) obj;
      return role.getName ().equals (this.name);
    } else {
      return false;
    }
  }
}
