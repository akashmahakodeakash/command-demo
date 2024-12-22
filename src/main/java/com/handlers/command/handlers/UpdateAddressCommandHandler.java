package com.handlers.command.handlers;

import com.handlers.command.commands.UpdateAddressCommand;
import com.handlers.command.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateAddressCommandHandler implements CommandHandler<UpdateAddressCommand> {
    @Override
    public String commandName() {
        return UpdateAddressCommand.class.getName();
    }

    @Override
    public Employee handle(UpdateAddressCommand command, Employee employee) {
        log.info("Handling \"{}\"", command.getCommandName());
        return null;
    }
}
