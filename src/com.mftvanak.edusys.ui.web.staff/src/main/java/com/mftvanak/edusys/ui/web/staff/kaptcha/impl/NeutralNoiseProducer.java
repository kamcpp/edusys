package com.mftvanak.edusys.ui.web.staff.kaptcha.impl;

import java.awt.image.BufferedImage;

import com.mftvanak.edusys.ui.web.staff.kaptcha.NoiseProducer;


public class NeutralNoiseProducer implements NoiseProducer {

	@Override
	public void makeNoise(BufferedImage image, float factorOne,
			float factorTwo, float factorThree, float factorFour) {
	}
}
