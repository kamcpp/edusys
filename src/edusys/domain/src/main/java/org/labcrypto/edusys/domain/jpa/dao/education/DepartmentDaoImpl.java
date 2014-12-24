package org.labcrypto.edusys.domain.jpa.dao.education;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Department;

import java.util.List;

public class DepartmentDaoImpl extends JpaEntityDao<Department> implements DepartmentDao {

    public DepartmentDaoImpl() {
        super(Department.class);
    }

    @Override
    public List<Department> getDepartmentsByInstituteId(Long instituteId) {
        return entityManager.createQuery(
                "from Department as d where d.institute.id = :instituteId", Department.class)
                .setParameter("instituteId", instituteId).getResultList();
    }
}
