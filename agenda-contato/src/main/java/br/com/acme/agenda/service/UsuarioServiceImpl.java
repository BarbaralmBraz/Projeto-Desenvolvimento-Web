package br.com.acme.agenda.service;

import java.util.List;

import javax.persistence.NoResultException;

import br.com.acme.agenda.dao.UsuarioDao;
import br.com.acme.agenda.dao.UsuarioDaoImpl;
import br.com.acme.agenda.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService {
	
private UsuarioDao usuarioDao;
	
	public UsuarioServiceImpl() {
		usuarioDao = new UsuarioDaoImpl(); 
	}

	@Override
	public void salvar(Usuario usuario) {
		this.usuarioDao.salvar(usuario);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return this.usuarioDao.listarUsuarios();
	}

	@Override
	public void remover(Long idUsuario) {
		this.usuarioDao.remover(idUsuario);
	}
	
	
	@Override
	public Usuario login(String login, String senha) {
		
		Usuario usuario;
		
		try {
			usuario = this.usuarioDao.buscarUsuario(login);
		}
		
		catch(Exception e){
			throw e;
			
		}
		
		String senhaUsuario = usuario.getSenha();
		
		if(senhaUsuario.equals(senha)) {
			return usuario;
		}
		else {
			return null;
		}
	}


}

//NoResultException 
