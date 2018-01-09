package org.student.dao.impl;

import org.aten.beans.ann.Component;
import org.aten.db.helper.handler.BeanHandler;
import org.aten.db.helper.handler.BeanListHandler;
import org.student.dao.BeanDao;
import org.student.dao.PublicDao;
import org.student.dto.StudentDto;

import java.util.List;

@Component
public class StudentDtoDao extends PublicDao implements BeanDao<StudentDto>{

    @Override
    public StudentDto query(StudentDto studentDto) {
        String sql = "SELECT * FROM PerStu S " +
                "JOIN PerSubject SI ON S.SUB_ID=SI.SUB_ID " +
                "JOIN PerClass C ON S.CLASS_ID=C.CLASS_ID WHERE S.STU_ID=?";
        return getCurrentSqlExecutor()
                .executeQuery(sql,new BeanHandler<>(StudentDto.class),studentDto.getStuId());
    }

    @Override
    public List<StudentDto> queryList() {
        String sql = "SELECT * FROM PerStu S " +
                "JOIN PerSubject SI ON S.SUB_ID=SI.SUB_ID " +
                "JOIN PerClass C ON S.CLASS_ID=C.CLASS_ID;";
        return getCurrentSqlExecutor().executeQuery(sql, new BeanListHandler<>(StudentDto.class));
    }


}
