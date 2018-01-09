package org.student.dao.impl;

import org.aten.beans.ann.Component;
import org.aten.db.helper.handler.BeanHandler;
import org.aten.db.helper.handler.BeanListHandler;
import org.student.dao.BasicDao;
import org.student.dao.BeanDao;
import org.student.dao.PublicDao;
import org.student.model.Subject;

import java.util.List;

@Component("subjectDao")
public class SubjectDao extends PublicDao implements BasicDao<Subject> , BeanDao<Subject>{
    @Override
    public void add(Subject subject) {
        getCurrentSqlExecutor()
                .executeUpdate("INSERT INTO PerSubject(SUBJECT_NAME) VALUES(?)",
                        subject.getSubjectName());
    }

    @Override
    public void del(Subject subject) {
        getCurrentSqlExecutor()
                .executeUpdate("DELETE FROM PerSubject WHERE SUB_ID=?",subject.getSubId());
    }

    @Override
    public void update(Subject subject) {
        getCurrentSqlExecutor()
                .executeUpdate("UPDATE PerSubject SET SUBJECT_NAME=? WHERE SUB_ID=?",
                        subject.getSubjectName(),subject.getSubId());
    }

    @Override
    public Subject query(Subject subject) {
        return getCurrentSqlExecutor()
                .executeQuery("SELECT * FROM PerSubject WHERE SUB_ID=?",
                        new BeanHandler<>(Subject.class),subject.getSubId());
    }

    @Override
    public List<Subject> queryList() {
        return getCurrentSqlExecutor()
                .executeQuery("SELECT * FROM PerSubject",
                        new BeanListHandler<>(Subject.class));
    }

}
