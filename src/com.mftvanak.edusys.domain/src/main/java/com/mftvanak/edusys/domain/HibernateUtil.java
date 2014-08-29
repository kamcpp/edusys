package com.mftvanak.edusys.domain;

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
      classesToAdd.add (com.mftvanak.edusys.domain.entity.audit.AuditLog.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.membership.Role.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.membership.Token.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.membership.User.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.messaging.TodoItem.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.messaging.TodoItemAttachement.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.messaging.SendListItem.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.messaging.SendRequest.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.messaging.MessageTemplate.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.official.Employee.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.personnel.Person.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.phonebook.PhoneEntry.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.phonebook.FollowUp.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.cms.CmsReservation.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.cms.CmsReservationPlan.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.cms.CmsDepartment.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.cms.CmsGroup.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.cms.CmsClass.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.cms.CmsGeneralReservation.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.Department.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.Institute.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.Group.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.Tag.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.Course.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.CourseClass.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.CoursePlan.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.CourseResource.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.CourseSyllabus.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.CoursePlanReservation.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.Student.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.Teacher.class);
      classesToAdd.add (com.mftvanak.edusys.domain.entity.education.Term.class);

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
