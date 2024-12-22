package com.handlers.command.domain;

import com.handlers.command.commands.AddEmployeeCommand;
import com.handlers.command.commands.CommandProcessor;
import com.handlers.command.commands.UpdateAddressCommand;
import com.handlers.command.commands.UpdateNameCommand;
import com.handlers.command.filter.Filter;
import com.handlers.command.filter.FilterChain;
import com.handlers.command.filter.PhoneFilter;
import com.handlers.command.filter.SalaryFilter;
import com.handlers.command.handlers.CommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class EmployeeService {

    private CommandProcessor processor;

    public EmployeeService(CommandProcessor commandProcessor){
        this.processor = commandProcessor;
    }

    public void addEmployee(AddEmployeeCommand command){
        Employee employee = processor.processCommand(command);
        filter(employee);
    }

    private void filter(Employee employee) {
        // Create filters
        PhoneFilter phoneFilter = new PhoneFilter();
        SalaryFilter salaryFilter = new SalaryFilter();

        // Create Filter Chain
        FilterChain filterChain = new FilterChain(Arrays.asList(phoneFilter, salaryFilter));
        log.info("Create FilterChain");
        log.info("Applying filter chain");
        filterChain.applyFilter(employee);
    }

    public void updateName(UpdateNameCommand command){
        processor.processCommand(command);
    }

    public void updateAddress(UpdateAddressCommand command){
        processor.processCommand(command);
    }
}
