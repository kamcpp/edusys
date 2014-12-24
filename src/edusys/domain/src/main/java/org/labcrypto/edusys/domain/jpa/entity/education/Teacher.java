package org.labcrypto.edusys.domain.jpa.entity.education;

import org.labcrypto.edusys.domain.jpa.entity.personnel.Person;

import javax.persistence.*;


@Entity
@Table (name = "teacher", schema = "education")
public class Teacher {

  @Id
  @GeneratedValue
  @Column (name = "person_id", unique = true, nullable = false)
  private Long personId;
  @OneToOne (fetch = FetchType.EAGER)
  @PrimaryKeyJoinColumn
  private Person person;

  public Long getPersonId () {
    return personId;
  }

  public void setPersonId (Long personId) {
    this.personId = personId;
  }

  public Person getPerson () {
    return person;
  }

  public void setPerson (Person person) {
    this.person = person;
  }
}
