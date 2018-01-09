package org.student.service;

import java.util.List;

public interface BeanQueryService<T> {

    T find(T t);

    List<T> getBeanList();
}
