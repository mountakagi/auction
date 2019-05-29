package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BidDAO;
import model.Goods;

@WebServlet("/BuyResultController")
public class BuyResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session=request.getSession();
		String str = session.getAttribute("user_id").toString();
		int user_id = Integer.parseInt(str);


		int price = Integer.parseInt(request.getParameter("price"));


		Goods gds = (Goods)session.getAttribute("goods");
		int goods_id = gds.getGoods_id();

		String path="/jsp/buy_result.jsp";
		try{
			SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dead_time=sdFormat.parse(gds.getDead_time());
			Date now =new Date();

		long dead_timeTo=dead_time.getTime();
		long nowFrom=now.getTime();

		long time=(dead_timeTo-nowFrom)/600000;
		if(time>=0){
			BidDAO dao = new BidDAO();
			path=dao.buyItem(user_id, price, goods_id);
		}else{
			path="/jsp/time_out.jsp";
		}

		}catch(ParseException e){
			e.printStackTrace();
		}

		ServletContext context=getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
