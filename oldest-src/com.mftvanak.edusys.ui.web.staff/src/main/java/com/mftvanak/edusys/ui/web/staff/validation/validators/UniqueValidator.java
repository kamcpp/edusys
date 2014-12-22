package com.mftvanak.edusys.ui.web.staff.validation.validators;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.mftvanak.edusys.ui.web.staff.validation.constraints.Unique;
import com.mftvanak.edusys.ui.web.staff.validation.constraints.UniquenessSource;


public class UniqueValidator implements ConstraintValidator<Unique, String> {

	@PersistenceContext
	private EntityManager entityManager;

	private String message;
	private String databaseSchema;
	private String databaseTable;
	private String databaseColumn;
	private UniquenessSource source;

	@Override
	public void initialize(final Unique unique) {
		this.message = unique.message();
		this.databaseSchema = unique.databaseSchema();
		this.databaseTable = unique.databaseTable();
		this.databaseColumn = unique.databaseColumn();
		this.source = unique.source();
	}

	@Override
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true)
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Logger logger = Logger.getLogger(UniqueValidator.class);
		try {
			boolean isUnique = false;
			if (value == null || (value != null && value.equals(""))) {
				isUnique = true;
			}
			if (!isUnique) {
				if (source == UniquenessSource.Database) {
					logger.debug("Uniqueness checking using database source: from "
							+ databaseSchema
							+ "."
							+ databaseTable
							+ "."
							+ databaseColumn);
					try {
						String queryString = "SELECT COUNT(*) FROM "
								+ databaseSchema + "." + databaseTable
								+ " t WHERE t." + databaseColumn + " = ?";
						Query query = entityManager.createNativeQuery(
								queryString).setParameter(1, value);
						List results = query.getResultList();
						Iterator iterator = results.iterator();
						BigInteger numberOfRows = BigInteger.valueOf(-1);
						while (iterator.hasNext()) {
							numberOfRows = (BigInteger) iterator.next();
							break;
						}
						isUnique = numberOfRows.longValue() == 0;
					} catch (Exception e) {
						e.printStackTrace();
						logger.error(e);
						isUnique = false;
					}
				}
			}
			if (!isUnique) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(message)
						.addConstraintViolation();
			}
			logger.debug("isUnique: " + isUnique);
			return isUnique;
		} catch (final Exception ignore) {
		}
		return true;
	}
}
