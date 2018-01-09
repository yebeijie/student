package org.student.controller.impl;

import org.aten.beans.ann.Component;
import org.aten.beans.ann.Injected;
import org.aten.beans.ann.Scope;
import org.aten.mvc.ann.RequestMapping;
import org.aten.mvc.exception.ActionException;
import org.aten.mvc.view.ViewResult;
import org.aten.mvc.view.impl.JsonResult;
import org.student.controller.BasicAction;
import org.student.model.Subject;
import org.student.service.BasicService;
import org.student.service.BeanQueryService;

import java.util.List;


@Component
@Scope("prototype")
@RequestMapping("/subject")
public class SubjectAction extends BasicAction {

    /**
     * 基本服务
     */
    @Injected("subjectService")
    private BasicService service;

    /**
     * 实体查询服务
     */
    @Injected("subjectService")
    private BeanQueryService<Subject> queryService;

    @RequestMapping("/add")
    public ViewResult add(Subject subject){
        try {
            service.add(subject);
        } catch (ActionException e) {
            return new JsonResult(errorResult(e.getMessage() , e.getResponseStatus()));
        }
        return new JsonResult(successResult("添加成功!"));
    }


    @RequestMapping("/list")
    public ViewResult list(){
        List<Subject> subjects = queryService.getBeanList();
        return new JsonResult(successResult(subjects));
    }
}
