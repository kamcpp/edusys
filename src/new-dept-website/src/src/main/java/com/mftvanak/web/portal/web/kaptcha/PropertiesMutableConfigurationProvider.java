package com.mftvanak.web.portal.web.kaptcha;

import java.awt.Color;
import java.util.Properties;

public class PropertiesMutableConfigurationProvider extends
		PropertiesConfigurationProvider implements
		KaptchaMutableConfigurationProvider {

	public PropertiesMutableConfigurationProvider(Properties properties) {
		super(properties);
	}

	@Override
	public void setBorderDrawn(boolean isBorderDrawn) {
		this.isBorderDrawn = isBorderDrawn;

	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void setBorderThickness(int borderThickness) {
		this.borderThickness = borderThickness;
	}

	@Override
	public void setTextProducerCharLength(int textProducerCharLength) {
		this.textProducerCharLength = textProducerCharLength;
	}

	@Override
	public void setTextProducerFontSize(int textProducerFontSize) {
		this.textProducerFontSize = textProducerFontSize;
	}

	@Override
	public void setTextProducerCharSpace(int textProducerCharSpace) {
		this.textProducerCharSpace = textProducerCharSpace;
	}

	@Override
	public void setTextProducerCharString(char[] textProducerCharString) {
		this.textProducerCharString = textProducerCharString;
	}

	@Override
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	@Override
	public void setBackgroundColorFrom(Color backgroundColorFrom) {
		this.backgroundColorFrom = backgroundColorFrom;
	}

	@Override
	public void setBackgroundColorTo(Color backgroundColorTo) {
		this.backgroundColorTo = backgroundColorTo;
	}

	@Override
	public void setNoiseColor(Color noiseColor) {
		this.noiseColor = noiseColor;
	}

	@Override
	public void setTextProducerFontColor(Color textProducerFontColor) {
		this.textProducerFontColor = textProducerFontColor;
	}

	@Override
	public void setWordRenderer(WordRenderer wordRenderer) {
		this.wordRenderer = wordRenderer;
	}

	@Override
	public void setGimpyEngine(GimpyEngine gimpyEngine) {
		this.gimpyEngine = gimpyEngine;
	}

	@Override
	public void setBackgroundProducer(BackgroundProducer backgroundProducer) {
		this.backgroundProducer = backgroundProducer;
	}

	@Override
	public void setTextProducer(TextProducer textProducer) {
		this.textProducer = textProducer;
	}

	@Override
	public void setNoiseProducer(NoiseProducer noiseProducer) {
		this.noiseProducer = noiseProducer;
	}
}
