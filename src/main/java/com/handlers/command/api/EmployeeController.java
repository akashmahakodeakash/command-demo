package com.handlers.command.api;

import com.handlers.command.api.domain.CreateEmployeeRequest;
import com.handlers.command.api.domain.UpdateAddressRequest;
import com.handlers.command.api.domain.UpdateNameRequest;
import com.handlers.command.commands.AddEmployeeCommand;
import com.handlers.command.commands.UpdateAddressCommand;
import com.handlers.command.commands.UpdateNameCommand;
import com.handlers.command.domain.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService service){
        this.employeeService = service;
    }
    @PostMapping("/create-employee")
    public void addEmployee(@RequestBody CreateEmployeeRequest request){
        employeeService.addEmployee(createAddEmployeeCommand(request));
    }

    @PostMapping("/update-address")
    public void updateAddress(@RequestBody UpdateAddressRequest request){
        employeeService.updateAddress(createUpdateAddressCommand(request));
    }

    @PostMapping("/update-name")
    public void updateName(@RequestBody UpdateNameRequest request){
        employeeService.updateName(createUpdateNameCommand(request));
    }

    private AddEmployeeCommand createAddEmployeeCommand(CreateEmployeeRequest request) {
        AddEmployeeCommand command = new AddEmployeeCommand();

        return command;
    }

    private UpdateAddressCommand createUpdateAddressCommand(UpdateAddressRequest request) {
        UpdateAddressCommand command = new UpdateAddressCommand();

        return command;
    }

    private UpdateNameCommand createUpdateNameCommand(UpdateNameRequest request) {
        UpdateNameCommand command = new UpdateNameCommand();
        return command;
    }
}
