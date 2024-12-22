package com.handlers.command.handlers;

import com.handlers.command.commands.AddEmployeeCommand;
import com.handlers.command.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddEmployeeCommandHandler implements CommandHandler<AddEmployeeCommand> {
    @Override
    public String commandName() {
        return AddEmployeeCommand.class.getName();
    }

    @Override
    public Employee handle(AddEmployeeCommand command, Employee employee) {
        log.info("Handling \"{}\"", command.getCommandName());
        return null;
    }
}
