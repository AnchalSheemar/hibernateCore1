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
 * Servlet implementation class EmiTable
 */
@WebServlet("/Repay")
public class RepaySchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepaySchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DecimalFormat df=new DecimalFormat("0.00");
PrintWriter out=response.getWriter();
		
UserClass userClass=new UserClass();
HttpSession session=request.getSession();

double principalamt=(double) session.getAttribute("principalAmount");
double roi =(double) session.getAttribute("rateOfInterest");
double tenure = (double) session.getAttribute("tenure1");
userClass.setPrincipalAmount(principalamt);
userClass.setRateOfInterest(roi);
userClass.setTenure(tenure);

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
out.println("<table class=js-serial border=2>");
out.println("<thead>");
out.println("<tr>");
out.println("<th>openingPrincipal</th>");
out.println("<th>interest</th>");
out.println("<th>principalComponent</th>");
out.println("<th>emi</th>");
out.println("</tr>");
out.println("</thead>");

for(int i=0;i<(int)tenure;i++)

{
	out.println("<tbody>");
	out.println("<tr>");
	
	if(i==0){
		
		out.println(("<td>"+df.format(arr[i][0])+"<td>"+df.format(arr[i][1])+"<td>"+df.format(arr[i][2])+"<td>"+df.format(arr[i][3])));
	}
	
	else{
	
	out.println(("<td>"+df.format(arr[i][0])+"<td>"+df.format(arr[i][1])+"<td>"+df.format(arr[i][2])+"<td>"+df.format(arr[i][3])));
	}
	out.println("</tr>");
	out.println("</tbody>");

}	
out.println("</table>");

}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
