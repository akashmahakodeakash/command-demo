package com.handlers.command.commands;

import lombok.Data;

@Data
public class UpdateNameCommand implements Command {
    private Integer employeeId;

    @Override
    public Integer getEmployeeId() {
        return this.employeeId;
    }
}
