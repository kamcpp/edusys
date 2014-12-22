package org.labcrypto.edusys.domain.mongo.dao;

import org.labcrypto.edusys.domain.mongo.entity.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
}
