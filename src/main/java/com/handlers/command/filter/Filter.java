package com.handlers.command.filter;

public interface Filter<T> {

    T apply(T data);

}
