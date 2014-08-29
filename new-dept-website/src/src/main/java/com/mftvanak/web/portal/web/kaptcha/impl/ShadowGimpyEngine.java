package com.mftvanak.web.portal.web.kaptcha.impl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.jhlabs.image.RippleFilter;
import com.jhlabs.image.ShadowFilter;
import com.jhlabs.image.TransformFilter;
import com.mftvanak.web.portal.web.kaptcha.GimpyEngine;
import com.mftvanak.web.portal.web.kaptcha.KaptchaCommon;
import com.mftvanak.web.portal.web.kaptcha.NoiseProducer;


public class ShadowGimpyEngine implements GimpyEngine {
	@Override
	public BufferedImage getDistortedImage(BufferedImage baseImage) {
		NoiseProducer noiseProducer = KaptchaCommon.getConfigurationProvider()
				.getNoiseProducer();
		BufferedImage distortedImage = new BufferedImage(baseImage.getWidth(),
				baseImage.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D graph = (Graphics2D) distortedImage.getGraphics();

		ShadowFilter shadowFilter = new ShadowFilter();
		shadowFilter.setRadius(10);
		shadowFilter.setDistance(5);
		shadowFilter.setOpacity(1);

		Random rand = new Random();

		RippleFilter rippleFilter = new RippleFilter();
		rippleFilter.setWaveType(RippleFilter.SINE);
		rippleFilter.setXAmplitude(7.6f);
		rippleFilter.setYAmplitude(rand.nextFloat() + 1.0f);
		rippleFilter.setXWavelength(rand.nextInt(7) + 8);
		rippleFilter.setYWavelength(rand.nextInt(3) + 2);
		rippleFilter.setEdgeAction(TransformFilter.BILINEAR);

		BufferedImage effectImage = rippleFilter.filter(baseImage, null);
		effectImage = shadowFilter.filter(effectImage, null);

		graph.drawImage(effectImage, 0, 0, null, null);
		graph.dispose();

		noiseProducer.makeNoise(distortedImage, .1f, .1f, .25f, .25f);
		noiseProducer.makeNoise(distortedImage, .1f, .25f, .5f, .9f);

		return distortedImage;
	}
}
