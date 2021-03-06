package org.labcrypto.edusys.domain.jpa.entity.education;

import org.labcrypto.edusys.domain.jpa.DomainConstants;
import org.labcrypto.edusys.domain.jpa.entity.personnel.Person;

import javax.persistence.*;


@Entity
@Table(name = "student", schema = "education")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "person_id", unique = true, nullable = false)
    private Long personId;
    @Column(name = "student_number", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
    private String studentNumber;
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Person person;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
