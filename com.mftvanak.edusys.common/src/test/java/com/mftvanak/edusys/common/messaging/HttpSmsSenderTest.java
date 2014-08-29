package com.mftvanak.edusys.common.messaging;

import com.mftvanak.edusys.common.messaging.impl.HttpSmsSender;


public class HttpSmsSenderTest {

  public static void main (String[] args) {
    HttpSmsSender smsSender = new HttpSmsSender ();
    smsSender.setUrl ("http://sms.niazpardaz.com/post/sendWithDelivery.ashx");
    smsSender.setUsername ("mftvanak");
    smsSender.setPassword ("@mftsms");
    smsSender.setFrom ("10000088889796");
    for (int i = 0; i < 1; i++) {
      String[] refIds = smsSender.send (new String[] {"09354592365", "09354592365"}, "با سلام این یک پیامک تست است mftvanak.");
      System.out.println ("Sent.");
      for (String refId : refIds) {
        System.out.println (refId);
      }
    }
  }
}
