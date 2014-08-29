package com.mftvanak.web.portal.web.kaptcha.impl;

import java.awt.image.BufferedImage;

import com.mftvanak.web.portal.web.kaptcha.NoiseProducer;


public class NeutralNoiseProducer implements NoiseProducer {

	@Override
	public void makeNoise(BufferedImage image, float factorOne,
			float factorTwo, float factorThree, float factorFour) {
	}
}
