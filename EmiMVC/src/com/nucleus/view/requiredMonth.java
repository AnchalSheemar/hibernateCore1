package com.nucleus.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.model.Calculation;
import com.nucleus.model.UserClass;

/**
 * Servlet implementation class month
 */
@WebServlet("/month")
public class requiredMonth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requiredMonth() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DecimalFormat df=new DecimalFormat("0.00");
		PrintWriter out=response.getWriter();
	/*	String principalAmount=request.getParameter("principalAmount");
		double principalAmount1=Double.parseDouble(principalAmount);
		
		String rateOfInterest=request.getParameter("rateOfInterest");
		double rateOfInterest1=Double.parseDouble(rateOfInterest);
		
		String tenure=request.getParameter("tenure");
		int tenure1=Integer.parseInt(tenure);
		
		UserClass userClass=new UserClass();
		userClass.setPrincipalAmount(principalAmount1);
		userClass.setRateOfInterest(rateOfInterest1);
		userClass.setTenure(tenure1);*/
	
		UserClass userClass=new UserClass();
		HttpSession session=request.getSession();

		double principalamt=(double) session.getAttribute("principalAmount");
		double roi =(double) session.getAttribute("rateOfInterest");
		double tenure = (double) session.getAttribute("tenure1");
		double month = (double) session.getAttribute("month");
		
		userClass.setPrincipalAmount(principalamt);
		userClass.setRateOfInterest(roi);
		userClass.setTenure(tenure);
		userClass.setMonth(month);

		Calculation calculation = new Calculation();
		
		double emi=calculation.EmiCal(userClass);
		
		double arr[][]=new double[(int) tenure][4];
		for(int i=0;i<(int)tenure;i++)
		{
			arr[i][0]=calculation.outP(userClass);
			arr[i][1]=calculation.interests(userClass);
			arr[i][2]=calculation.prinComp(userClass);
			arr[i][3]=emi;
		}
		out.println("<table border=2>");
		out.println("<tr>");
		out.println("<th>openingPrincipal</th>");
		out.println("<th>interest</th>");
		out.println("<th>principalComponent</th>");
		out.println("<th>emi</th>");
		out.println("</tr>");
	
		double a=calculation.Month(userClass);
		out.println("<tr>");
		out.println("<td>"+df.format(arr[(int) (a-1)][0])+"<td>"+df.format(arr[(int) (a-1)][1])+"<td>"+df.format(arr[(int) (a-1)][2])+"<td>"+df.format(arr[(int) (a-1)][3]));
		out.println("</tr>");
		out.println("</table>");
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
