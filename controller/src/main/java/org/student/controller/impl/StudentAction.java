package org.student.controller.impl;

import org.aten.beans.ann.Component;
import org.aten.beans.ann.Injected;
import org.aten.beans.ann.Scope;
import org.aten.mvc.ActionContext;
import org.aten.mvc.ann.RequestMapping;
import org.aten.mvc.exception.ActionException;
import org.aten.mvc.view.ViewResult;
import org.aten.mvc.view.impl.JsonResult;
import org.student.controller.BasicAction;
import org.student.dto.StudentDto;
import org.student.model.Student;
import org.student.service.BasicService;
import org.student.service.BeanQueryService;
import org.student.service.LoginService;

import java.util.List;

@Component
@Scope("prototype")
@RequestMapping("/student")
public class StudentAction extends BasicAction {

    /**
     * 基本服务
     */
    @Injected("studentService")
    private BasicService<Student> service;

    /**
     * 实体查询服务
     */
    @Injected("studentDtoService")
    private BeanQueryService<StudentDto> queryService;


    @RequestMapping("/add")
    public ViewResult add(Student student){
        try {
            System.out.println(student.getStuName());
            service.add(student);
        } catch (ActionException e) {
            return new JsonResult(errorResult(e.getMessage() , e.getResponseStatus()));
        }
        return new JsonResult(successResult("添加成功!"));
    }

    @RequestMapping("/list")
    public ViewResult list(){
        List<StudentDto> list = queryService.getBeanList();
        return new JsonResult(successResult(list));
    }




}
