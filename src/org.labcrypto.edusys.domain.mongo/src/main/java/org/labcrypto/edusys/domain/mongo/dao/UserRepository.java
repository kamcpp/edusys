package org.labcrypto.edusys.domain.mongo.dao;

import org.labcrypto.edusys.domain.mongo.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
