package com.handlers.command.filter;

import com.handlers.command.domain.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PhoneFilter implements Filter<Employee> {

    @Override
    public Employee apply(Employee employee) {
        log.info("Applying Phone filter");
        //Adding phone number to employee
        //employee.setPhone("1234");
        return employee;
    }
}
