package org.student.controller.impl;

import org.aten.beans.ann.Component;
import org.aten.beans.ann.Injected;
import org.aten.beans.ann.Scope;
import org.aten.mvc.ActionContext;
import org.aten.mvc.ann.RequestMapping;
import org.aten.mvc.exception.ActionException;
import org.aten.mvc.view.ViewResult;
import org.aten.mvc.view.impl.JsonResult;
import org.aten.mvc.view.impl.RedirectResult;
import org.student.controller.BasicAction;
import org.student.model.Student;
import org.student.service.LoginService;

@Component
@Scope("prototype")
public class LoginAction extends BasicAction {

    /**
     * 登录服务
     */
    @Injected("userLoginService")
    private LoginService<Student> loginService;

    @RequestMapping("/login")
    public ViewResult login(Student student){
        try {
            Student stu = loginService.login(student);
            ActionContext.getContext().getSession().put("student" ,stu);
        } catch (ActionException e) {
            return new JsonResult(errorResult(e.getMessage() , e.getResponseStatus()));
        }
        return new RedirectResult("/home.html");
    }


    //



}
