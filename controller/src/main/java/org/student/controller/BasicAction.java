package org.student.controller;

import org.student.dto.ValueDto;

public abstract class BasicAction {

    protected ValueDto successResult(Object value){
        ValueDto dto = new ValueDto();
        dto.setValue(value);
        return dto;
    }

    protected ValueDto errorResult(String message , int statusCode){
        ValueDto dto = new ValueDto();
        dto.setMessage(message);
        dto.setStatusCode(statusCode);
        return dto;
    }
}
