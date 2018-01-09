package org.student.dao;


public interface BasicDao<T> {

    void add(T t);

    void del(T t);

    void update(T t);

}
