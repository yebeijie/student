package org.student.service.impl;

import org.aten.beans.ann.Component;
import org.aten.beans.ann.Injected;
import org.aten.mvc.exception.ActionException;
import org.student.dao.impl.SubjectDao;
import org.student.exception.SubjectException;
import org.student.model.Subject;
import org.student.service.BasicService;
import org.student.service.BeanQueryService;

import java.util.List;

@Component("subjectService")
public class SubjectServiceImpl implements BasicService<Subject>,BeanQueryService<Subject>{

    @Injected("subjectDao")
    private SubjectDao dao;

    @Override
    public void add(Subject subject) throws ActionException {
        try {
            dao.add(subject);
        } catch (Exception e) {
            throw new SubjectException("add subject fail.",500);
        }
    }

    @Override
    public void update(Subject subject) throws ActionException {
        try {
            dao.update(subject);
        } catch (Exception e) {
            throw new SubjectException("update subject fail.",500);
        }
    }

    @Override
    public void del(Subject subject) throws ActionException {
        try {
            dao.del(subject);
        } catch (Exception e) {
            throw new SubjectException("delete subject fail.",500);
        }
    }

    @Override
    public List<Subject> getBeanList() {
        return dao.queryList();
    }

    @Override
    public Subject find(Subject subject) {
        return null;
    }
}
