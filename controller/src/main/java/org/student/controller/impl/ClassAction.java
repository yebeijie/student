package org.student.controller.impl;

import org.aten.beans.ann.Component;
import org.aten.beans.ann.Injected;
import org.aten.beans.ann.Scope;
import org.aten.mvc.ann.RequestMapping;
import org.aten.mvc.exception.ActionException;
import org.aten.mvc.view.ViewResult;
import org.aten.mvc.view.impl.JsonResult;
import org.student.controller.BasicAction;
import org.student.model.Clazz;
import org.student.service.BasicService;
import org.student.service.BeanQueryService;

import java.util.List;


@Component
@Scope("prototype")
@RequestMapping("/class")
public class ClassAction extends BasicAction {

    /**
     * 基本服务
     */
    @Injected("classService")
    private BasicService<Clazz> service;

    /**
     * 实体查询服务
     */
    @Injected("classService")
    private BeanQueryService<Clazz> queryService;

    @RequestMapping("/add")
    public ViewResult add(Clazz clazz){

        try {
            service.add(clazz);
        } catch (ActionException e) {
            return new JsonResult(errorResult(e.getMessage() , e.getResponseStatus()));
        }

        return new JsonResult(successResult("添加成功!"));
    }

    @RequestMapping("/list")
    public ViewResult list(){
        List<Clazz> list = queryService.getBeanList();
        return new JsonResult(successResult(list));
    }

}
