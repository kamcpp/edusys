package com.mftvanak.edusys.ui.web.staff.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.mftvanak.edusys.ui.web.staff.validation.constraints.FieldMatch;


public class FieldMatchValidator implements
		ConstraintValidator<FieldMatch, Object> {

	private String firstFieldName;
	private String secondFieldName;
	private String message;

	@Override
	public void initialize(final FieldMatch fieldMatch) {
		this.firstFieldName = fieldMatch.first();
		this.secondFieldName = fieldMatch.second();
		this.message = fieldMatch.message();
	}

	@Override
	public boolean isValid(final Object value,
			final ConstraintValidatorContext context) {
		try {
			final Object firstObj = BeanUtils
					.getProperty(value, firstFieldName);
			final Object secondObj = BeanUtils.getProperty(value,
					secondFieldName);

			boolean matches = (firstObj == null && secondObj == null)
					|| (firstObj != null && firstObj.equals(secondObj));

			if (!matches) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(message)
						.addNode(secondFieldName).addConstraintViolation();
			}
			return matches;
		} catch (final Exception ignore) {
		}
		return true;
	}
}
