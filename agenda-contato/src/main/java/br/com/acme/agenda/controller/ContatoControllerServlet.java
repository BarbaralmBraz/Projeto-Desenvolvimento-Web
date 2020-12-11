package br.com.acme.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.service.ContatoService;
import br.com.acme.agenda.service.ContatoServiceImpl;
import br.com.acme.agenda.utils.Constantes;
import net.bytebuddy.asm.Advice.This;

/**
 * Servlet implementation class ContatoControllerServlet 
 * PRIMEIRA CAMADA
 */
@WebServlet("/contatoControllerServlet")
public class ContatoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Contato contato;
	private ContatoService service;
	private List<Contato> contatos;
	
	public ContatoControllerServlet() {
		this.service = new ContatoServiceImpl();
		this.contatos = new ArrayList<Contato>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int action = 0;
		if(request.getParameter("action") != null) {
			 action = Integer.valueOf(request.getParameter("action"));
		}
				
		long idLong = -1;
		
		if(id != null && ! id.equals("")) {
			idLong = Long.parseLong(id);
		}	
		
		switch (action) {
			case 1:
				this.service.ativarDesativarContato(idLong);
				request.setAttribute("status", "Contato desativado/ativado com sucesso");
				break;
			case 2:
				this.service.remover(idLong);
				request.setAttribute("remover", "Contato removido com sucesso");
				break;
			default:
				break;
			}
		
		this.contatos = this.service.listarContatos();
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.LISTAR_CONTATOS);
		request.setAttribute("contatos", this.contatos);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idContato = request.getParameter("idContato");
		
		//RECUPEREI OS DADOS DO REQUEST / FORMULÃ�RIO
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		boolean validEmail;
	
		this.contato = new Contato();
		
		//SET OS ATRIBUTOS NA INSTANCIA DE CONTATO
		this.contato.setNome(nome);
		this.contato.setEmail(email);
		this.contato.setTelefone(telefone);
		this.contato.setAtivo(true);
		validEmail = validEmail(email);
		if(idContato != null && !idContato.equals("")) {
			this.service.editarContato(Long.parseLong(idContato), this.contato);
			request.setAttribute("sucesso", "Contato " + nome + " editado com sucesso");
		}
		else if(!validEmail) {
			//CHAMO A CAMADA DE SERVICE PARA SALVAR O CONTATO
			this.service.salvar(this.contato);			
			//REDIRECIONANDO PARA A LISTAGEM DE CONTATOS
			request.setAttribute("sucesso", "Contato " + nome + " cadastrado com sucesso");

		}else if(validEmail) {
			request.setAttribute("contatoExiste", "Contato com e-mail " + email + " jÃ¡ existe");
		}
		doGet(request, response);
	}
	
	
	private boolean validEmail(String email) {
		
		try {
			Contato contato = this.service.buscaPorEmail(email);
			if(contato != null) {
				return true;
			}
			
			else {
				return false;
			}
			
		}
		
		catch (Exception e) {
			return false;
		}
		
	}
	
	
	
}







