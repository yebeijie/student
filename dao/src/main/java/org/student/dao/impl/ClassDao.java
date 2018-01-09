package org.student.dao.impl;

import org.aten.beans.ann.Component;
import org.aten.db.helper.ResultSetHandler;
import org.aten.db.helper.SQLExecutor;
import org.aten.db.helper.handler.BeanHandler;
import org.aten.db.helper.handler.BeanListHandler;
import org.aten.db.tool.impl.MySqlTableBuilder;
import org.student.dao.BasicDao;
import org.student.dao.BeanDao;
import org.student.dao.PublicDao;
import org.student.model.Clazz;

import java.util.List;


@Component("classDao")
public class ClassDao extends PublicDao implements BasicDao<Clazz> , BeanDao<Clazz>{
    @Override
    public void add(Clazz clazz) {
        String sql = "INSERT INTO PerClass(CLASS_NAME) VALUES(?) ";
        SQLExecutor se = getCurrentSqlExecutor();
        se.executeUpdate(sql , clazz.getClassName());
    }

    @Override
    public void del(Clazz clazz) {
        String sql = "DELETE FROM PerClass WHERE CLASS_ID=?";
        SQLExecutor se = getCurrentSqlExecutor();
        se.executeUpdate(sql , clazz.getClassId());
    }

    @Override
    public void update(Clazz clazz) {
        String sql = "UPDATE PerClass SET CLASS_NAME=? WHERE CLASS_ID=?";
        SQLExecutor se = getCurrentSqlExecutor();
        se.executeUpdate(sql , clazz.getClassName() , clazz.getClassId());
    }

    @Override
    public Clazz query(Clazz clazz) {
        String sql = "SELECT * FROM PerClass WHERE CLASS_ID=?";
        SQLExecutor se = getCurrentSqlExecutor();
        ResultSetHandler<Clazz> handler = new BeanHandler<>(Clazz.class);
        return se.executeQuery(sql , handler ,clazz.getClassId());
    }

    @Override
    public List<Clazz> queryList() {
        String sql = "SELECT * FROM CLASS_INFO";
        SQLExecutor se = getCurrentSqlExecutor();
        ResultSetHandler<List<Clazz>> handler = new BeanListHandler<>(Clazz.class);
        return se.executeQuery(sql , handler);
    }

    public void createTable(Class<?> clazz) {
        String sql = new MySqlTableBuilder().getCreateTableStatement(clazz);
        SQLExecutor se = getCurrentSqlExecutor();
        se.executeUpdate(sql);
    }
}


