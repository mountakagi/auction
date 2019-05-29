package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GoodsDAO;

/**
 * Servlet implementation class DeleteResultController
 */
@WebServlet("/DeleteResultController")
public class DeleteResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int goods_id = Integer.parseInt(request.getParameter("goods_id"));
		GoodsDAO dao = new GoodsDAO();
		dao.deleteSellItem(goods_id);

		ServletContext context=getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher("/jsp/delete_result.jsp");
		rd.forward(request, response);
	}

}
