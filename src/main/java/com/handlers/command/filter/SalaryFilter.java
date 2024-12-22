package com.handlers.command.filter;

import com.handlers.command.domain.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SalaryFilter implements Filter<Employee> {

    @Override
    public Employee apply(Employee employee) {
        //Adding salary to the Employee
        //employee.setSalary(1000);
        log.info("Applying Salary filter");
        return employee;
    }
}
