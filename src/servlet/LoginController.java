package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GoodsDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String user_name = request.getParameter("user_name");
		HttpSession session=request.getSession();

		String user_password = request.getParameter("user_password");
		String path = "/jsp/main.jsp";
		int user_id;
		GoodsDAO dao = new GoodsDAO();
		user_id = dao.loginUser(user_name, user_password);
		if(user_id == 0){
			path = "/jsp/login_fail.jsp";
		}else{
			session.setAttribute("login", true);
		}


		session.setAttribute("user_id", user_id);

		ServletContext context =getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
