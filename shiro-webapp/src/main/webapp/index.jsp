<%--
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="zhang" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="shirp" uri="http://shiro.apache.org/tags" %>
<html>
    <body>
        <shiro:guest>
            欢迎游客访问，<<a href="${pageContext.request.contextPath}/login.jsp">点击登录</a>
            <br/>
        </shiro:guest>
        <shiro:user>
            欢迎[<shiro:principal/>]登录，<<a href="${pageContext.request.contextPath}/logout">点击退出</a>
        </shiro:user>
        <shiro:authenticated>
            用户[<shiro:principal/>]已身份验证通过<br/>
        </shiro:authenticated>
        <shiro:notAuthenticated>
            未身份验证(包括记住我)<br/>
        </shiro:notAuthenticated>
        <shiro:hasRole name="admin">
            用户[<shiro:principal/>]拥有角色admin<br/>
        </shiro:hasRole>
        <shirp:hasRole name="admin,user">
            用户[<shiro:principal/>]拥有角色admin或user<br/>
        </shirp:hasRole>
        <shiro:lacksRole name="abc">
            用户[<shiro:principal/>]没有角色abc<br/>
        </shiro:lacksRole>
        <shiro:hasPermission name="user:create">
            用户[<shiro:principal/>]拥有权限user:create<br/>
        </shiro:hasPermission>
        <shiro:lacksPermission name="org:create">
            用户[<shiro:principal/>]没有权限org:create<br/>
        </shiro:lacksPermission>
        <zhang:hasAllRoles name="admin,user">
            用户[<shiro:principal/>]拥有角色admin和user<br/>
        </zhang:hasAllRoles>
        <zhang:hasAllPermissions name="user:create,user:update">
            用户[<shiro:principal/>]拥有权限user:create和user:update<br/>
        </zhang:hasAllPermissions>
        <zhang:hasAnyPermissions name="user:create,adb:update">
            用户[<shiro:principal/>]拥有权限user:create或abc:update<br/>
        </zhang:hasAnyPermissions>
    </body>
</html>
--%>

<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="com.shiroweb.session.OnlineSession" %>
<%@ page import="com.shiroweb.session.MySessionDAO " %>
<%@ page import="java.io.Serializable" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/login.jsp">点击登录</a><br/>
</shiro:guest>
<shiro:user>
    欢迎[<shiro:principal/>]登录，<a href="${pageContext.request.contextPath}/logout">点击退出</a><br/>
</shiro:user>

<shiro:user>
    <%
        SecurityUtils.getSubject().getSession().setAttribute("key", 123);
        System.out.println(SecurityUtils.getSubject().getSession().getAttribute("key"));
    %>
    <br/>
    <%
        MySessionDAO sessionDAO = new MySessionDAO();
        Serializable sessionId = SecurityUtils.getSubject().getSession().getId();
        OnlineSession onlineSession = (OnlineSession)sessionDAO.readSession(sessionId);
        System.out.println(onlineSession.getStatus().getInfo());
    %>
</shiro:user>

</body>
</html>