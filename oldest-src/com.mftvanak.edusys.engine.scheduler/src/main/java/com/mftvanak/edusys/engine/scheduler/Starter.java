package com.mftvanak.edusys.engine.scheduler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Starter {

  public static void main (String[] args) {
    @SuppressWarnings ("resource")
    ApplicationContext context = new ClassPathXmlApplicationContext ("spring.xml");
    Scheduler scheduler = (Scheduler) context.getBean ("scheduler");
    scheduler.start ();
  }
}
