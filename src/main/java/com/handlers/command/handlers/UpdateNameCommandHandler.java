package com.handlers.command.handlers;

import com.handlers.command.commands.UpdateNameCommand;
import com.handlers.command.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateNameCommandHandler implements CommandHandler<UpdateNameCommand> {
    @Override
    public String commandName() {
        return UpdateNameCommand.class.getName();
    }

    @Override
    public Employee handle(UpdateNameCommand command, Employee employee) {
        log.info("Handling \"{}\"", command.getCommandName());
        return null;
    }
}
