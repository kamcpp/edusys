package org.labcrypto.edusys.domain.jpa.dao.official;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.official.Employee;

public interface EmployeeDao extends EntityDao<Employee> {

    Employee getEmployeeByEmployeeNumber(String employeeNumber);
}
