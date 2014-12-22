package org.labcrypto.edusys.domain.pg.dao.official;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.official.Employee;


public class EmployeeDao extends EntityDao < Employee > {

  public EmployeeDao () {
    super (Employee.class);
  }

  public Employee getEmployeeByEmployeeNumber (String employeeNumber) {
    String query = "from Employee as e where e.employeeNumber = :employeeNumber";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("employeeNumber", employeeNumber);
    List < Employee > employees = executeQueryAsList (query, params, 0);
    if (employees.size () != 1) {
      return null;
    } else {
      return employees.get (0);
    }
  }
}
