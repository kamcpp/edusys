package com.mftvanak.edusys.ui.web.staff.kaptcha.impl;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import com.mftvanak.edusys.ui.web.staff.kaptcha.KaptchaCommon;
import com.mftvanak.edusys.ui.web.staff.kaptcha.KaptchaProducer;


public class DefaultKaptchaProducer implements KaptchaProducer {

	@Override
	public BufferedImage createImage(String text) {
		BufferedImage bi = KaptchaCommon
				.getConfigurationProvider()
				.getWordRenderer()
				.renderWord(text,
						KaptchaCommon.getConfigurationProvider().getWidth(),
						KaptchaCommon.getConfigurationProvider().getHeight());
		bi = KaptchaCommon.getConfigurationProvider().getGimpyEngine()
				.getDistortedImage(bi);
		bi = KaptchaCommon.getConfigurationProvider().getBackgroundProducer()
				.addBackground(bi);
		Graphics2D graphics = bi.createGraphics();
		if (KaptchaCommon.getConfigurationProvider().isBorderDrawn()) {
			drawBox(graphics);
		}
		return bi;
	}

	@Override
	public String createText() {
		return KaptchaCommon.getConfigurationProvider().getTextProducer()
				.getText();
	}

	private void drawBox(Graphics2D graphics) {

		graphics.setColor(KaptchaCommon.getConfigurationProvider()
				.getBorderColor());
		if (KaptchaCommon.getConfigurationProvider().getBorderThickness() != 1) {
			BasicStroke stroke = new BasicStroke((float) KaptchaCommon
					.getConfigurationProvider().getBorderThickness());
			graphics.setStroke(stroke);
		}

		Line2D line1 = new Line2D.Double(0, 0, 0, KaptchaCommon
				.getConfigurationProvider().getWidth());
		graphics.draw(line1);
		Line2D line2 = new Line2D.Double(0, 0, KaptchaCommon
				.getConfigurationProvider().getWidth(), 0);
		graphics.draw(line2);
		line2 = new Line2D.Double(0, KaptchaCommon.getConfigurationProvider()
				.getHeight() - 1, KaptchaCommon.getConfigurationProvider()
				.getWidth(), KaptchaCommon.getConfigurationProvider()
				.getHeight() - 1);
		graphics.draw(line2);
		line2 = new Line2D.Double(KaptchaCommon.getConfigurationProvider()
				.getWidth() - 1, KaptchaCommon.getConfigurationProvider()
				.getHeight() - 1, KaptchaCommon.getConfigurationProvider()
				.getWidth() - 1, 0);
		graphics.draw(line2);
	}
}
