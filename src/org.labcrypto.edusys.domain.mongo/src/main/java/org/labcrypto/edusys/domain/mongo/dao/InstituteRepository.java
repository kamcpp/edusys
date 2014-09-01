package org.labcrypto.edusys.domain.mongo.dao;

import org.labcrypto.edusys.domain.mongo.entity.Institute;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InstituteRepository extends
		PagingAndSortingRepository<Institute, Long> {
}
