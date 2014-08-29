package com.mftvanak.edusys.ui.web.staff.kaptcha;

import java.awt.image.BufferedImage;

/**
 * {@link NoiseProducer} is responsible for adding noise to an image.
 */
public interface NoiseProducer {
	public void makeNoise(BufferedImage image, float factorOne,
			float factorTwo, float factorThree, float factorFour);
}