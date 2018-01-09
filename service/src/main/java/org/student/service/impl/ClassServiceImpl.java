package org.student.service.impl;

import org.aten.beans.ann.Component;
import org.aten.beans.ann.Injected;
import org.aten.mvc.exception.ActionException;
import org.student.dao.impl.ClassDao;
import org.student.exception.ClassException;
import org.student.model.Clazz;
import org.student.service.BasicService;
import org.student.service.BeanQueryService;

import java.util.List;

@Component("classService")
public class ClassServiceImpl implements BasicService<Clazz>, BeanQueryService<Clazz> {

    @Injected("classDao")
    private ClassDao dao;

    @Override
    public void add(Clazz clazz) throws ActionException {
        try {
            dao.add(clazz);
        } catch (Exception e) {
            throw new ClassException("add class fail.",500);
        }
    }

    @Override
    public void update(Clazz clazz) throws ActionException {
        try {
            dao.update(clazz);
        } catch (Exception e) {
            throw new ClassException("update class fail.",500);
        }
    }

    @Override
    public void del(Clazz clazz) throws ActionException {
        try {
            dao.del(clazz);
        } catch (Exception e) {
            throw new ClassException("delete class fail.",500);
        }
    }

    @Override
    public List<Clazz> getBeanList() {
        return dao.queryList();
    }

    @Override
    public Clazz find(Clazz clazz) {
        return null;
    }
}
