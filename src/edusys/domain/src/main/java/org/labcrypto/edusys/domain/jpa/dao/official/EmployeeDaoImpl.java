package org.labcrypto.edusys.domain.jpa.dao.official;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.official.Employee;

public class EmployeeDaoImpl extends JpaEntityDao<Employee> {

    public EmployeeDaoImpl() {
        super(Employee.class);
    }

    public Employee getEmployeeByEmployeeNumber(String employeeNumber) {
        return entityManager.createQuery(
                "from Employee as e where e.employeeNumber = :employeeNumber", Employee.class)
                .setParameter("employeeNumber", employeeNumber)
                .getSingleResult();
    }
}
