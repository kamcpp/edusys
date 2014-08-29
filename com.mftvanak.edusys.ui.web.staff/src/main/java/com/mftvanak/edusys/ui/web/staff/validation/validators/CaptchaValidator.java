package com.mftvanak.edusys.ui.web.staff.validation.validators;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.ui.web.staff.validation.constraints.Captcha;

public class CaptchaValidator implements ConstraintValidator<Captcha, String> {

	@Autowired(required = true)
	private HttpServletRequest request;

	private String message;
	private String sessionKey;

	@Override
	public void initialize(Captcha captcha) {
		message = captcha.message();
		sessionKey = captcha.sessionKey();
	}

	@Override
	public boolean isValid(String captcha, ConstraintValidatorContext context) {
		try {
			boolean matches = false;
			if (captcha == null || (captcha != null && captcha.equals(""))) {
				matches = true;
			}
			if (!matches) {
				String sessionCaptcha = (String) request.getSession()
						.getAttribute(sessionKey);
				if (sessionCaptcha != null) {
					matches = captcha.equals(sessionCaptcha);
				}
			}
			if (!matches) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(message)
						.addConstraintViolation();
			}
			return matches;
		} catch (final Exception ignore) {
		}
		return true;
	}
}
