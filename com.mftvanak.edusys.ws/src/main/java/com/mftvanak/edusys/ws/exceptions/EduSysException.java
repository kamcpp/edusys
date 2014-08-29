package com.mftvanak.edusys.ws.exceptions;

public class EduSysException extends Exception {

  private static final long serialVersionUID = 3933390580602046704L;

  public EduSysException (String message) {
    super (message);
  }

  public EduSysException (String message, Throwable cause) {
    super (message, cause);
  }
}
