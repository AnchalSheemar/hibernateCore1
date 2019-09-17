package com.nucleus.controller;



import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.nucleus.model.UserClass;


@WebServlet("/Controller1")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletController() {
        super();
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String principalAmount=request.getParameter("principalAmount");
		double principalAmount1=Double.parseDouble(principalAmount);
		
		String rateOfInterest=request.getParameter("rateOfInterest");
		double rateOfInterest1=Double.parseDouble(rateOfInterest);
		
		String tenure=request.getParameter("tenure");
		double tenure1=Double.parseDouble(tenure);

		String month=request.getParameter("month");
		double month1=Double.parseDouble(month);
		

		
		UserClass userClass=new UserClass();
		userClass.setPrincipalAmount(principalAmount1);
		userClass.setRateOfInterest(rateOfInterest1);
		userClass.setTenure(tenure1);
		userClass.setRateOfInterest(month1);
		
		
		
		HttpSession session=request.getSession();
		session.setAttribute("principalAmount", principalAmount1);
		session.setAttribute("rateOfInterest", rateOfInterest1);
		session.setAttribute("tenure1", tenure1);
		session.setAttribute("month", month1);
		String button1=request.getParameter("submit");
	
		if(button1.equals("EMI"))
		{
			
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("EmiTotal");
			dispatcher.forward(request,response);
			
		}
		if(button1.equals("repaySchedule"))
		{
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("Repay");
			dispatcher.forward(request,response);
		}
		else if(button1.equals("reqiredMonth"))
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("month");
			dispatcher.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
		
	}

}
