package com.mftvanak.edusys.engine.scheduler;

import java.util.ArrayList;
import java.util.List;


public class Scheduler {

  private List < TaskDefinition > taskDefinitions;

  public List < TaskDefinition > getTaskDefinitions () {
    if (taskDefinitions == null) {
      taskDefinitions = new ArrayList < TaskDefinition > ();
    }
    return taskDefinitions;
  }

  public void setTaskDefinitions (List < TaskDefinition > taskDefinitions) {
    this.taskDefinitions = taskDefinitions;
  }

  public void start () {
    for (TaskDefinition taskDefinition : taskDefinitions) {
      SchedulerThread schedulerThread = new SchedulerThread (taskDefinition);
      Thread thread = new Thread (schedulerThread);
      thread.setName (taskDefinition.getName ());
      System.out.println ("Starting task thread: " + taskDefinition.getName ());
      thread.start ();
    }
  }
}
