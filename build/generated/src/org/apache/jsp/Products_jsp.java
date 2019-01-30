package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Products_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_remove_var_scope_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_remove_var_scope_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_remove_var_scope_nobody.release();
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
      bean.DBBean dbBean = null;
      synchronized (session) {
        dbBean = (bean.DBBean) _jspx_page_context.getAttribute("dbBean", PageContext.SESSION_SCOPE);
        if (dbBean == null){
          dbBean = new bean.DBBean();
          _jspx_page_context.setAttribute("dbBean", dbBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Products</title>\n");
      out.write("        <link href=\"main.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"head\"><img src=\"images/toptop.png\" alt=\"Monster Cookies\" style=\"width:100%;height:150px;\"></div>\n");
      out.write("\n");
      out.write("        <div id=\"links\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"./Home.html\">Home</a></li>\n");
      out.write("                <li><a href=\"./Products.jsp\">Products</a></li>\n");
      out.write("                <li><a href=\"./Cart.jsp\">Cart</a></li>\n");
      out.write("                <li><a href=\"./OrderHistory.jsp\">OrderHistory</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <br/>\n");
      out.write("    <center><h1> Monsters Selection</h1></center>\n");
      out.write("    <center><h3> All our cookies come with complementary cold milk</h3></center>\n");
      out.write("    <hr />\n");
      out.write("\n");
      out.write("    <font color = red> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.cartItemsArr}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p></font><!-- to tell user item has been added to cart-->\n");
      out.write("    ");
      if (_jspx_meth_c_remove_0(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("\n");
      out.write("<div><!--- First product -->\n");
      out.write("    <form action =\"CartController\" method = \"post\">\n");
      out.write("        <h2 style=\"color:blue\"> Chocolate Chip</h2> <input type=\"hidden\" name=\"cookieType\" value=\"Chocolate Chip\"> <input type =\"hidden\" name =\"itemNumber\" value = \"100\">\n");
      out.write("        <img src =\"images/chocChip.jpg\" alt =\"Chocolate Chip\" style=\"width: 400px; height: 300px;\">\n");
      out.write("        <p>Try Monster's favorite cookie. You can never go wrong with our classic chocolate chip cookie</p> <input type=\"hidden\" name=\"description\" value=\"Our favorite, Chocolate Chip\">\n");
      out.write("        Price: $1.99 <input type=\"hidden\" name=\"price\" value=\"1.99\">\n");
      out.write("        ");
if (dbBean.IsSoldOut(100) > 0) {
      out.write("\n");
      out.write("        <br /> quantity <input type=\"number\" name=\"quantity\" min=\"0\" max=\"20\" size = 3 value =\"1\">\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("        <input type=\"submit\" name=\"cart\" value=\"Add to Cart\">\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        <h2>SOLD OUT</h2>");
}
      out.write("\n");
      out.write("    </form></div>\n");
      out.write("\n");
      out.write("<hr />\n");
      out.write("\n");
      out.write("\n");
      out.write("<div><!--Next product-->\n");
      out.write("    <form action=\"CartController\" method = \"post\"><input type=\"hidden\" name=\"cookieType\" value=\"M&N\"> <input type =\"hidden\" name =\"itemNumber\" value = \"200\">\n");
      out.write("        <h2 style=\"color:blue\"> M&N Cookie</h2>\n");
      out.write("        <img src =\"images/mmCook.jpg\" alt =\"M&M cookie\" style=\"width: 400px; height: 300px;\">\n");
      out.write("        <p>Cookies and M&Ms that's a recipe for... well deliciousness</p> <input type=\"hidden\" name=\"description\" value=\"the guy who is a rapper\">\n");
      out.write("        Price: $1.99 <input type=\"hidden\" name=\"price\" value=\"1.99\">\n");
      out.write("        ");
if (dbBean.IsSoldOut(200) > 0) {
      out.write("\n");
      out.write("        <br /> quantity <input type=\"number\" name=\"quantity\" min=\"0\" max=\"20\" size = 3 value =\"1\">\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("        <input type=\"submit\" name=\"cart\" value=\"Add to Cart\">\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        <h2>SOLD OUT</h2>");
}
      out.write("\n");
      out.write("    </form>\n");
      out.write("    <hr />\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div><!--Next product-->\n");
      out.write("    <form action=\"CartController\" method = \"post\"><input type=\"hidden\" name=\"cookieType\" value=\"oat\"> <input type =\"hidden\" name =\"itemNumber\" value = \"300\">\n");
      out.write("        <h2 style=\"color:blue\"> Oatmeal Raisin</h2>\n");
      out.write("        <img src =\"images/oatmeal.jpg\" alt =\"oatmeal\" style=\"width: 400px; height: 300px;\">\n");
      out.write("        <p>The underated cookie</p> <input type=\"hidden\" name=\"description\" value=\"the underated cookie\">\n");
      out.write("        Price: $1.99 <input type=\"hidden\" name=\"price\" value=\"1.99\">\n");
      out.write("        ");
if (dbBean.IsSoldOut(300) > 0) {
      out.write("\n");
      out.write("        <br /> quantity <input type=\"number\" name=\"quantity\" min=\"0\" max=\"20\" size = 3 value =\"1\">\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("        <input type=\"submit\" name=\"cart\" value=\"Add to Cart\">\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        <h2>SOLD OUT</h2>");
}
      out.write("\n");
      out.write("    </form>\n");
      out.write("    <hr />\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("<center> <form action = \"./Cart.jsp\">\n");
      out.write("        <input type=\"submit\" value = \"Cart\" />\n");
      out.write("    </form></center>\n");
      out.write("\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_remove_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_0 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_scope_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_0.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_0.setParent(null);
    _jspx_th_c_remove_0.setVar("message");
    _jspx_th_c_remove_0.setScope("session");
    int _jspx_eval_c_remove_0 = _jspx_th_c_remove_0.doStartTag();
    if (_jspx_th_c_remove_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_scope_nobody.reuse(_jspx_th_c_remove_0);
      return true;
    }
    _jspx_tagPool_c_remove_var_scope_nobody.reuse(_jspx_th_c_remove_0);
    return false;
  }
}
