package com.handlers.command.commands;

import lombok.Data;

@Data
public class AddEmployeeCommand implements Command {

    private Integer employeeId;

    @Override
    public Integer getEmployeeId() {
        return this.employeeId;
    }
}
