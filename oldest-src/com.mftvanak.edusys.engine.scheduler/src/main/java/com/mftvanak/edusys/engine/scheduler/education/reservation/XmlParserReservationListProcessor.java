package com.mftvanak.edusys.engine.scheduler.education.reservation;

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


public class XmlParserReservationListProcessor implements Processor {

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

        NodeList reservesNodeList = departmentElement.getElementsByTagName ("reserve");
        for (int iiii = 0; iiii < reservesNodeList.getLength (); iiii++) {
          Element reserveElement = (Element) reservesNodeList.item (iiii);
          ReservationItem reserveItem = new ReservationItem ();
          reserveItem.setDate (reserveElement.getElementsByTagName ("date").item (0).getTextContent ());
          reserveItem.setEmail (reserveElement.getElementsByTagName ("email").item (0).getTextContent ());
          reserveItem.setId (Long.parseLong (reserveElement.getElementsByTagName ("id").item (0).getTextContent ()));
          reserveItem.setName (reserveElement.getElementsByTagName ("name").item (0).getTextContent ());
          reserveItem.setPhone (reserveElement.getElementsByTagName ("phone").item (0).getTextContent ());
          reserveItem.setText (reserveElement.getElementsByTagName ("text").item (0).getTextContent ());
          reserveItem.setTime (reserveElement.getElementsByTagName ("time").item (0).getTextContent ());
          reserveItem.setPlanId (Long.parseLong (reserveElement.getElementsByTagName ("plan").item (0).getTextContent ()));
          departmentItem.getReservations ().add (reserveItem);
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
