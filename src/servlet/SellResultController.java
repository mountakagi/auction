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
 * Servlet implementation class SellResultController
 */
@WebServlet("/SellResultController")
public class SellResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String str = session.getAttribute("user_id").toString();
		int user_id = Integer.parseInt(str);

		Goods gds=new Goods();

		try{
			gds.setGoods_name(request.getParameter("goods_name"));
			gds.setDescription(request.getParameter("description"));
			gds.setCategory(request.getParameter("category"));
			gds.setImage_uri(request.getParameter("img_path"));
			gds.setDead_time(request.getParameter("dead_time"));
			gds.setPrice(Integer.parseInt(request.getParameter("price")));
			gds.setOwner_id(user_id);

		}catch(Exception e){
			e.printStackTrace();
		}

		GoodsDAO dao = new GoodsDAO();
		dao.sellItem(gds);

		ServletContext context=getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher("/jsp/sell_result.jsp");
		rd.forward(request, response);
	}

}
