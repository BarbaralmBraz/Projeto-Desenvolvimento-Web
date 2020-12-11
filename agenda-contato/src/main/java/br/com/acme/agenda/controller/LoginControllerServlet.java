package br.com.acme.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.acme.agenda.controller.ContatoControllerServlet;
import br.com.acme.agenda.model.Usuario;
import br.com.acme.agenda.service.UsuarioService;
import br.com.acme.agenda.service.UsuarioServiceImpl;

/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioService service;
	private ContatoControllerServlet contatoController;
	
	
	public LoginControllerServlet() {
		this.service = new UsuarioServiceImpl();
		this.contatoController = new ContatoControllerServlet();
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario;
		try {
			usuario = this.service.login(login, senha);
			if(usuario == null) {
				RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				request.getSession().setAttribute("nomeUsuario", usuario.getNome() + " " + usuario.getSobrenome());
				rd.forward(request, response);
			
			}
		}	
		catch(Exception e){
			RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		/**
		 * Verificar se o usuári é valido.
		 * 	Se for, direciona ele para a tela principal/dashboard
		 *  Se não, direciona para a tela de falha no login.
		 *  
		 *  
		 *  
		 */
	}
			
}
