package servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterConfirmController")
public class RegisterConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String path = "/jsp/register_confirm.jsp";

		String user_name = request.getParameter("user_name");

		Pattern pattern = Pattern.compile("^[\\w]+$");
		Matcher matcher = pattern.matcher(user_name);
		if(matcher.matches()){
			request.setAttribute("user_name", user_name);
		}
		else{
			path = "/jsp/register_fail.jsp";
		}

		//同じユーザー名登録をはじく
		UserDAO dao = new UserDAO();
		Boolean bln = dao.checkUser(user_name);
		if(bln){
			String errlog = "すでに同名のユーザーが登録されています。";
			request.setAttribute("errlog",errlog);
			path = "/jsp/register.jsp";
		}


		String user_password = request.getParameter("user_password");

		Pattern pattern2 = Pattern.compile("^[\\w]+$");
		Matcher matcher2 = pattern2.matcher(user_password);
		if(matcher2.matches()){
			request.setAttribute("user_password", user_password);
		}
		else{
			path = "/jsp/register_fail.jsp";
		}
		ServletContext context =getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
