package com.mftvanak.web.portal.web.kaptcha;

/**
 * {@link ConfigurationException} is used to indicate an error in configuration
 * properties.
 */
public class ConfigurationException extends RuntimeException
{
	private static final long serialVersionUID = 6937416954897707291L;

	public ConfigurationException(String paramName, String paramValue, Throwable cause)
	{
		super("Invalid value '" + paramValue + "' for config parameter '"
				+ paramName + "'.", cause);
	}

	public ConfigurationException(String paramName, String paramValue, String message)
	{
		super("Invalid value '" + paramValue + "' for config parameter '"
				+ paramName + "'. " + message);
	}
}
