package org.labcrypto.edusys.common.messaging;


public interface SmsSender {

  String send (String to, String body);

  String[] send (String tos[], String body);
  
}