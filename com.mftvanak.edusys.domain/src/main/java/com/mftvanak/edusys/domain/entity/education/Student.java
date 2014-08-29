package com.mftvanak.edusys.domain.entity.education;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mftvanak.edusys.domain.DomainConstants;
import com.mftvanak.edusys.domain.entity.personnel.Person;


@Entity
@Table (name = "student", schema = "education")
public class Student {

  @Id
  @GenericGenerator (name = "generator", strategy = "foreign", parameters = @Parameter (name = "property", value = "person"))
  @GeneratedValue (generator = "generator")
  @Column (name = "person_id", unique = true, nullable = false)
  private Long personId;
  @Column (name = "student_number", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String studentNumber;
  @OneToOne (fetch = FetchType.EAGER)
  @PrimaryKeyJoinColumn
  private Person person;

  public Long getPersonId () {
    return personId;
  }

  public void setPersonId (Long personId) {
    this.personId = personId;
  }

  public String getStudentNumber () {
    return studentNumber;
  }

  public void setStudentNumber (String studentNumber) {
    this.studentNumber = studentNumber;
  }

  public Person getPerson () {
    return person;
  }

  public void setPerson (Person person) {
    this.person = person;
  }
}
