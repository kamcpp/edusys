package com.mftvanak.edusys.ui.web.staff.kaptcha;

import java.awt.image.BufferedImage;

public interface KaptchaProducer
{
	public BufferedImage createImage(String text);

	public String createText();
}