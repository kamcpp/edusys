package com.mftvanak.web.portal.web.kaptcha;

import java.awt.image.BufferedImage;

public interface KaptchaProducer
{
	public BufferedImage createImage(String text);

	public String createText();
}