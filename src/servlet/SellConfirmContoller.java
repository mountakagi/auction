package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Goods;

/**
 * Servlet implementation class SellConfirmContoller
 */
@WebServlet("/SellConfirmController")
@MultipartConfig(location="C:/webwork/auction/WebContent/img", maxFileSize=104857600)

public class SellConfirmContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


        Part part = request.getPart("file");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String str = sdf.format(timestamp);

        String file_name = str + this.getFileName(part);


        if(file_name.length() != 0){
            part.write(getServletContext().getRealPath("/image/") + file_name);
        } else {
        	file_name = "sample.jpg";

        }



		Goods gds=new Goods();

		try{
			gds.setGoods_name(request.getParameter("goods_name"));
			gds.setDescription(request.getParameter("description"));
			gds.setCategory(request.getParameter("category"));
			gds.setDead_time(request.getParameter("deadtime"));

			gds.setImage_uri("/auction/image/" + file_name);
			gds.setPrice(Integer.parseInt(request.getParameter("price")));

			request.setAttribute("goods",gds);

		}catch(Exception e){
			e.printStackTrace();
		}

		ServletContext context=getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher("/jsp/sell_confirm.jsp");
		rd.forward(request, response);
	}


    private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }


}
