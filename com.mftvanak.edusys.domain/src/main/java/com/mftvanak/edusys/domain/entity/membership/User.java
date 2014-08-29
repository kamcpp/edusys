package com.mftvanak.edusys.domain.entity.membership;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mftvanak.edusys.domain.DomainConstants;
import com.mftvanak.edusys.domain.entity.personnel.Person;


@Entity
@Table (name = "user", schema = "membership")
public class User {

  @Id
  @GenericGenerator (name = "generator", strategy = "foreign", parameters = @Parameter (name = "property", value = "person"))
  @GeneratedValue (generator = "generator")
  @Column (name = "person_id", unique = true, nullable = false)
  private Long personId;
  @Column (name = "username", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false, unique = true)
  private String username;
  @Column (name = "accountEmail", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false, unique = true)
  private String accountEmail;
  @Column (name = "hashed_password", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String hashedPassword;
  @Column (name = "active", nullable = false)
  private boolean active;
  @OneToOne (fetch = FetchType.EAGER)
  @PrimaryKeyJoinColumn
  private Person person;
  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable (name = "user_role", schema = "membership", joinColumns = {@JoinColumn (name = "user_id", nullable = false)}, inverseJoinColumns = {@JoinColumn (name = "role_id", nullable = false)})
  private Set < Role > roles;

  public Long getPersonId () {
    return personId;
  }

  public void setPersonId (Long personId) {
    this.personId = personId;
  }

  public String getUsername () {
    return username;
  }

  public void setUsername (String username) {
    this.username = username;
  }

  public String getAccountEmail () {
    return accountEmail;
  }

  public void setAccountEmail (String accountEmail) {
    this.accountEmail = accountEmail;
  }

  public String getHashedPassword () {
    return hashedPassword;
  }

  public void setHashedPassword (String hashedPassword) {
    this.hashedPassword = hashedPassword;
  }

  public boolean isActive () {
    return active;
  }

  public void setActive (boolean active) {
    this.active = active;
  }

  public Set < Role > getRoles () {
    if (roles == null) {
      roles = new HashSet < Role > ();
    }
    return roles;
  }

  public void setRoles (Set < Role > roles) {
    this.roles = roles;
  }

  public Person getPerson () {
    return person;
  }

  public void setPerson (Person person) {
    this.person = person;
  }
}
