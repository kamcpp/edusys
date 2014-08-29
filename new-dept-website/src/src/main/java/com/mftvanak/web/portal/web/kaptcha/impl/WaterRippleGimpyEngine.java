package com.mftvanak.web.portal.web.kaptcha.impl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.jhlabs.image.RippleFilter;
import com.jhlabs.image.TransformFilter;
import com.jhlabs.image.WaterFilter;
import com.mftvanak.web.portal.web.kaptcha.GimpyEngine;
import com.mftvanak.web.portal.web.kaptcha.KaptchaCommon;
import com.mftvanak.web.portal.web.kaptcha.NoiseProducer;

public class WaterRippleGimpyEngine implements GimpyEngine {

	@Override
	public BufferedImage getDistortedImage(BufferedImage baseImage) {
		NoiseProducer noiseProducer = KaptchaCommon.getConfigurationProvider()
				.getNoiseProducer();
		BufferedImage distortedImage = new BufferedImage(baseImage.getWidth(),
				baseImage.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics = (Graphics2D) distortedImage.getGraphics();

		RippleFilter rippleFilter = new RippleFilter();
		rippleFilter.setWaveType(RippleFilter.SINE);
		rippleFilter.setXAmplitude(2.6f);
		rippleFilter.setYAmplitude(1.7f);
		rippleFilter.setXWavelength(15);
		rippleFilter.setYWavelength(5);
		rippleFilter.setEdgeAction(TransformFilter.NEAREST_NEIGHBOUR);

		WaterFilter waterFilter = new WaterFilter();
		waterFilter.setAmplitude(1.5f);
		waterFilter.setPhase(10);
		waterFilter.setWavelength(2);

		BufferedImage effectImage = waterFilter.filter(baseImage, null);
		effectImage = rippleFilter.filter(effectImage, null);

		graphics.drawImage(effectImage, 0, 0, null, null);

		graphics.dispose();

		noiseProducer.makeNoise(distortedImage, .1f, .1f, .25f, .25f);
		noiseProducer.makeNoise(distortedImage, .1f, .25f, .5f, .9f);
		return distortedImage;
	}
}
