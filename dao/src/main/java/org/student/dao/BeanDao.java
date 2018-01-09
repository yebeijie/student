package org.student.dao;

import java.util.List;

public interface BeanDao<T> {

    T query(T t);

    List<T> queryList();
}
