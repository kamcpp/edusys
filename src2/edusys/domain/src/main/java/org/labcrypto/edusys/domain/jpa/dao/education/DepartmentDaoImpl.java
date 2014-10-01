package org.labcrypto.edusys.domain.jpa.dao.education;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.Department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DepartmentDaoImpl extends EntityDaoImpl<Department> {

  public DepartmentDaoImpl() {
    super (Department.class);
  }

  public List < Department > getDepartmentsByInstituteId (Long instituteId) {
    String query = "from Department as d where d.institute.id = :instituteId";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("instituteId", instituteId);
    return executeQueryAsList (query, params, 0);
  }
}
