package org.student.intercept;

import org.aten.mvc.ActionContext;
import org.aten.mvc.ann.Intervention;

import org.aten.mvc.execution.HandlerExecutionChain;
import org.aten.mvc.interceptor.Filter;

@Intervention("/home.html")
public class LoginFilter extends Filter{
    @Override
    protected Object doFilter(HandlerExecutionChain chain) {
        Object student = ActionContext.getContext().getSession().get("student");

        if(student == null) return "你还没有登录";

        return chain.doFilter();
    }

}
