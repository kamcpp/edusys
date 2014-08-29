package org.labcrypto.edusys.domain.pg;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


@SuppressWarnings ("rawtypes")
public class HibernateUtil {

  private static final SessionFactory sessionFactory;

  static {
    try {
      List < Class > classesToAdd = new ArrayList < Class > ();
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.audit.AuditLog.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.membership.Role.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.membership.Token.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.membership.User.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.messaging.TodoItem.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.messaging.TodoItemAttachement.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.messaging.SendListItem.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.messaging.SendRequest.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.messaging.MessageTemplate.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.official.Employee.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.personnel.Person.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.phonebook.PhoneEntry.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.phonebook.FollowUp.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.cms.CmsReservation.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.cms.CmsReservationPlan.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.cms.CmsDepartment.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.cms.CmsGroup.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.cms.CmsClass.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.cms.CmsGeneralReservation.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.Department.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.Institute.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.Group.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.Tag.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.Course.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.CourseClass.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.CoursePlan.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.CourseResource.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.CourseSyllabus.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.CoursePlanReservation.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.Student.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.Teacher.class);
      classesToAdd.add (org.labcrypto.edusys.domain.pg.entity.education.Term.class);

      System.out.println ("Adding classes ...");
      AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration ().configure ().addPackage (
          "com.mftvanak.edusys.domain");
      for (Class clazz : classesToAdd) {
        annotationConfiguration = annotationConfiguration.addAnnotatedClass (clazz);
      }
      System.out.println ("Classes are added.");
      System.out.println ("Making session factory ...");
      sessionFactory = annotationConfiguration.buildSessionFactory ();
      System.out.println ("Session factory is created.");
    } catch (Throwable ex) {
      ex.printStackTrace ();
      throw new ExceptionInInitializerError (ex);
    }
  }

  public static SessionFactory getSessionFactory () {
    return sessionFactory;
  }
}
