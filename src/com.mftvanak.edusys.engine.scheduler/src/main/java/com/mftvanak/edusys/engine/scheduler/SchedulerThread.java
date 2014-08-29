package com.mftvanak.edusys.engine.scheduler;

public class SchedulerThread implements Runnable {

  private TaskDefinition taskDefinition;

  public SchedulerThread (TaskDefinition taskDefinition) {
    this.taskDefinition = taskDefinition;
  }

  public TaskDefinition getTask () {
    return taskDefinition;
  }

  @Override
  public void run () {
    while (true) {
      if (taskDefinition.runOnStart ()) {
        taskDefinition.getTask ().run ();
      }
      try {
        Thread.sleep (taskDefinition.getInterval ());
      } catch (InterruptedException e) {
        e.printStackTrace ();
      }
    }
  }
}
