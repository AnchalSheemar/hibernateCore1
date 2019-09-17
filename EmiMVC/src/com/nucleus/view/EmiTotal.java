package com.nucleus.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.model.Calculation;
import com.nucleus.model.UserClass;

/**
 * Servlet implementation class EmiTotal
 */
@WebServlet("/EmiTotal")
public class EmiTotal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmiTotal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
	/*	String principalAmount=request.getParameter("principalAmount");
		double principalAmount1=Double.parseDouble(principalAmount);
		
		String rateOfInterest=request.getParameter("rateOfInterest");
		double rateOfInterest1=Double.parseDouble(rateOfInterest);
		
		String tenure=request.getParameter("tenure");
		int tenure1=Integer.parseInt(tenure);
		HttpSession session=request.getSession();
		session.setAttribute("principalAmount", principalAmount);
		session.setAttribute("rateOfInterest", rateOfInterest);
		session.setAttribute("tenure", tenure);*/
		
		UserClass userClass=new UserClass();
		
		double principalamt=(double) session.getAttribute("principalAmount");
		double roi =(double) session.getAttribute("rateOfInterest");
		double tenure = (double) session.getAttribute("tenure1");
		userClass.setPrincipalAmount(principalamt);
		userClass.setRateOfInterest(roi);
		userClass.setTenure(tenure);
		Calculation calculation = new Calculation();
		double  res=calculation.EmiCal(userClass);
		out.println("Total EMI is:"+res);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
