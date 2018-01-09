package org.student.exception;

import org.aten.mvc.exception.ActionException;

public class ClassException extends ActionException{
    public ClassException(String exception, int responseStatus) {
        super(exception, responseStatus);
    }
}
