package org.labcrypto.edusys.facade.messaging;

public interface MessagingFacade {

  String sendSms (String to, String body);

  String[] sendSms (String[] tos, String body);
}
