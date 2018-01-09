package org.student.exception;

import org.aten.mvc.exception.ActionException;

public class StudentException extends ActionException{
    public StudentException(String exception, int responseStatus) {
        super(exception, responseStatus);
    }
}
