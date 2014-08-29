package com.mftvanak.web.portal.web.kaptcha.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.mftvanak.web.portal.web.kaptcha.KaptchaCommon;
import com.mftvanak.web.portal.web.kaptcha.WordRenderer;


public class DefaultWordRenderer implements WordRenderer {

	@Override
	public BufferedImage renderWord(String word, int width, int height) {
		int fontSize = KaptchaCommon.getConfigurationProvider()
				.getTextProducerFontSize();
		Font[] fonts = KaptchaCommon.getConfigurationProvider()
				.getTextProducerFonts(fontSize);
		Color color = KaptchaCommon.getConfigurationProvider()
				.getTextProducerFontColor();
		int charSpace = KaptchaCommon.getConfigurationProvider()
				.getTextProducerCharSpace();

		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2D = image.createGraphics();
		g2D.setColor(color);

		RenderingHints hints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		hints.add(new RenderingHints(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY));
		g2D.setRenderingHints(hints);

		FontRenderContext frc = g2D.getFontRenderContext();
		Random random = new Random();

		int startPosY = (height - fontSize) / 5 + fontSize;

		char[] wordChars = word.toCharArray();
		Font[] chosenFonts = new Font[wordChars.length];
		int[] charWidths = new int[wordChars.length];
		int widthNeeded = 0;
		for (int i = 0; i < wordChars.length; i++) {
			chosenFonts[i] = fonts[random.nextInt(fonts.length)];

			char[] charToDraw = new char[] { wordChars[i] };
			GlyphVector gv = chosenFonts[i].createGlyphVector(frc, charToDraw);
			charWidths[i] = (int) gv.getVisualBounds().getWidth();
			if (i > 0) {
				widthNeeded = widthNeeded + 2;
			}
			widthNeeded = widthNeeded + charWidths[i];
		}

		int startPosX = (width - widthNeeded) / 2;
		for (int i = 0; i < wordChars.length; i++) {
			g2D.setFont(chosenFonts[i]);
			char[] charToDraw = new char[] { wordChars[i] };
			g2D.drawChars(charToDraw, 0, charToDraw.length, startPosX,
					startPosY);
			startPosX = startPosX + (int) charWidths[i] + charSpace;
		}

		return image;
	}
}
