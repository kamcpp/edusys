package com.mftvanak.edusys.engine.scheduler.education;

import java.util.List;

import com.mftvanak.edusys.engine.scheduler.education.reservation.DepartmentItem;
import com.mftvanak.edusys.engine.scheduler.education.reservation.HttpReservationListDownloader;
import com.mftvanak.edusys.engine.scheduler.education.reservation.ReservationItem;
import com.mftvanak.edusys.engine.scheduler.education.reservation.XmlParserReservationListProcessor;


public class HttpReservationListDownloaderTest {

  public static void main (String[] args) {
    Downloader downloader = new HttpReservationListDownloader ("http://www.mftvanak.com/rApi2.php?PASS=OpenApI12333");
    Processor processor = new XmlParserReservationListProcessor ();
    String downloaded = downloader.download ();
    System.out.println (downloaded);
    List < DepartmentItem > departmentItems = processor.process (downloaded);
    if (departmentItems != null) {
      for (DepartmentItem departmentItem : departmentItems) {
        System.out.println (departmentItem);
        for (ReservationItem reserveItem : departmentItem.getReservations ()) {
          System.out.println ("-->" + reserveItem);
        }
      }
    }
  }
}
