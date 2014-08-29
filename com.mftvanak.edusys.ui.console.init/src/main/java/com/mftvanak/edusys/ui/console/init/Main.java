package com.mftvanak.edusys.ui.console.init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

  public static void main (String[] args) {
    @SuppressWarnings ("resource")
    ApplicationContext context = new ClassPathXmlApplicationContext ("spring.xml");
    MakeAdminUser makeAdminUser = (MakeAdminUser) context.getBean ("makeAdminUser");
    makeAdminUser.perform ();
    makeAdminUser.printUsers ();
    makeAdminUser.printAdminUser ();
  }
}
