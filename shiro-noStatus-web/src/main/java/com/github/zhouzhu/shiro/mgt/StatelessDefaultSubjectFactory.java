package com.github.zhouzhu.shiro.mgt;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * @ClassName: StatelessDefaultSubjectFactory
 * @author:zhouzhu
 * @Date: 2018/8/13 16:10
 * @Version: V1.0
 */
public class StatelessDefaultSubjectFactory  extends DefaultWebSubjectFactory{
    @Override
    public Subject createSubject(SubjectContext context) {
        //不创建session，如果之后调用 Subject.getSession() 将抛出 DisabledSessionException 异常
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}
