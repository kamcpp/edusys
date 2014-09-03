package org.labcrypto.edusys.domain.mongo.dao;

import org.labcrypto.edusys.domain.mongo.entity.Token;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TokenRepository extends
		PagingAndSortingRepository<Token, Long> {

}
