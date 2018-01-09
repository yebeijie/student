package org.student.exception;

import org.aten.mvc.exception.ActionException;

public class SubjectException extends ActionException{
    public SubjectException(String exception, int responseStatus) {
        super(exception, responseStatus);
    }
}
