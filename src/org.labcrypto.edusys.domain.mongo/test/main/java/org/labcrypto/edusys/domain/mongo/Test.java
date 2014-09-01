package org.labcrypto.edusys.domain.mongo;

import org.bson.types.ObjectId;
import org.labcrypto.edusys.domain.mongo.dao.InstituteRepository;
import org.labcrypto.edusys.domain.mongo.entity.Institute;
import org.labcrypto.edusys.domain.mongo.entity.Institute.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring-beans.xml");
		InstituteRepository instituteRepository = applicationContext
				.getBean(InstituteRepository.class);
		Institute institute = new Institute();
		instituteRepository.save(institute);

		Department dept = new Department();
		dept.setId(ObjectId.get());
		dept.setEnglishName("fff");

		institute.getDepartments().add(dept);
		instituteRepository.save(institute);

		System.out.println("Done.");
	}
}
