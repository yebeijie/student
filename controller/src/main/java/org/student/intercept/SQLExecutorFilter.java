package org.student.intercept;

import org.aten.mvc.ann.Intervention;
import org.aten.mvc.execution.HandlerExecutionChain;
import org.aten.mvc.interceptor.Filter;
import org.student.dao.SQLExecutorContext;

@Intervention("/")
public class SQLExecutorFilter extends Filter{

    @Override
    protected Object doFilter(HandlerExecutionChain chain) {
        return chain.doFilter();
    }

    @Override
    protected void after() {
        //每一个请求结束后移除SQLExecutor的本地线程副本
        SQLExecutorContext.remove();
    }
}
