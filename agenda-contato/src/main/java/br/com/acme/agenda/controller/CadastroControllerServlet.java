package br.com.acme.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acme.agenda.model.Usuario;
import br.com.acme.agenda.service.UsuarioService;
import br.com.acme.agenda.service.UsuarioServiceImpl;

@WebServlet("/CadastroControllerServlet")
public class CadastroControllerServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private UsuarioService service;
	
	public CadastroControllerServlet() {
		this.usuario = new Usuario();
		this.service = new UsuarioServiceImpl();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
		
		
			this.usuario.setNome(nome);
			this.usuario.setSobrenome(sobrenome);
			this.usuario.setSenha(senha);
			this.usuario.setLogin(login);
			this.service.salvar(this.usuario);
			request.setAttribute("cadastroUsuario", "Cadastro realizado com sucesso!");
		}
		
		catch (Exception e) {
			request.setAttribute("cadastroUsuario", "Cadastro não realizado!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
	}
}
