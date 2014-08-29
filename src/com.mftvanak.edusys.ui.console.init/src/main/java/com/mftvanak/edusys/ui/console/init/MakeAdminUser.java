package com.mftvanak.edusys.ui.console.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.common.security.HashProvider;
import com.mftvanak.edusys.domain.dao.membership.RoleDao;
import com.mftvanak.edusys.domain.dao.membership.UserDao;
import com.mftvanak.edusys.domain.dao.personnel.PersonDao;
import com.mftvanak.edusys.domain.entity.membership.Role;
import com.mftvanak.edusys.domain.entity.membership.User;
import com.mftvanak.edusys.domain.entity.personnel.Person;
import com.mftvanak.edusys.domain.entity.personnel.Person.GenderType;


public class MakeAdminUser {

  @Autowired
  private RoleDao roleDao;

  @Autowired
  private UserDao userDao;

  @Autowired
  private PersonDao personDao;

  @Autowired
  private HashProvider hashProvider;

  public void perform () {

    Role role = new Role ();
    role.setName ("ROLE_ADMIN");
    roleDao.save (role);

    Person person = new Person ();
    person.setPersianName ("Admin");
    person.setEnglishName ("Admin");
    person.setPersianFamily ("Admin");
    person.setEnglishFamily ("Admin");
    person.setGender (GenderType.Male);
    personDao.save (person);

    User user = new User ();
    user.setPerson (person);
    user.setActive (true);
    user.setAccountEmail ("admin@mftvanak.com");
    user.setHashedPassword (hashProvider.hash ("12345"));
    user.setUsername ("admin");
    user.getRoles ().add (role);
    userDao.save (user);

    System.out.println ("Admin user is added.");
  }

  public void printUsers () {
    System.out.println ("Reading ...");
    List < User > users = userDao.getAll ();
    System.out.println ("Read.");
    for (User user : users.toArray (new User[] {})) {
      System.out.println (user.getUsername ());
      System.out.println (user.getPerson ().getEnglishName () + " " + user.getPerson ().getEnglishFamily ());
      System.out.println ((user.getRoles ().toArray (new Role[] {})[0]).getName ());
      System.out.println ("----");
    }
  }

  public void printAdminUser () {
    System.out.println ("Reading ...");
    User user = userDao.getUsersByUsernameAndPassword ("admin", hashProvider.hash ("1234"));
    System.out.println ("Read.");
    if (user != null) {
      System.out.println ("ERROR: User should be null.");
      return;
    }
    System.out.println ("Searching for user ...");
    user = userDao.getUsersByUsernameAndPassword ("admin", hashProvider.hash ("12345"));
    if (user == null) {
      System.out.println ("ERROR: User is null.");
      return;
    }
    System.out.println ("Found.");
    System.out.println (user.getUsername ());
    System.out.println (user.getPerson ().getEnglishName () + " " + user.getPerson ().getEnglishFamily ());
    System.out.println ((user.getRoles ().toArray (new Role[] {})[0]).getName ());
    System.out.println ("----");
  }
}
