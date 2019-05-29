package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public LoginFilter() { }
	public void destroy() {}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;

		HttpSession session=httpRequest.getSession();
		if(session.getAttribute("login")==null){
			session.setAttribute("login", false);
		}

		//リダイレクトが、無限ループすることへの対策
		if(httpRequest.getRequestURI().equals("/auction/index.html")){
			chain.doFilter(httpRequest, httpResponse);
		//ログイン処理、登録処理要求はそのままスルー
		}else if(httpRequest.getRequestURI().equals("/auction/jsp/login.jsp")){
			chain.doFilter(httpRequest, httpResponse);
		}else if(httpRequest.getRequestURI().equals("/auction/jsp/register.jsp")){
			chain.doFilter(httpRequest, httpResponse);
		}else if(httpRequest.getRequestURI().equals("/auction/RegisterConfirmController")){
			chain.doFilter(httpRequest, httpResponse);
		}else if(httpRequest.getRequestURI().equals("/auction/RegisterResultController")){
			chain.doFilter(httpRequest, httpResponse);
		}else if(httpRequest.getRequestURI().equals("/auction/css/bootstrap.min.css")){
			chain.doFilter(httpRequest, httpResponse);
		}else if(httpRequest.getRequestURI().equals("/auction/img/porilogo.png")){
			chain.doFilter(httpRequest, httpResponse);
		}
		else if(httpRequest.getRequestURI().equals("/auction/LoginController")){
			chain.doFilter(httpRequest, httpResponse);
		//ログイン後は全てのページにアクセス
		}else if((Boolean)session.getAttribute("login")){
						chain.doFilter(httpRequest, httpResponse);
		}else{
			httpResponse.sendRedirect("http://192.168.32.106:8080/auction/index.html");
		//	httpResponse.sendRedirect("http://localhost:8080/auction/index.html");

		}
	}
	public void init(FilterConfig fConfig) throws ServletException {}
}
