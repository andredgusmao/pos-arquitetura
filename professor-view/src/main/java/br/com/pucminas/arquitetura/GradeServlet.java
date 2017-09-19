package br.com.pucminas.arquitetura;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/horarios/*")
public class GradeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5259085036071880137L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String professor = request.getParameter("professor");
//		String[] path = request.getPathInfo().split("/");
		request.setAttribute("professor", professor);
		request.getRequestDispatcher("/WEB-INF/view/horarios.jsp").forward(request, response);
	}
}
