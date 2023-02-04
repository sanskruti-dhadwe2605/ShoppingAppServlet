package Register.conroller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Register.model.Registerentry;
import login.implemetation.Loginimpl;


/**
 * Servlet implementation class Registercontoller
 */
@WebServlet("/Registercontoller")
public class Registercontoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registercontoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int i=0;
		Registerentry u=null;
		int rno=Integer.parseInt(request.getParameter("rno"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String mobno=request.getParameter("mobno");
		String spass=request.getParameter("spass");
		String repass=request.getParameter("repass");
		String temp=request.getParameter("amount");
		double amount=Double.parseDouble(temp);
		
		PrintWriter out=response.getWriter();
		List<Registerentry> lst=new ArrayList<Registerentry>();
		Loginimpl udao=new Loginimpl();
		
		if(spass.equals(repass)) {
			 u=new Registerentry(rno, fname, lname, uname,mobno, spass,repass, amount);
			lst.add(u);
			i=udao.create(lst);
			
			if(i>0) {
				out.print("Record Saved");
			}else {
				out.print("Record NOT Saved");
			}
			
		}else {
			out.print("<h3>***..Confirm Password doesnt match..***</h3>");    		
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
