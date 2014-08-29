package org.labcrypto.edusys.domain.pg.dao.education;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.education.Department;


public class DepartmentDao extends EntityDao < Department > {

  public DepartmentDao () {
    super (Department.class);
  }

  public List < Department > getDepartmentsByInstituteId (Long instituteId) {
    String query = "from Department as d where d.institute.id = :instituteId";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("instituteId", instituteId);
    return executeQueryAsList (query, params, 0);
  }
}
