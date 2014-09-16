package org.labcrypto.edusys.domain.jpa.dao.official;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.official.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
