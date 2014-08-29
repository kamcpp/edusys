package com.mftvanak.edusys.domain.dao.education;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mftvanak.edusys.domain.dao.EntityDao;
import com.mftvanak.edusys.domain.entity.education.Department;


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
