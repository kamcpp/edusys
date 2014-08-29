package com.mftvanak.edusys.ui.web.staff.kaptcha;

public class KaptchaCommon {
	private static KaptchaMutableConfigurationProvider configurationProvider;

	public static KaptchaMutableConfigurationProvider getConfigurationProvider() {
		return configurationProvider;
	}

	public static void setConfigurationProvider(
			KaptchaMutableConfigurationProvider configurationProvider) {
		KaptchaCommon.configurationProvider = configurationProvider;
	}
}
