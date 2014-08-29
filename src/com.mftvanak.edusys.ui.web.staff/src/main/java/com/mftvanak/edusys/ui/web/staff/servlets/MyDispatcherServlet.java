package com.mftvanak.edusys.ui.web.staff.servlets;

import java.util.Enumeration;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.springframework.web.servlet.DispatcherServlet;

import com.mftvanak.edusys.ui.web.staff.kaptcha.KaptchaCommon;
import com.mftvanak.edusys.ui.web.staff.kaptcha.KaptchaMutableConfigurationProvider;
import com.mftvanak.edusys.ui.web.staff.kaptcha.PropertiesMutableConfigurationProvider;

public class MyDispatcherServlet extends DispatcherServlet {

	private static final long serialVersionUID = -725224028210308L;

	private Properties properties = new Properties();

	@Override
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);

		ImageIO.setUseCache(false);

		Enumeration<?> initParams = conf.getInitParameterNames();
		while (initParams.hasMoreElements()) {
			String key = (String) initParams.nextElement();
			String value = conf.getInitParameter(key);
			this.properties.put(key, value);
		}

		KaptchaMutableConfigurationProvider kaptchaMutableconfigurationProvider = new PropertiesMutableConfigurationProvider(
				properties);
		kaptchaMutableconfigurationProvider.init();
		kaptchaMutableconfigurationProvider.setBorderDrawn(false);
		KaptchaCommon
				.setConfigurationProvider(kaptchaMutableconfigurationProvider);
	}
}
