package com.shiro.demo;

import com.shiro.pojo.Permission;
import com.shiro.pojo.Role;
import com.shiro.pojo.User;
import com.shiro.service.*;
import com.shiro.utils.JdbcTemplateUitls;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Before;

/**
 * @ClassName: PublicDemo
 * @author:zhouzhu
 * @Date: 2018/7/10 10:59
 * @Version: V1.0
 */
public class PublicDemo {

    protected PermissionService permissionService=new PermissionServiceImpl();
    protected RoleService roleService=new RoleServiceImpl();
    protected UserService userService=new UserServiceImpl();

    protected String passwrod="123";

    protected Permission p1;
    protected Permission p2;
    protected Permission p3;

    protected Role r1;
    protected Role r2;
    protected Role r3;

    protected User u1;
    protected User u2;
    protected User u3;
    protected User u4;

    @Before
    public void setUp(){
        JdbcTemplateUitls.jdbcTemplate().update("DELETE FROM sys_users");
        JdbcTemplateUitls.jdbcTemplate().update("DELETE FROM sys_roles");
        JdbcTemplateUitls.jdbcTemplate().update("DELETE FROM sys_permissions");
        JdbcTemplateUitls.jdbcTemplate().update("DELETE FROM sys_users_roles");
        JdbcTemplateUitls.jdbcTemplate().update("DELETE FROM sys_roles_permissions");

        //1.新增权限
        p1=new Permission("user:create","用户模块新增",Boolean.TRUE);
        p2=new Permission("user:update","用户模块修改",Boolean.TRUE);
        p3=new Permission("menu:create","菜单模块新增",Boolean.TRUE);

        permissionService.createPermission(p1);
        permissionService.createPermission(p2);
        permissionService.createPermission(p3);

        //2.新增角色
        r1=new Role("admin","管理员",Boolean.TRUE);
        r2=new Role("user","用户管理员",Boolean.TRUE);
        roleService.createRole(r1);
        roleService.createRole(r2);

        //3.关联角色-权限
        roleService.correlationPermissions(r1.getId(),p1.getId());
        roleService.correlationPermissions(r1.getId(),p2.getId());
        roleService.correlationPermissions(r1.getId(),p3.getId());

        roleService.correlationPermissions(r2.getId(),p1.getId());
        roleService.correlationPermissions(r2.getId(),p2.getId());

        //4.新增用户
        u1=new User("zhang",passwrod);
        u2=new User("li",passwrod);
        u3=new User("wu",passwrod);
        u4=new User("wang",passwrod);
        u2.setLocked(Boolean.FALSE);
        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);
        userService.createUser(u4);
        //5.关联用户-角色
        userService.correlationRoles(u1.getId(), r1.getId());
    }

    @After
    public void tearDown() throws Exception{
        //退出时请解除绑定Subject到线程 否则对下次测试造成影响
        ThreadContext.unbindSubject();
    }


    public void login(String configFile,String username,String password){
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory=new IniSecurityManagerFactory(configFile);
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        subject.login(token);
    }
    public Subject subject(){
        return SecurityUtils.getSubject();
    }
}
