package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteConfirmController
 */
@WebServlet("/DeleteConfirmController")
public class DeleteConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int goods_id = Integer.parseInt(request.getParameter("goods_id"));
		request.setAttribute("goods_id", goods_id);

		ServletContext context=getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher("/jsp/delete_confirm.jsp");
		rd.forward(request, response);
	}

}
