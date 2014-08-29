package com.mftvanak.edusys.ui.web.staff.kaptcha;

import java.awt.Color;

public interface KaptchaMutableConfigurationProvider extends
		KaptchaConfigurationProvider {

	void setBorderDrawn(boolean isBorderDrawn);

	void setWidth(int width);

	void setHeight(int height);

	void setBorderThickness(int borderThickness);

	void setTextProducerCharLength(int textProducerCharLength);

	void setTextProducerFontSize(int textProducerFontSize);

	void setTextProducerCharSpace(int textProducerCharSpace);

	void setTextProducerCharString(char[] textProducerCharString);

	void setBorderColor(Color borderColor);

	void setBackgroundColorFrom(Color backgroundColorFrom);

	void setBackgroundColorTo(Color backgroundColorTo);

	void setNoiseColor(Color noiseColor);

	void setTextProducerFontColor(Color textProducerFontColor);

	void setWordRenderer(WordRenderer wordRenderer);

	void setGimpyEngine(GimpyEngine gimpyEngine);

	void setBackgroundProducer(BackgroundProducer backgroundProducer);

	void setTextProducer(TextProducer textProducer);

	void setNoiseProducer(NoiseProducer noiseProducer);
}
