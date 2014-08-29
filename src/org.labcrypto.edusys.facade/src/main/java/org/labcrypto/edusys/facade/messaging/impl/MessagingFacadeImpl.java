package org.labcrypto.edusys.facade.messaging.impl;

import org.labcrypto.edusys.common.messaging.SmsSender;
import org.labcrypto.edusys.facade.messaging.MessagingFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class MessagingFacadeImpl implements MessagingFacade {

	@Autowired
	private SmsSender smsSender;

	@Override
	public String sendSms(String to, String body) {
		return smsSender.send(to, body);
	}

	@Override
	public String[] sendSms(String[] tos, String body) {
		return smsSender.send(tos, body);
	}
}
