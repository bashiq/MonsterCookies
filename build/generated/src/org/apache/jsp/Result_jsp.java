package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Result_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Result</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 if(session.getAttribute("ErrorMessage") != null){ 
        session.removeAttribute("ErrorMessage"); 
      out.write("\n");
      out.write("        \n");
      out.write("    <center> <h2>Error: Please try ordering again</h2>\n");
      out.write("       \n");
      out.write("    ");
}else{
      out.write("\n");
      out.write("        <center><h1>Congratulations!</h1>\n");
      out.write("            <img src=\"images/congrat.png\" alt=\"Monster Cookies\" style=\"width: 400;height:400px;\"> <br />\n");
      out.write("            <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${success}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" until then enjoy some CookieMonster</p>\n");
      out.write("    ");
session.removeAttribute("success");
      out.write("\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    </center>\n");
      out.write("    <center><form action=\"./Home.html\">\n");
      out.write("    <input type=\"submit\" value=\"Home\" />\n");
      out.write("        </form></center>\n");
      out.write("        \n");
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
