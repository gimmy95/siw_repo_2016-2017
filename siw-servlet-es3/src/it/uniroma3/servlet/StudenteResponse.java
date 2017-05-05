package it.uniroma3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraDati")
public class StudenteResponse extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// gestione della RISPOSTA
		
		Studente studente=(Studente) request.getAttribute("studente");
		// preparo il tipo (HTML)
		response.setContentType("text/html");
		// preparo un oggetto su cui scrivere la risposta
		PrintWriter out = response.getWriter();

		// scrivo il corpo
		out.println("<!DOCTYPE html>"); out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\" />");
		out.println("<title>mostra parametri</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Dati dello studente registrato</h1>");
		out.println("<ul>");
		out.println("<li>Nome: <b>"+studente.getNome()+"</b></li>");
		out.println("<li>Cognome: <b>"+studente.getCognome()+"</b></li>");
		out.println("<li>Matricola: <b>"+studente.getMatricola()+"</b></li>");
		out.println("</ul>");
		out.println("<h1>Altri dati relativi alla richiesta</h1>");
		out.println("<br />IP: <b>"+(String)request.getRemoteAddr()+"</b>");
		out.println("<br />Host: <b>"+(String)request.getRemoteHost()+"</b>");
		out.println("<br />User Agent: <b>"+request.getHeader("User-Agent")+"</b>");
		out.println("</body>\n</html> ");
	}

}
