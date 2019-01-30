package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.DBBean;

public final class Confirmation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      bean.UserInfo userInfo = null;
      synchronized (session) {
        userInfo = (bean.UserInfo) _jspx_page_context.getAttribute("userInfo", PageContext.SESSION_SCOPE);
        if (userInfo == null){
          userInfo = new bean.UserInfo();
          _jspx_page_context.setAttribute("userInfo", userInfo, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      bean.DBBean dbBean = null;
      synchronized (session) {
        dbBean = (bean.DBBean) _jspx_page_context.getAttribute("dbBean", PageContext.SESSION_SCOPE);
        if (dbBean == null){
          dbBean = new bean.DBBean();
          _jspx_page_context.setAttribute("dbBean", dbBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      bean.CartBean cart = null;
      synchronized (session) {
        cart = (bean.CartBean) _jspx_page_context.getAttribute("cart", PageContext.SESSION_SCOPE);
        if (cart == null){
          cart = new bean.CartBean();
          _jspx_page_context.setAttribute("cart", cart, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("         <link href=\"main.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("               ");
 if (cart.getTotalCartCount() == 0) {
      out.write("\n");
      out.write("        <p>Cart is Empty</p> ");
} else {  int i = 0;
      out.write("\n");
      out.write("\n");
      out.write("        <table>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Quantity</th>\n");
      out.write("                <th>Unit Price</th>\n");
      out.write("                <th> Total price</th>\n");
      out.write("            </tr>\n");
      out.write("            <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.cartItemsArr}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"value\">\n");
      out.write("                 <form method=\"post\" action=\"CartController\">\n");
      out.write("                    <tr>\n");
      out.write("\n");
      out.write("                        <td><b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${value.getCookieType()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b><br />\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${value.getDescription()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"hidden\" name=\"itemIndex\" value=\"");
      out.print(i++);
      out.write("\" >\n");
      out.write("                            <input type=\"number\" min=\"0\" max=\"20\" name=\"quantity\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${value.getQuantity()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" size='2'> \n");
      out.write("                            <input type=\"submit\" name=\"action\" value=\"update\">\n");
      out.write("                            <br/><input type=\"submit\" method= \"post\" name=\"action\" value=\"delete\">\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${value.getUnitCost()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${value.getItemTotalCost()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                </form>\n");
      out.write("            </c:forEach>\n");
      out.write("             <tr>\n");
      out.write("                <td colspan=\"2\"> </td>\n");
      out.write("                <td> </td>\n");
      out.write("                <td>Subtotal: $<c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.getCartOrderTotal()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <br />\n");
      out.write("    <center> <form method=\"post\" action=\"CheckoutController\">\n");
      out.write("            <input type=\"submit\" name = \"action\" value = \"pickup\" >\n");
      out.write("            <input type=\"submit\" name = \"action\" value = \"delivery\" >\n");
      out.write("        </form>\n");
      out.write("    </center>\n");
      out.write("\n");
      out.write("    ");
}
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
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
