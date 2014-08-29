package org.labcrypto.edusys.domain.pg.entity.phonebook;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.labcrypto.edusys.domain.pg.DomainConstants;
import org.labcrypto.edusys.domain.pg.entity.ColorType;
import org.labcrypto.edusys.domain.pg.entity.education.Department;
import org.labcrypto.edusys.domain.pg.entity.official.Employee;


@Entity
@Table (name = "phone_entry", schema = "phonebook")
public class PhoneEntry {

  public enum TypeDeMethodDeConnaissance {
    Unknown (0),
    NotAsked (1),
    Email (2),
    NewsletterAdvertise (3),
    WebsiteBanners (4),
    GoogleSearch (5),
    Tracket (6),
    Friends (7),
    Professors (8),
    OtherInstitutes (9),
    Sms (10),
    Facebook (11),
    Twitter (12),
    Internet (13),
    Etc (14),
    OldStudent (15),
    IntroducedByOldStudent (16),
    Tableau (17),
    MetroAdvertisement (18),
    IntroducedBySaadatAbad (19),
    Fax (20),
    PeikeBartar (21),
    Billboard (22),
    InstituteWebsite (23),
    IntroducedByFriends (24),
    TakhfifanWebsite (25),
    AzadUniversity (26),
    University (27),
    NoAvaranDaneshWebsite (28);

    private int code;

    private TypeDeMethodDeConnaissance (int code) {
      this.code = code;
    }

    public int getCode () {
      return code;
    }

    public static TypeDeMethodDeConnaissance valueOf (int value) {
      TypeDeMethodDeConnaissance toReturn = Unknown;
      if (value == 0) {
        toReturn = Unknown;
      } else if (value == 1) {
        toReturn = NotAsked;
      } else if (value == 2) {
        toReturn = Email;
      } else if (value == 3) {
        toReturn = NewsletterAdvertise;
      } else if (value == 4) {
        toReturn = WebsiteBanners;
      } else if (value == 5) {
        toReturn = GoogleSearch;
      } else if (value == 6) {
        toReturn = Tracket;
      } else if (value == 7) {
        toReturn = Friends;
      } else if (value == 8) {
        toReturn = Professors;
      } else if (value == 9) {
        toReturn = OtherInstitutes;
      } else if (value == 10) {
        toReturn = Sms;
      } else if (value == 11) {
        toReturn = Facebook;
      } else if (value == 12) {
        toReturn = Twitter;
      } else if (value == 13) {
        toReturn = Internet;
      } else if (value == 14) {
        toReturn = Etc;
      } else if (value == 15) {
        toReturn = OldStudent;
      } else if (value == 16) {
        toReturn = IntroducedByOldStudent;
      } else if (value == 17) {
        toReturn = Tableau;
      } else if (value == 18) {
        toReturn = MetroAdvertisement;
      } else if (value == 19) {
        toReturn = IntroducedBySaadatAbad;
      } else if (value == 20) {
        toReturn = Fax;
      } else if (value == 21) {
        toReturn = PeikeBartar;
      } else if (value == 22) {
        toReturn = Billboard;
      } else if (value == 23) {
        toReturn = InstituteWebsite;
      } else if (value == 24) {
        toReturn = IntroducedByFriends;
      } else if (value == 25) {
        toReturn = TakhfifanWebsite;
      } else if (value == 26) {
        toReturn = AzadUniversity;
      } else if (value == 27) {
        toReturn = University;
      } else if (value == 28) {
        toReturn = NoAvaranDaneshWebsite;
      }
      return toReturn;
    }
  }

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "seen", nullable = false)
  private Boolean seen;
  @Column (name = "should_be_followed", nullable = true)
  private Boolean shouldBeFollowed;
  @Column (name = "registered", nullable = true)
  private Boolean registered;
  @Column (name = "private_class", nullable = true)
  private Boolean privateClass;
  @Column (name = "submit_date", nullable = true)
  private long submitDate;
  @Enumerated (EnumType.STRING)
  @Column (name = "color", nullable = true)
  private ColorType color;
  @Enumerated (EnumType.ORDINAL)
  @Column (name = "method_de_connaissance", nullable = true)
  private TypeDeMethodDeConnaissance methodDeConnaissance;
  @Column (name = "name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String name;
  @Column (name = "number", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String number;
  @Column (name = "description", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = false)
  private String description;
  @Column (name = "response", length = DomainConstants.STRING_COLUMN_LONG_LENGTH)
  private String response;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "department_id", nullable = false)
  private Department department;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "employee_id", nullable = false)
  private Employee owner;
  @OneToMany (fetch = FetchType.EAGER, mappedBy = "phoneEntry")
  private Set < FollowUp > followUps;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public Boolean getSeen () {
    return seen;
  }

  public void setSeen (Boolean seen) {
    this.seen = seen;
  }

  public Boolean getShouldBeFollowed () {
    return shouldBeFollowed;
  }

  public void setShouldBeFollowed (Boolean shouldBeFollowed) {
    this.shouldBeFollowed = shouldBeFollowed;
  }

  public Boolean getRegistered () {
    return registered;
  }

  public void setRegistered (Boolean registered) {
    this.registered = registered;
  }

  public Boolean getPrivateClass () {
    return privateClass;
  }

  public void setPrivateClass (Boolean privateClass) {
    this.privateClass = privateClass;
  }

  public long getSubmitDate () {
    return submitDate;
  }

  public void setSubmitDate (long submitDate) {
    this.submitDate = submitDate;
  }

  public ColorType getColor () {
    return color;
  }

  public void setColor (ColorType color) {
    this.color = color;
  }

  public TypeDeMethodDeConnaissance getMethodDeConnaissance () {
    return methodDeConnaissance;
  }

  public void setMethodDeConnaissance (TypeDeMethodDeConnaissance methodDeConnaissance) {
    this.methodDeConnaissance = methodDeConnaissance;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getNumber () {
    return number;
  }

  public void setNumber (String number) {
    this.number = number;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }

  public String getResponse () {
    return response;
  }

  public void setResponse (String response) {
    this.response = response;
  }

  public Department getDepartment () {
    return department;
  }

  public void setDepartment (Department department) {
    this.department = department;
  }

  public Employee getOwner () {
    return owner;
  }

  public void setOwner (Employee owner) {
    this.owner = owner;
  }

  public Set < FollowUp > getFollowUps () {
    return followUps;
  }

  public void setFollowUps (Set < FollowUp > followUps) {
    this.followUps = followUps;
  }

  @Transient
  @Override
  public String toString () {
    String toReturn = "PhoneEntry {";
    toReturn += "Id:" + (id != null ? "\"" + id + "\"" : "null") + ", ";
    toReturn += "Dept.Id:" + (department != null ? "\"" + department.getId () + "\"" : "null") + ", ";
    toReturn += "Owner.Id:" + (owner != null ? "\"" + owner.getPersonId () + "\"" : "null") + ", ";
    toReturn += "Name:" + (name != null ? "\"" + name + "\"" : "null") + ", ";
    toReturn += "Number:" + (number != null ? "\"" + number + "\"" : "null") + ", ";
    toReturn += "Description:" + (description != null ? "\"" + description + "\"" : "null") + ", ";
    toReturn += "MethodDeConnaissance:\"" + methodDeConnaissance.toString () + "\", ";
    toReturn += "Seen:\"" + seen + "\", ";
    toReturn += "Color:\"" + (color != null ? "\"" + color.toString () + "\"" : "null") + ", ";
    toReturn += "SubmitDate:\"" + new DateTime (submitDate, DateTimeZone.UTC).toString () + "\" }";
    return toReturn;
  }
}
