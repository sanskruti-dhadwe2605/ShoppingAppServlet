package Linkcode.shop.admin.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Linkcode.shop.admin.daoimpl.ProductServiceImpl;
import Linkcode.shop.admin.service.ProductService;

/**
 * Servlet implementation class Deletecontroller
 */
@WebServlet("/Deletecontroller")
public class Deletecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProductService ps=new ProductServiceImpl();
		Object msg=null;
		String action=request.getParameter("action");

		if(action.equals("Delete with Product Id")) {
			int prodId=Integer.parseInt(request.getParameter("prodId"));
			msg=ps.deleteproduct(prodId);
		}
		if(action.equals("Delete with Product Name")) {
			String prodName=request.getParameter("prodName");
			msg=ps.deleteProduct(prodName);
		}

		if(msg.equals("Valid")) {
			msg="Product Deleted Successfully";
		}
		HttpSession session0=request.getSession();
		session0.setAttribute("msg", msg);
		response.sendRedirect("DeleteProduct.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
