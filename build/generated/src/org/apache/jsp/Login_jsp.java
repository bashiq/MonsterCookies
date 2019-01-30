package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h3>Continue as guest</h3>\n");
      out.write("        <form action =\"LoginController\" method =\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"guest\">\n");
      out.write("            <input type = \"submit\" name = \"guest\" value = \"Guest Mode\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <br /> <br />\n");
      out.write("        <h3>Enter your login information</h3>\n");
      out.write("        <font color = red> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p></font>\n");
      out.write("    <c:remove var=\"loginMessage\" scope=\"session\" /> \n");
      out.write("        <form action =\"LoginController\" method =\"post\">\n");
      out.write("            Email <input type = \"email\" name =\"id\" required><br />\n");
      out.write("            <br />\n");
      out.write("            Password <INPUT type = \"password\" NAME=\"password\" required>\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"signin\">\n");
      out.write("            <input type = \"submit\" name = \"signin\" value = \"Sign In\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <br /><br />\n");
      out.write("        <h3>Sign up for an account</h3>\n");
      out.write("        <h4>All fields are required</h4>\n");
      out.write("        <font color = red> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${signupMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p></font>\n");
      out.write("        <c:remove var=\"signupMessage\" scope=\"session\" /> \n");
      out.write("    <c:remove var=\"signupMessage\" scope=\"session\" /> \n");
      out.write("        <form action =\"LoginController\" method =\"post\">\n");
      out.write("            Email <input type =\"email\" name =\"id\" required><br />\n");
      out.write("            Password <input type = \"password\" name=\"password\" required ><br />\n");
      out.write("            Confirm Password <input type = \"password\" name = \"confirm\" required><br />\n");
      out.write("            FirstName <input type =\"text\" name =\"firstname\" required >&nbsp;\n");
      out.write("            lastName <input type =\"text\" name =\"lastname\" required ><br />\n");
      out.write("            Phone number <input type =\"number\" pattern=\"\\d{3}[\\-]\\d{3}[\\-]\\d{4}\" name =\"phonenumber\" required ><br /><br />\n");
      out.write("            <input type =\"hidden\" name=\"action\" value =\"signup\">\n");
      out.write("            <input type = \"submit\" name = \"signup\" value = \"Signup\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
}
