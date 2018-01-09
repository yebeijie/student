package org.student.dao.impl;

import org.aten.beans.ann.Component;
import org.aten.db.helper.handler.BeanHandler;
import org.aten.db.helper.handler.BeanListHandler;
import org.student.dao.BasicDao;
import org.student.dao.BeanDao;
import org.student.dao.PublicDao;
import org.student.model.Student;

import java.util.List;

@Component("studentDao")
public class StudentDao extends PublicDao implements BasicDao<Student>,BeanDao<Student> {

    @Override
    public void add(Student student) {
        getCurrentSqlExecutor()
                .executeUpdate("INSERT INTO PerStu(STU_NAME , AGE , CLASS_ID ,SUB_ID,ACCOUNT, PASS_WORD) VALUES(?,?,?,?,?,?)",
                        student.getStuName(), student.getAge(), student.getClassId(),student.getSubId(), student.getAccount(),student.getPassWord());
    }

    @Override
    public void del(Student student) {
        getCurrentSqlExecutor()
                .executeUpdate("DELETE FROM PerStu WHERE STU_ID=?",
                        student.getStuId());
    }

    @Override
    public void update(Student student) {
        getCurrentSqlExecutor()
                .executeUpdate("UPDATE Stu SET PerStu_NAME=?,AGE=?,CLASS_ID=? , PASS_WORD=? WHERE STU_ID=?",
                        student.getStuName(), student.getAge(), student.getClassId(), student.getPassWord(), student.getStuId());
    }

    @Override
    public Student query(Student student) {
        return getCurrentSqlExecutor()
                .executeQuery("SELECT * FROM PerStu WHERE ACCOUNT=?"
                        , new BeanHandler<>(Student.class), student.getAccount());
    }

    @Override
    public List<Student> queryList() {
        return getCurrentSqlExecutor()
                .executeQuery("SELECT * FROM PerStu",
                        new BeanListHandler<>(Student.class));
    }


}
