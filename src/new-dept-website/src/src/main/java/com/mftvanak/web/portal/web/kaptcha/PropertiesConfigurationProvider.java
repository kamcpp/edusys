package com.mftvanak.web.portal.web.kaptcha;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import com.mftvanak.web.portal.web.kaptcha.impl.DefaultBackgroundProducer;
import com.mftvanak.web.portal.web.kaptcha.impl.DefaultKaptchaProducer;
import com.mftvanak.web.portal.web.kaptcha.impl.DefaultNoiseProducer;
import com.mftvanak.web.portal.web.kaptcha.impl.DefaultTextProducer;
import com.mftvanak.web.portal.web.kaptcha.impl.DefaultWordRenderer;
import com.mftvanak.web.portal.web.kaptcha.impl.WaterRippleGimpyEngine;

public class PropertiesConfigurationProvider implements
		KaptchaConfigurationProvider {

	protected boolean isBorderDrawn;
	protected int borderThickness;
	protected int textProducerCharLength;
	protected int textProducerFontSize;
	protected int textProducerCharSpace;
	protected int width;
	protected int height;
	protected char[] textProducerCharString;
	protected Color borderColor;
	protected Color textProducerFontColor;
	protected Color noiseColor;
	protected Color backgroundColorFrom;
	protected Color backgroundColorTo;
	protected KaptchaProducer kaptchaProducer;
	protected TextProducer textProducer;
	protected NoiseProducer noiseProducer;
	protected GimpyEngine gimpyEngine;
	protected WordRenderer wordRenderer;
	protected BackgroundProducer backgroundProducer;

	private Properties properties;

	public PropertiesConfigurationProvider(Properties properties) {
		this.properties = properties;
	}

	public Properties getProperties() {
		return this.properties;
	}

	@Override
	public void init() {
		String paramName = Constants.KAPTCHA_BORDER;
		String paramValue = this.properties.getProperty(paramName);
		isBorderDrawn = ConfigurationHelper.getBoolean(paramName, paramValue,
				true);

		paramName = Constants.KAPTCHA_BORDER_COLOR;
		paramValue = this.properties.getProperty(paramName);
		borderColor = ConfigurationHelper.getColor(paramName, paramValue,
				Color.BLACK);

		paramName = Constants.KAPTCHA_BORDER_THICKNESS;
		paramValue = this.properties.getProperty(paramName);
		borderThickness = ConfigurationHelper.getPositiveInt(paramName,
				paramValue, 1);

		paramName = Constants.KAPTCHA_PRODUCER_IMPL;
		paramValue = this.properties.getProperty(paramName);
		kaptchaProducer = (KaptchaProducer) ConfigurationHelper
				.getClassInstance(paramName, paramValue,
						new DefaultKaptchaProducer());

		paramName = Constants.KAPTCHA_TEXTPRODUCER_IMPL;
		paramValue = this.properties.getProperty(paramName);
		textProducer = (TextProducer) ConfigurationHelper.getClassInstance(
				paramName, paramValue, new DefaultTextProducer());

		paramName = Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING;
		paramValue = this.properties.getProperty(paramName);
		textProducerCharString = ConfigurationHelper.getChars(paramName,
				paramValue, "abcde2345678gfynmnpwx".toCharArray());

		paramName = Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH;
		paramValue = this.properties.getProperty(paramName);
		textProducerCharLength = ConfigurationHelper.getPositiveInt(paramName,
				paramValue, 5);

		paramName = Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE;
		paramValue = this.properties.getProperty(paramName);
		textProducerFontSize = ConfigurationHelper.getPositiveInt(paramName,
				paramValue, 40);

		paramName = Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR;
		paramValue = this.properties.getProperty(paramName);
		textProducerFontColor = ConfigurationHelper.getColor(paramName,
				paramValue, Color.BLACK);

		paramName = Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE;
		paramValue = properties.getProperty(paramName);
		textProducerCharSpace = ConfigurationHelper.getPositiveInt(paramName,
				paramValue, 2);

		paramName = Constants.KAPTCHA_NOISE_IMPL;
		paramValue = this.properties.getProperty(paramName);
		noiseProducer = (NoiseProducer) ConfigurationHelper.getClassInstance(
				paramName, paramValue, new DefaultNoiseProducer());

		paramName = Constants.KAPTCHA_NOISE_COLOR;
		paramValue = this.properties.getProperty(paramName);
		noiseColor = ConfigurationHelper.getColor(paramName, paramValue,
				Color.BLACK);

		paramName = Constants.KAPTCHA_OBSCURIFICATOR_IMPL;
		paramValue = this.properties.getProperty(paramName);
		gimpyEngine = (GimpyEngine) ConfigurationHelper.getClassInstance(
				paramName, paramValue, new WaterRippleGimpyEngine());

		paramName = Constants.KAPTCHA_WORDRENDERER_IMPL;
		paramValue = this.properties.getProperty(paramName);
		wordRenderer = (WordRenderer) ConfigurationHelper.getClassInstance(
				paramName, paramValue, new DefaultWordRenderer());

		paramName = Constants.KAPTCHA_BACKGROUND_IMPL;
		paramValue = this.properties.getProperty(paramName);
		backgroundProducer = (BackgroundProducer) ConfigurationHelper
				.getClassInstance(paramName, paramValue,
						new DefaultBackgroundProducer());

		paramName = Constants.KAPTCHA_BACKGROUND_CLR_FROM;
		paramValue = this.properties.getProperty(paramName);
		backgroundColorFrom = ConfigurationHelper.getColor(paramName,
				paramValue, Color.LIGHT_GRAY);

		paramName = Constants.KAPTCHA_BACKGROUND_CLR_TO;
		paramValue = this.properties.getProperty(paramName);
		backgroundColorTo = ConfigurationHelper.getColor(paramName, paramValue,
				Color.WHITE);

		paramName = Constants.KAPTCHA_IMAGE_WIDTH;
		paramValue = this.properties.getProperty(paramName);
		width = ConfigurationHelper.getPositiveInt(paramName, paramValue, 200);

		paramName = Constants.KAPTCHA_IMAGE_HEIGHT;
		paramValue = this.properties.getProperty(paramName);
		height = ConfigurationHelper.getPositiveInt(paramName, paramValue, 50);
	}

	@Override
	public boolean isBorderDrawn() {
		return isBorderDrawn;
	}

	@Override
	public Color getBorderColor() {
		return borderColor;
	}

	@Override
	public int getBorderThickness() {
		return borderThickness;
	}

	@Override
	public KaptchaProducer getKaptchaProducer() {
		return kaptchaProducer;
	}

	@Override
	public TextProducer getTextProducer() {
		return textProducer;
	}

	@Override
	public char[] getTextProducerCharString() {
		return textProducerCharString;
	}

	@Override
	public int getTextProducerCharLength() {
		return textProducerCharLength;
	}

	@Override
	public Font[] getTextProducerFonts(int fontSize) {
		String paramName = Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES;
		String paramValue = this.properties.getProperty(paramName);
		return ConfigurationHelper.getFonts(paramName, paramValue, fontSize,
				new Font[] { new Font("Arial", Font.BOLD, fontSize),
						new Font("Courier", Font.BOLD, fontSize) });
	}

	@Override
	public int getTextProducerFontSize() {
		return textProducerFontSize;
	}

	@Override
	public Color getTextProducerFontColor() {
		return textProducerFontColor;
	}

	@Override
	public int getTextProducerCharSpace() {
		return textProducerCharSpace;
	}

	@Override
	public NoiseProducer getNoiseProducer() {
		return noiseProducer;
	}

	@Override
	public Color getNoiseColor() {
		return noiseColor;
	}

	@Override
	public GimpyEngine getGimpyEngine() {
		return gimpyEngine;
	}

	@Override
	public WordRenderer getWordRenderer() {
		return wordRenderer;
	}

	@Override
	public BackgroundProducer getBackgroundProducer() {
		return backgroundProducer;
	}

	@Override
	public Color getBackgroundColorFrom() {
		return backgroundColorFrom;
	}

	@Override
	public Color getBackgroundColorTo() {
		return backgroundColorTo;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public String getSessionKey() {
		return this.properties.getProperty(
				Constants.KAPTCHA_SESSION_CONFIG_KEY,
				Constants.KAPTCHA_SESSION_KEY);
	}

	@Override
	public String getSessionDate() {
		return this.properties.getProperty(
				Constants.KAPTCHA_SESSION_CONFIG_DATE,
				Constants.KAPTCHA_SESSION_DATE);
	}
}
