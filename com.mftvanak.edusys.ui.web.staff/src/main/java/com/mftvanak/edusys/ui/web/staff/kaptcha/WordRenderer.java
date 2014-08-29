package com.mftvanak.edusys.ui.web.staff.kaptcha;

import java.awt.image.BufferedImage;

/**
 * {@link WordRenderer} is responsible for rendering words.
 */
public interface WordRenderer
{
	public BufferedImage renderWord(String word, int width, int height);
}
