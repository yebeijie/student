package org.student.service;

import org.student.exception.LoginException;

public interface LoginService<T> {

    T login(T t) throws LoginException;

}
