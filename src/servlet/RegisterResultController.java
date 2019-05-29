package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;

/**
 * Servlet implementation class RegisterResultController
 */
@WebServlet("/RegisterResultController")
public class RegisterResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");

		UserDAO dao = new UserDAO();
		dao.insertUser(user_name, user_password);

		ServletContext context =getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/jsp/register_result.jsp");
		rd.forward(request, response);
	}
}
