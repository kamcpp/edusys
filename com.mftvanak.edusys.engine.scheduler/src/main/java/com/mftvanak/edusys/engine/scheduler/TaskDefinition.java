package com.mftvanak.edusys.engine.scheduler;

public class TaskDefinition {

  private boolean runOnStart;
  private long interval;
  private String name;
  private Task task;

  public boolean runOnStart () {
    return runOnStart;
  }

  public void setRunOnStart (boolean runOnStart) {
    this.runOnStart = runOnStart;
  }

  public long getInterval () {
    return interval;
  }

  public void setInterval (long interval) {
    this.interval = interval;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public Task getTask () {
    return task;
  }

  public void setTask (Task task) {
    this.task = task;
  }
}
