package com.mftvanak.web.portal.web.kaptcha;

import java.awt.Color;
import java.awt.Font;

public interface KaptchaConfigurationProvider extends ConfigurationProvider {

	boolean isBorderDrawn();

	int getWidth();

	int getHeight();

	int getBorderThickness();

	int getTextProducerCharLength();

	int getTextProducerFontSize();

	int getTextProducerCharSpace();

	char[] getTextProducerCharString();

	String getSessionKey();

	String getSessionDate();

	Color getBorderColor();

	Color getBackgroundColorFrom();

	Color getBackgroundColorTo();

	Color getNoiseColor();

	Color getTextProducerFontColor();

	WordRenderer getWordRenderer();

	GimpyEngine getGimpyEngine();

	BackgroundProducer getBackgroundProducer();

	TextProducer getTextProducer();

	NoiseProducer getNoiseProducer();

	KaptchaProducer getKaptchaProducer();

	Font[] getTextProducerFonts(int fontSize);
}
