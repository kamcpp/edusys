package com.mftvanak.edusys.ui.web.staff.kaptcha.impl;

import java.util.Random;

import com.mftvanak.edusys.ui.web.staff.kaptcha.KaptchaCommon;
import com.mftvanak.edusys.ui.web.staff.kaptcha.TextProducer;


public class DefaultTextProducer implements TextProducer {

	@Override
	public String getText() {
		int length = KaptchaCommon.getConfigurationProvider()
				.getTextProducerCharLength();
		char[] chars = KaptchaCommon.getConfigurationProvider()
				.getTextProducerCharString();
		Random rand = new Random();
		StringBuffer text = new StringBuffer();
		for (int i = 0; i < length; i++) {
			text.append(chars[rand.nextInt(chars.length)]);
		}

		return text.toString();
	}
}
