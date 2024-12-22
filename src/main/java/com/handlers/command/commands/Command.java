package com.handlers.command.commands;

public interface Command {

    Integer getEmployeeId();

    default String getCommandName(){
        return this.getClass().getName();
    }
}
