package com.mftvanak.edusys.ui.web.staff.validation.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.mftvanak.edusys.ui.web.staff.validation.validators.UniqueValidator;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
@Documented
public @interface Unique {

	String message() default "{constraints.unique}";

	String databaseSchema() default "{database.schema}";

	String databaseTable() default "{database.table}";

	String databaseColumn() default "{database.column}";

	UniquenessSource source() default UniquenessSource.None;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
