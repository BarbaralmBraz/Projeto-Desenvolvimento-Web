package br.com.acme.agenda.service;

import java.util.List;

import br.com.acme.agenda.model.Usuario;

public interface UsuarioService {
	
	public void salvar(Usuario usuario);

	public List<Usuario> listarUsuarios();

	public void remover(Long idUsuario);
	
	public Usuario login(String login, String senha);

	

}
