package Linkcode.shop.admin.contoller;



import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class DashboardController
 */
@WebServlet("/DashboardController")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        int prodId=Integer.parseInt(request.getParameter("prodId"));
		String prodName=request.getParameter("prodName");
		double prodPrice =Double.parseDouble(request.getParameter("prodPrice"));
		int prodQty=Integer.parseInt(request.getParameter("prodQty"));
		Product prodobj=new Product(prodId, prodName, prodPrice, prodQty);
		List<Product> lstproduct=new ArrayList<Product>();
		lstproduct.add(prodobj);
		
		
		ProductService proddao=new ProductServiceImpl();
		String str=proddao.createProduct(lstproduct);
		System.out.println("In controller str is "+str);
		HttpSession session=request.getSession();
		if(str.equals("valid")) {
			str="product Added to Db";
		}
		
		session.setAttribute("msg", str);
		response.sendRedirect("productView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
