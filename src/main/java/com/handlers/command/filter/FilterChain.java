package com.handlers.command.filter;

import com.handlers.command.domain.Employee;

import java.util.Collections;
import java.util.List;

public class FilterChain {

    private List<Filter<Employee>> filters;

    public FilterChain(List<Filter<Employee>> filtersList){
        if(filtersList == null){
            filtersList = Collections.emptyList();
        }
        this.filters = filtersList;
    }

    public Employee applyFilter(Employee employee){

        for(Filter<Employee> filter : filters){
            filter.apply(employee);
        }

        return employee;
    }


}
