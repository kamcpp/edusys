package org.labcrypto.edusys.domain.jpa.dao.official;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.official.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmployeeDaoImpl extends EntityDaoImpl< Employee > {

  public EmployeeDaoImpl() {
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
