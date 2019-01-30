package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.DBBean;

public final class Cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_out_value_nobody.release();
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
      out.write("\n");
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Cart</title>\n");
      out.write("        <link href=\"main.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"head\"><img src=\"images/toptop.png\" alt=\"Monster Cookies\" style=\"width:100%;height:150px;\"></div>\n");
      out.write("        <br/>\n");
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
      out.write("        <div><img src=\"images/thumbs.jpg\" alt=\"Confirmation\" style=\"width:100%;height:300px;\"></div>\n");
      out.write("        <h2>Shopping Cart</h2>\n");
      out.write("        <!-- What ever the customer decides to get will show up on this checkout page-->\n");
      out.write("\n");
      out.write("        ");
 if (cart.getTotalCartCount() == 0) {
      out.write("\n");
      out.write("        <p>Cart is Empty</p> ");
} else {
            int i = 0;
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
      out.write("            ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.cartItemsArr}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_c_forEach_0.setVar("value");
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
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
            out.write("            ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\n");
      out.write("             <tr>\n");
      out.write("                <td colspan=\"2\"> </td>\n");
      out.write("                <td> </td>\n");
      out.write("                <td>Subtotal: $");
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
      out.write("</td>\n");
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

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.getCartOrderTotal()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }
}
