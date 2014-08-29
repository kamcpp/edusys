package com.mftvanak.edusys.engine.scheduler.education;

import java.util.List;

import com.mftvanak.edusys.engine.scheduler.education.reservation.DepartmentItem;
import com.mftvanak.edusys.engine.scheduler.education.reservation.general.ClassItem;
import com.mftvanak.edusys.engine.scheduler.education.reservation.general.GeneralReservationItem;
import com.mftvanak.edusys.engine.scheduler.education.reservation.general.GroupItem;
import com.mftvanak.edusys.engine.scheduler.education.reservation.general.HttpGeneralReservationListDownloader;
import com.mftvanak.edusys.engine.scheduler.education.reservation.general.XmlParserGeneralReservationListProcessor;


public class HttpGeneralReservationListDownloaderTest {

  public void download () {
    Downloader downloader = new HttpGeneralReservationListDownloader ("http://www.mftvanak.com/rApi.php?PASS=OpenApI12333");
    Processor processor = new XmlParserGeneralReservationListProcessor ();
    String downloaded = downloader.download ();
    List < DepartmentItem > departmentItems = processor.process (downloaded);
    if (departmentItems != null) {
      for (DepartmentItem departmentItem : departmentItems) {
        System.out.println (departmentItem);
        for (GroupItem groupItem : departmentItem.getGroups ()) {
          System.out.println ("-->" + groupItem);
          for (ClassItem classItem : groupItem.getClasses ()) {
            System.out.println ("----->" + classItem);
            for (GeneralReservationItem reserveItem : classItem.getGeneralReservationItems ()) {
              System.out.println ("-------->" + reserveItem);
            }
          }
        }

      }
    }
  }
}
