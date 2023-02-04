package Linkcode.shop.admin.contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Linkcode.shop.admin.daoimpl.ProductServiceImpl;
import Linkcode.shop.admin.model.Product;
import Linkcode.shop.admin.service.ProductService;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String msg=null;
		int prodId=Integer.parseInt(request.getParameter("prodId"));
		ProductService proddao=new ProductServiceImpl();
		List<Product> lstprod=proddao.retriveProduct(prodId);
		HttpSession session=request.getSession();
		if(lstprod!=null)
		{
			session.setAttribute("prod",lstprod);
		}
		else
		{
			msg="Invalid Product Id";
			session.setAttribute("prod",msg);
		}
		response.sendRedirect("SearchView.jsp");
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
