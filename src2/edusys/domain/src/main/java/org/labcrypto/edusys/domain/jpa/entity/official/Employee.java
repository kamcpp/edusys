package org.labcrypto.edusys.domain.jpa.entity.official;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.labcrypto.edusys.domain.jpa.DomainConstants;
import org.labcrypto.edusys.domain.jpa.entity.personnel.Person;

import javax.persistence.*;


@Entity
@Table (name = "employee", schema = "official")
public class Employee {

  @Id
  @GenericGenerator (name = "generator", strategy = "foreign", parameters = @Parameter (name = "property", value = "person"))
  @GeneratedValue (generator = "generator")
  @Column (name = "person_id", unique = true, nullable = false)
  private Long personId;
  @Column (name = "employee_number", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String employeeNumber;
  @OneToOne (fetch = FetchType.EAGER)
  @PrimaryKeyJoinColumn
  private Person person;

  public Long getPersonId () {
    return personId;
  }

  public void setPersonId (Long personId) {
    this.personId = personId;
  }

  public String getEmployeeNumber () {
    return employeeNumber;
  }

  public void setEmployeeNumber (String employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public Person getPerson () {
    return person;
  }

  public void setPerson (Person person) {
    this.person = person;
  }
}
