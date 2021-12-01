package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.CheckLoginBO;
import Model.Bean.Account;

/**
 * Servlet implementation class CheckLoginServlet
 */
@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CheckLoginServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().getAttribute("account");
		response.sendRedirect("Client.jsp");	
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Account account = CheckLoginBO.CheckLogin(id, pw);
		if(account == null)
		{
			//Quay lai login
			System.out.println("sai mk");
			response.sendRedirect("Login.jsp");
		}
		else
		{
			//Hien thi myhome
			request.getSession().setAttribute("account", account);
			response.sendRedirect("Client.jsp");
		}
	}

}
