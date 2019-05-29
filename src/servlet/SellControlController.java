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
import model.Goods;

/**
 * Servlet implementation class SellControlController
 */
@WebServlet("/SellControlController")
public class SellControlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int goods_id = Integer.parseInt(request.getParameter("goods_id"));

		GoodsDAO dao = new GoodsDAO();
		Goods gds = dao.showItem(goods_id);

//		BidDAO daos = new BidDAO();
//		Bid gdss = daos.showItem(bid_price);

		HttpSession session=request.getSession();
		session.setAttribute("goods", gds);

		ServletContext context=getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher("/jsp/control.jsp");
		rd.forward(request, response);
	}

}
