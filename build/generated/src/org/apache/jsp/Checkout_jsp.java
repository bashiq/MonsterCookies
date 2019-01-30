package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.Address;
import bean.UserInfo;

public final class Checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
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
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Checkout</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div><img src=\"images/registerCookie.jpg\" alt=\"Checkout\" style=\"width:100%;height:300px;\"></div>\n");
      out.write("        <br />\n");
      out.write("        Enter your Information so we can process your order correctly address&nbsp;\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            if (true) {///////////////////////////change
        
      out.write("\n");
      out.write("        <h2>Delivery</h2>\n");
      out.write("        ");
 if (true) { 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
 Address[] ad = dbBean.getAddresses(28);
            for (int i = 0; i < ad.length; i++) {
      out.write(" <h5>Address ");
      out.print(i + 1);
      out.write("\n");
      out.write("            <form action =\"CheckoutController\" method =\"post\">\n");
      out.write("                ");
      out.print(ad[i]);
      out.write("<br /> \n");
      out.write("                Cash or credit<br /><input type=\"radio\" name=\"payment\" value=\"cash\"required> cash<br />\n");
      out.write("                <input type=\"radio\" name=\"payment\" value=\"credit\"required> credit<br />\n");
      out.write("                <input type=\"submit\" name=\"Submit\" value=\"Submit\">\n");
      out.write("                <input type=\"hidden\" name=\"storeId\" value=\"");
      out.print(ad[i].getId());
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"checkdelivery\">\n");
      out.write("                <input type=\"hidden\" name=\"useaddress\" value=\"yes\">\n");
      out.write("            </form>\n");
      out.write("            <br />");
}
      out.write("\n");
      out.write("            <br /><br />\n");
      out.write("            Complete all fields\n");
      out.write("            <form action =\"CheckoutController\" method =\"post\">\n");
      out.write("                <p>Street <input type=\"text\" name=\"street\" size=\"50\" required pattern=\".*\\S+.*\" title=\"Enter valid text\" required></p>\n");
      out.write("                <p>City <input type=\"text\" name=\"city\" size=\"23\" required pattern=\"\\S+\" title=\"Enter valid text\" required>&nbsp;\n");
      out.write("                    State <select size=\"1\" name=\"state\" required>\n");
      out.write("                        <option value=\"MD\">Maryland-MD</option>\n");
      out.write("                        <option value=\"DC\">Washington-DC</option>\n");
      out.write("                        <option value=\"VA\">Virginia-VA</option>\n");
      out.write("                    </select>&nbsp;\n");
      out.write("                    Zip<input type=\"number\" name =\"zip\" min = \"10000\" max=\"99999\" maxlength=5></p>\n");
      out.write("                Cash or credit<br /><input type=\"radio\" name=\"payment\" value=\"cash\"required> cash<br>\n");
      out.write("                <input type=\"radio\" name=\"payment\" value=\"credit\"required> credit<br>\n");
      out.write("\n");
      out.write("                <p><input type=\"submit\" name=\"Submit\" value=\"Submit\">\n");
      out.write("                    <input type=\"reset\" value=\"Reset\"></p>\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"checkdelivery\">\n");
      out.write("                <input type=\"hidden\" name=\"useaddress\" value=\"no\">\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
 } else { 
      out.write("\n");
      out.write("            Complete all fields\n");
      out.write("            <form action =\"CheckoutController\" method =\"post\">  \n");
      out.write("\n");
      out.write("                <p>First Name <input type=\"text\" name=\"firstName\" required pattern=\"\\S+\" title=\"Enter valid text\" required>&nbsp;\n");
      out.write("                    Last Name <input type=\"text\" name=\"lastName\" required pattern=\"\\S+\" title=\"Enter valid text\" required>&nbsp;\n");
      out.write("                <p>Telephone <input type=\"number\" name=\"telephone\" size=\"20\" title=\"Enter valid text\" required>&nbsp;\n");
      out.write("                <p>Street <input type=\"text\" name=\"street\" size=\"50\" required pattern=\".*\\S+.*\" title=\"Enter valid text\" required></p>\n");
      out.write("                <p>City <input type=\"text\" name=\"city\" size=\"23\" required pattern=\"\\S+\" title=\"Enter valid text\" required>&nbsp;\n");
      out.write("                    State <select size=\"1\" name=\"state\" required>\n");
      out.write("                        <option value=\"MD\">Maryland-MD</option>\n");
      out.write("                        <option value=\"DC\">Washington-DC</option>\n");
      out.write("                        <option value=\"VA\">Virginia-VA</option>\n");
      out.write("                    </select>&nbsp;\n");
      out.write("                    Zip <input type=\"number\" name =\"zip\" min = \"10000\" max=\"99999\" maxlength=5></p>\n");
      out.write("                Cash or credit <br /><input type=\"radio\" name=\"payment\" value=\"cash\"required> cash<br>\n");
      out.write("                <input type=\"radio\" name=\"payment\" value=\"credit\"required> credit<br>\n");
      out.write("\n");
      out.write("                <p><input type=\"submit\" name=\"Submit\" value=\"Submit\">\n");
      out.write("                    <input type=\"reset\" value=\"Reset\"></p>\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"checkdelivery\">\n");
      out.write("                <input type=\"hidden\" name=\"useaddress\" value=\"no\">\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
 }
        } else {
      out.write("\n");
      out.write("            <h2>Pickup</h2>\n");
      out.write("            ");
 if (userInfo.getUserId() != -1) { 
      out.write("\n");
      out.write("            <form action =\"CheckoutController\" method =\"post\">\n");
      out.write("                <h3>Use existing information</h3><br /> Name: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userInfo.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userInfo.lastName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("   &nbsp; PhoneNumber: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userInfo.phoneNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<br /><br />\n");
      out.write("\n");
      out.write("                Cash or credit<br /><input type=\"radio\" name=\"payment\" value=\"cash\" required> cash<br>\n");
      out.write("                <input type=\"radio\" name=\"payment\" value=\"credit\" required> credit<br>\n");
      out.write("                <input type=\"submit\" name=\"Submit\" value=\"Submit\">\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"checkpickup\">\n");
      out.write("                <input type=\"hidden\" name=\"useexisting\" value=\"yes\">\n");
      out.write("            </form>\n");
      out.write("            ");
 } else {
      out.write("\n");
      out.write("\n");
      out.write("            <h3>Complete all fields</h3>\n");
      out.write("            <form action =\"CheckoutController\" method =\"post\">\n");
      out.write("                <p>First Name <input type=\"text\" name=\"firstName\"  required pattern=\"\\S+\" title=\"Enter valid text\" required />&nbsp;\n");
      out.write("                    Last Name <input type=\"text\" name=\"lastName\" required />&nbsp;\n");
      out.write("                <p>Telephone <input type=\"number\" name=\"telephone\" size=\"20\" maxlength =10 required /><br />\n");
      out.write("                    Cash or credit<br /><input type=\"radio\" name=\"payment\" value=\"cash\" required > cash<br>\n");
      out.write("                    <input type=\"radio\" name=\"payment\" value=\"credit\" required > credit<br>\n");
      out.write("                <p><input type=\"submit\" name=\"Submit\" value=\"Submit\">\n");
      out.write("                    <input type=\"reset\" value=\"Reset\"></p>\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"checkpickup\">\n");
      out.write("                <input type=\"hidden\" name=\"useexisting\" value=\"no\">\n");
      out.write("            </form>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
