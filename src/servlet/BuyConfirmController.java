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
import javax.servlet.http.HttpSession;

import model.Goods;

/**
 * Servlet implementation class BuyConfirmController
 */
@WebServlet("/BuyConfirmController")
public class BuyConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session=request.getSession();

		String path = "/jsp/buy_confirm.jsp";

		String str = request.getParameter("price");

		Pattern pattern = Pattern.compile("^[\\d]+$");
		Matcher matcher = pattern.matcher(str);
		int price = 0;

		if(matcher.matches()){
			price = Integer.parseInt(str);
			request.setAttribute("price", price);
			Goods gds = (Goods)session.getAttribute("goods");
			int max_price = gds.getBid_price();
			int st_price = gds.getPrice();

			if(price <= max_price || price<=st_price){
				path="/jsp/buy_fail.jsp";
			}
		}else{
			path = "/jsp/number_fail.jsp";
		}





		ServletContext context=getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
