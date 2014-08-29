package com.mftvanak.web.portal.web.kaptcha;

import java.awt.image.BufferedImage;


public interface GimpyEngine
{
	public BufferedImage getDistortedImage(BufferedImage baseImage);
}