package com.mftvanak.edusys.engine.scheduler.education.reservation.general;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mftvanak.edusys.engine.scheduler.education.Processor;
import com.mftvanak.edusys.engine.scheduler.education.reservation.DepartmentItem;


public class XmlParserGeneralReservationListProcessor implements Processor {

  @Override
  public List < DepartmentItem > process (String downloaded) {
    List < DepartmentItem > toReturn = new ArrayList < DepartmentItem > ();
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance ();
    DocumentBuilder dBuilder;
    try {
      dBuilder = dbFactory.newDocumentBuilder ();
      Document doc = dBuilder.parse (new ByteArrayInputStream (downloaded.getBytes ()));
      doc.getDocumentElement ().normalize ();
      NodeList departmentsNodeList = doc.getElementsByTagName ("department");
      for (int i = 0; i < departmentsNodeList.getLength (); i++) {
        Element departmentElement = (Element) departmentsNodeList.item (i);
        DepartmentItem departmentItem = new DepartmentItem ();
        departmentItem.setId (Long.parseLong (departmentElement.getElementsByTagName ("id").item (0).getTextContent ()));
        departmentItem.setName (departmentElement.getElementsByTagName ("name").item (0).getTextContent ());

        NodeList groupsNodeList = departmentElement.getElementsByTagName ("group");
        for (int ii = 0; ii < groupsNodeList.getLength (); ii++) {
          Element groupElement = (Element) groupsNodeList.item (ii);
          GroupItem groupItem = new GroupItem ();
          groupItem.setId (Long.parseLong (groupElement.getElementsByTagName ("id").item (0).getTextContent ()));
          groupItem.setName (groupElement.getElementsByTagName ("name").item (0).getTextContent ());

          NodeList classesNodeList = groupElement.getElementsByTagName ("class");
          for (int iii = 0; iii < classesNodeList.getLength (); iii++) {
            Element classElement = (Element) classesNodeList.item (iii);
            ClassItem classItem = new ClassItem ();
            classItem.setId (Long.parseLong (classElement.getElementsByTagName ("id").item (0).getTextContent ()));
            classItem.setName (classElement.getElementsByTagName ("name").item (0).getTextContent ());

            NodeList reservesNodeList = classElement.getElementsByTagName ("reserve");
            for (int iiii = 0; iiii < reservesNodeList.getLength (); iiii++) {
              Element reserveElement = (Element) reservesNodeList.item (iiii);
              GeneralReservationItem reserveItem = new GeneralReservationItem ();
              reserveItem.setDate (reserveElement.getElementsByTagName ("date").item (0).getTextContent ());
              reserveItem.setEmail (reserveElement.getElementsByTagName ("email").item (0).getTextContent ());
              reserveItem.setId (Long.parseLong (reserveElement.getElementsByTagName ("id").item (0).getTextContent ()));
              reserveItem.setName (reserveElement.getElementsByTagName ("name").item (0).getTextContent ());
              reserveItem.setPhone (reserveElement.getElementsByTagName ("phone").item (0).getTextContent ());
              reserveItem.setText (reserveElement.getElementsByTagName ("text").item (0).getTextContent ());
              classItem.getGeneralReservationItems ().add (reserveItem);
            }
            groupItem.getClasses ().add (classItem);
          }

          departmentItem.getGroups ().add (groupItem);
        }
        toReturn.add (departmentItem);
      }
      return toReturn;
    } catch (ParserConfigurationException e) {
      e.printStackTrace ();
      return null;
    } catch (SAXException e) {
      e.printStackTrace ();
      return null;
    } catch (IOException e) {
      e.printStackTrace ();
      return null;
    }
  }
}
