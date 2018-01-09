package org.student.exception;

import org.aten.mvc.exception.ActionException;

public class LoginException extends ActionException{
    public LoginException(String exception, int responseStatus) {
        super(exception, responseStatus);
    }
}
