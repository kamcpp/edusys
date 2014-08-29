package com.mftvanak.edusys.engine.scheduler.education;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.mftvanak.edusys.engine.scheduler.Task;
import com.mftvanak.edusys.engine.scheduler.education.reservation.DepartmentItem;


public class DownloadTask implements Task {

  private String name;
  private Downloader downloader;
  private Processor processor;
  private Persistor persistor;

  public DownloadTask () {
  }

  public DownloadTask (Downloader downloader, Processor processor, Persistor persistor) {
    setDownloader (downloader);
    setProcessor (processor);
    setPersistor (persistor);
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public Downloader getDownloader () {
    return downloader;
  }

  public void setDownloader (Downloader downloader) {
    this.downloader = downloader;
  }

  public Processor getProcessor () {
    return processor;
  }

  public void setProcessor (Processor processor) {
    this.processor = processor;
  }

  public Persistor getPersistor () {
    return persistor;
  }

  public void setPersistor (Persistor persistor) {
    this.persistor = persistor;
  }

  @Override
  public void run () {
    System.out.println ("----------------------------");
    System.out.println (" START(" + getName () + "): " + new DateTime (DateTimeZone.UTC).toString () + " UTC");
    System.out.println ("----------------------------");

    String result = downloader.download ();
    List < DepartmentItem > reserveItems = processor.process (result);
    if (reserveItems != null) {
      persistor.persist (reserveItems);
    }

    System.out.println ("----------------------------");
    System.out.println (" END(" + getName () + "): " + new DateTime (DateTimeZone.UTC).toString () + " UTC");
    System.out.println ("----------------------------");
    System.out.println ();
  }
}
