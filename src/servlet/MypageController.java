package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GoodsDAO;
import model.Goods;

/**
 * Servlet implementation class MypageController
 */
@WebServlet("/MypageController")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session=request.getSession();
		String str = session.getAttribute("user_id").toString();
		int user_id = Integer.parseInt(str);

		GoodsDAO dao = new GoodsDAO();
		ArrayList<Goods> bidlist = dao.showBuddingItem(user_id);
		session.setAttribute("bidlist", bidlist);

		ServletContext context=getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher("/jsp/buy_mypage.jsp");
		rd.forward(request, response);
	}

}