package br.com.pucminas.arquitetura;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/painel")
public class PainelServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5259085036071880137L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/painel.jsp").forward(request, response);
	}
}
