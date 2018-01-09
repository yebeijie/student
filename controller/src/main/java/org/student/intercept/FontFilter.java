package org.student.intercept;


import org.aten.mvc.ActionContext;
import org.aten.mvc.ann.Intervention;

import org.aten.mvc.execution.HandlerExecutionChain;
import org.aten.mvc.interceptor.Filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Intervention("/")
public class FontFilter extends Filter{

    @Override
    protected Object doFilter(HandlerExecutionChain chain) {
        HttpServletRequest request = ActionContext.getContext().getRequest();
        HttpServletResponse response = ActionContext.getContext().getResponse();
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return chain.doFilter();
    }


}
