package br.com.caelum.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/minhaServlet")
public class MinhaServlet extends HttpServlet{
	
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			log("Iniciando a servlet");
		}
		
		public void destroy() {
			super.destroy();
			log("Destruindo a servlet");
		}
		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}
}
