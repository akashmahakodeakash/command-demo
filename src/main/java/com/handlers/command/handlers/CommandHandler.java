package com.handlers.command.handlers;

import com.handlers.command.commands.Command;
import com.handlers.command.domain.Employee;

public interface CommandHandler<T extends Command> {

    String commandName();

    Employee handle(T command, Employee employee);
}
