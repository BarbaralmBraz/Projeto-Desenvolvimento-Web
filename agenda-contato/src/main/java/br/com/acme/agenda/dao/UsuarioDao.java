package br.com.acme.agenda.dao;

import java.util.List;

import br.com.acme.agenda.model.Usuario;

public interface UsuarioDao {
	
	public void salvar(Usuario Usuario);
	
	public List<Usuario> listarUsuarios();
	
	public void remover(Long idUsuario);
	
	public Usuario buscarUsuario(String login); 

	

}
