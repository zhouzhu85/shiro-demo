package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class success_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_principal_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_lacksRole_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_hasRole_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_guest;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_authenticated;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_shiro_principal_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_shiro_lacksRole_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_shiro_hasRole_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_shiro_guest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_shiro_authenticated = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_shiro_principal_nobody.release();
    _jspx_tagPool_shiro_lacksRole_name.release();
    _jspx_tagPool_shiro_hasRole_name.release();
    _jspx_tagPool_shiro_guest.release();
    _jspx_tagPool_shiro_authenticated.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("    hello app2.<br/>\r\n");
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_shiro_guest_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_shiro_authenticated_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_shiro_guest_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:guest
    org.apache.shiro.web.tags.GuestTag _jspx_th_shiro_guest_0 = (org.apache.shiro.web.tags.GuestTag) _jspx_tagPool_shiro_guest.get(org.apache.shiro.web.tags.GuestTag.class);
    _jspx_th_shiro_guest_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_guest_0.setParent(null);
    int _jspx_eval_shiro_guest_0 = _jspx_th_shiro_guest_0.doStartTag();
    if (_jspx_eval_shiro_guest_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("        <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/login?backUrl=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">点击登录</a>\r\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_shiro_guest_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_guest_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_guest.reuse(_jspx_th_shiro_guest_0);
      return true;
    }
    _jspx_tagPool_shiro_guest.reuse(_jspx_th_shiro_guest_0);
    return false;
  }

  private boolean _jspx_meth_shiro_authenticated_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:authenticated
    org.apache.shiro.web.tags.AuthenticatedTag _jspx_th_shiro_authenticated_0 = (org.apache.shiro.web.tags.AuthenticatedTag) _jspx_tagPool_shiro_authenticated.get(org.apache.shiro.web.tags.AuthenticatedTag.class);
    _jspx_th_shiro_authenticated_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_authenticated_0.setParent(null);
    int _jspx_eval_shiro_authenticated_0 = _jspx_th_shiro_authenticated_0.doStartTag();
    if (_jspx_eval_shiro_authenticated_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("        欢迎");
        if (_jspx_meth_shiro_principal_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_authenticated_0, _jspx_page_context))
          return true;
        out.write("登录<br/>\r\n");
        out.write("        ");
        if (_jspx_meth_shiro_hasRole_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_authenticated_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        if (_jspx_meth_shiro_lacksRole_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_authenticated_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        if (_jspx_meth_shiro_lacksRole_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_authenticated_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\r\n");
        out.write("        <h2>设置会话属性</h2>\r\n");
        out.write("        <form action=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/attr\" method=\"post\">\r\n");
        out.write("            键：<input type=\"text\" name=\"key\">\r\n");
        out.write("            值：<input type=\"text\" name=\"value\">\r\n");
        out.write("            <input type=\"submit\" value=\"设置会话属性\">\r\n");
        out.write("        </form>\r\n");
        out.write("        <h2>获取会话属性</h2>\r\n");
        out.write("        <form action=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/attr\" method=\"get\">\r\n");
        out.write("            键：<input type=\"text\" name=\"key\">\r\n");
        out.write("            值：<input type=\"text\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${value}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\r\n");
        out.write("            <input type=\"submit\" value=\"获取会话属性\">\r\n");
        out.write("        </form>\r\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_shiro_authenticated_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_authenticated_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_authenticated.reuse(_jspx_th_shiro_authenticated_0);
      return true;
    }
    _jspx_tagPool_shiro_authenticated.reuse(_jspx_th_shiro_authenticated_0);
    return false;
  }

  private boolean _jspx_meth_shiro_principal_0(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_authenticated_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_principal_0 = (org.apache.shiro.web.tags.PrincipalTag) _jspx_tagPool_shiro_principal_nobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_principal_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_principal_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_authenticated_0);
    int _jspx_eval_shiro_principal_0 = _jspx_th_shiro_principal_0.doStartTag();
    if (_jspx_th_shiro_principal_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_principal_nobody.reuse(_jspx_th_shiro_principal_0);
      return true;
    }
    _jspx_tagPool_shiro_principal_nobody.reuse(_jspx_th_shiro_principal_0);
    return false;
  }

  private boolean _jspx_meth_shiro_hasRole_0(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_authenticated_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasRole
    org.apache.shiro.web.tags.HasRoleTag _jspx_th_shiro_hasRole_0 = (org.apache.shiro.web.tags.HasRoleTag) _jspx_tagPool_shiro_hasRole_name.get(org.apache.shiro.web.tags.HasRoleTag.class);
    _jspx_th_shiro_hasRole_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasRole_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_authenticated_0);
    _jspx_th_shiro_hasRole_0.setName("role2");
    int _jspx_eval_shiro_hasRole_0 = _jspx_th_shiro_hasRole_0.doStartTag();
    if (_jspx_eval_shiro_hasRole_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            您拥有role2角色<br/>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_shiro_hasRole_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasRole_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasRole_name.reuse(_jspx_th_shiro_hasRole_0);
      return true;
    }
    _jspx_tagPool_shiro_hasRole_name.reuse(_jspx_th_shiro_hasRole_0);
    return false;
  }

  private boolean _jspx_meth_shiro_lacksRole_0(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_authenticated_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:lacksRole
    org.apache.shiro.web.tags.LacksRoleTag _jspx_th_shiro_lacksRole_0 = (org.apache.shiro.web.tags.LacksRoleTag) _jspx_tagPool_shiro_lacksRole_name.get(org.apache.shiro.web.tags.LacksRoleTag.class);
    _jspx_th_shiro_lacksRole_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_lacksRole_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_authenticated_0);
    _jspx_th_shiro_lacksRole_0.setName("role2");
    int _jspx_eval_shiro_lacksRole_0 = _jspx_th_shiro_lacksRole_0.doStartTag();
    if (_jspx_eval_shiro_lacksRole_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            您没有role2角色<br/>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_shiro_lacksRole_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_lacksRole_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_lacksRole_name.reuse(_jspx_th_shiro_lacksRole_0);
      return true;
    }
    _jspx_tagPool_shiro_lacksRole_name.reuse(_jspx_th_shiro_lacksRole_0);
    return false;
  }

  private boolean _jspx_meth_shiro_lacksRole_1(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_authenticated_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:lacksRole
    org.apache.shiro.web.tags.LacksRoleTag _jspx_th_shiro_lacksRole_1 = (org.apache.shiro.web.tags.LacksRoleTag) _jspx_tagPool_shiro_lacksRole_name.get(org.apache.shiro.web.tags.LacksRoleTag.class);
    _jspx_th_shiro_lacksRole_1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_lacksRole_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_authenticated_0);
    _jspx_th_shiro_lacksRole_1.setName("role1");
    int _jspx_eval_shiro_lacksRole_1 = _jspx_th_shiro_lacksRole_1.doStartTag();
    if (_jspx_eval_shiro_lacksRole_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            您没有role1角色<br/>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_shiro_lacksRole_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_lacksRole_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_lacksRole_name.reuse(_jspx_th_shiro_lacksRole_1);
      return true;
    }
    _jspx_tagPool_shiro_lacksRole_name.reuse(_jspx_th_shiro_lacksRole_1);
    return false;
  }
}
