package org.student.service.impl;

import org.aten.beans.ann.Component;
import org.aten.beans.ann.Injected;
import org.student.dao.BeanDao;
import org.student.dto.StudentDto;
import org.student.service.BeanQueryService;

import java.util.List;

@Component
public class StudentDtoService implements BeanQueryService<StudentDto>{

    @Injected("studentDtoDao")
    private BeanDao<StudentDto> dao;

    @Override
    public StudentDto find(StudentDto studentDto) {
        return dao.query(studentDto);
    }

    @Override
    public List<StudentDto> getBeanList() {
        return dao.queryList();
    }
}
