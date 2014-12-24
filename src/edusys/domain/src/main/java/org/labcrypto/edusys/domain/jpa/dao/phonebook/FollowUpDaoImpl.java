package org.labcrypto.edusys.domain.jpa.dao.phonebook;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.phonebook.FollowUp;

import java.util.List;

public class FollowUpDaoImpl extends JpaEntityDao<FollowUp> implements FollowUpDao {

    public FollowUpDaoImpl() {
        super(FollowUp.class);
    }

    @Override
    public List<FollowUp> getFollowUpsByPhoneEntry(Long phoneEntryId) {
        return entityManager.createQuery(
                "from FollowUp as f where f.phoneEntry.id = :phoneEntryId", FollowUp.class)
                .setParameter("phoneEntryId", phoneEntryId)
                .getResultList();
    }
}
