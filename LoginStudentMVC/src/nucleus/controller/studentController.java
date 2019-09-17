package nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nucleus.dao.StudentDao;
import com.nucleus.dao.StudentRDBMSImp2;
import com.nucleus.model.StudentInfo;


/**
 * Servlet implementation class studentController
 */
@WebServlet("/studentController")
public class studentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String id=request.getParameter("id");
		String password=request.getParameter("password");	
		
		StudentInfo studentInfo=new StudentInfo();
		studentInfo.setId(id);
		studentInfo.setPassword(password);
	
		
		StudentDao studentDao=new StudentRDBMSImp2();
		try {
			studentDao.retreiveUser(studentInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	/*	boolean validation;
		try {
			validation = studentDao.retreiveUser(studentInfo);
			
			if(validation==true)
			{
			
				HttpSession session=request.getSession();
				session.setAttribute("id",id);
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("WelcomeServlet");
				dispatcher.forward(request,response);
			}
			else
			{
				out.println("invalid user");
				response.sendRedirect("loginpage");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
