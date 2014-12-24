package org.labcrypto.edusys.domain.jpa.dao.phonebook;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.phonebook.PhoneEntry;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PhoneEntryDaoImpl extends JpaEntityDao<PhoneEntry> implements PhoneEntryDao {

    public PhoneEntryDaoImpl() {
        super(PhoneEntry.class);
    }

    @Override
    public List<PhoneEntry> getPhoneEntriesByOwnerId(Long ownerId) {
        return getPhoneEntriesByOwnerId(ownerId, 0);
    }

    @Override
    public List<PhoneEntry> getPhoneEntriesByOwnerId(Long ownerId, int count) {
        return entityManager.createQuery(
                "from PhoneEntry as pe where pe.owner.id = :ownerId order by pe.submitDate desc", PhoneEntry.class)
                .setParameter("ownerId", ownerId)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public List<PhoneEntry> getPhoneEntriesByPredicate(PhoneEntrySearchPredicate predicate) {
        boolean whereClauseAdded = false;
        boolean firstConditionAdded = false;
        String query = "from PhoneEntry as pe";
        Map<String, Object> params = new HashMap<String, Object>();
        if (predicate.getDepartmentId() != null) {
            if (!whereClauseAdded) {
                query += " where";
                whereClauseAdded = true;
            }
            if (firstConditionAdded) {
                query += " and";
            } else {
                firstConditionAdded = true;
            }
            query += " pe.department.id = :departmentId";
            params.put("departmentId", predicate.getDepartmentId());
        }
        if (predicate.getSubmitDateStart() != null) {
            if (!whereClauseAdded) {
                query += " where";
                whereClauseAdded = true;
            }
            if (firstConditionAdded) {
                query += " and";
            } else {
                firstConditionAdded = true;
            }
            query += " pe.submitDate >= :submitDateStart";
            params.put("submitDateStart", predicate.getSubmitDateStart());
        }
        if (predicate.getSubmitDateEnd() != null) {
            if (!whereClauseAdded) {
                query += " where";
                whereClauseAdded = true;
            }
            if (firstConditionAdded) {
                query += " and";
            } else {
                firstConditionAdded = true;
            }
            query += " pe.submitDate <= :submitDateEnd";
            params.put("submitDateEnd", predicate.getSubmitDateEnd());
        }
        query += " order by pe.submitDate desc";

        TypedQuery<PhoneEntry> typedQuery = entityManager.createQuery(query, PhoneEntry.class);
        for (String key : params.keySet()) {
            typedQuery.setParameter(key, params.get(key));
        }
        return typedQuery.getResultList();
    }
}
