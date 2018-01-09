package org.student.service.impl;

import org.aten.beans.ann.Component;
import org.aten.beans.ann.Injected;
import org.aten.mvc.exception.ActionException;
import org.student.dao.impl.StudentDao;
import org.student.exception.StudentException;
import org.student.model.Student;
import org.student.service.BasicService;
import org.student.service.BeanQueryService;

import java.util.List;

@Component("studentService")
public class StudentServiceImpl implements BasicService<Student>, BeanQueryService<Student>{

    @Injected("studentDao")
    private StudentDao dao;

    @Override
    public Student find(Student student) {
        return dao.query(student);
    }

    @Override
    public List<Student> getBeanList() {
        return dao.queryList();
    }

    @Override
    public void add(Student student) throws ActionException {
        try {
            dao.add(student);
        } catch (Exception e) {
            throw new StudentException("add student fail.",500);
        }
    }

    @Override
    public void update(Student student) throws ActionException {
        try {
            dao.update(student);
        } catch (Exception e) {
            throw new StudentException("update student fail.",500);
        }
    }

    @Override
    public void del(Student student) throws ActionException {
        try {
            dao.del(student);
        } catch (Exception e) {
            throw new StudentException("delete student fail.",500);
        }
    }

}
