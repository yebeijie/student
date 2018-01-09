package org.student.service.impl;

import org.aten.beans.ann.Component;
import org.aten.beans.ann.Injected;
import org.student.dao.impl.StudentDao;
import org.student.exception.LoginException;
import org.student.model.Student;
import org.student.service.LoginService;

@Component
public class UserLoginService implements LoginService<Student>{

    @Injected("studentDao")
    private StudentDao dao;

    @Override
    public Student login(Student student) throws LoginException {
        Student temp = dao.query(student);

        if(temp == null){
            throw new LoginException("不存在该用户",401);
        }else if(!temp.getPassWord().equals(student.getPassWord())){
            throw new LoginException("密码错误！",401);
        }
        return temp;
    }


}
