package com.handlers.command.commands;

import com.handlers.command.domain.Employee;
import com.handlers.command.handlers.CommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class CommandProcessor  implements InitializingBean, ApplicationContextAware {

    private ApplicationContext context;

    private Map<String, CommandHandler<? extends Command>> commandMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, CommandHandler> handlerBeans = context.getBeansOfType(CommandHandler.class);
        for(CommandHandler<? extends Command> handler: handlerBeans.values()){
            if(commandMap.get(handler.commandName()) != null){
                throw new Exception("CommandHandler already present");
            }
            commandMap.put(handler.commandName(), handler);
            log.info("{} is handled by {}", handler.commandName(), handler.getClass().getName());
        }

        log.info("Command map with its handler created successfully");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public Employee processCommand(Command command){
        // common steps required for all commands
        // E.g. load from DB, enhance the data
        Employee employee = new Employee();
        log.info("Enhancing data");
        //Get the handler for the command
        CommandHandler handler = commandMap.get(command.getCommandName());
        Employee handle = handler.handle(command, employee);
        //common steps  like saving the employee
        // saveEmployee() after command processing
        log.info("Finished procesing {}", command.getCommandName());

        return employee;
    }
}
