package org.student.dao;

import org.aten.db.helper.SQLExecutor;
import org.student.util.DBConn;

public class SQLExecutorContext {

    private static final ThreadLocal<SQLExecutor> local = new ThreadLocal<>();


    public static SQLExecutor getCurrentSQLExecutor(){

        if(local.get() == null) local.set(new SQLExecutor(DBConn.getConnection()));

        return local.get();
    }

    public static void remove(){
        if(local.get() != null){
            local.remove();
        }
    }

}


