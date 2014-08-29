package com.mftvanak.edusys.ui.web.staff.kaptcha;

import java.awt.image.BufferedImage;


public interface GimpyEngine
{
	public BufferedImage getDistortedImage(BufferedImage baseImage);
}