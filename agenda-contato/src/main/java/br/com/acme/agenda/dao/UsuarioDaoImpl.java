package br.com.acme.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.acme.agenda.model.Usuario;
import br.com.acme.agenda.utils.JPAUtil;

public class UsuarioDaoImpl implements UsuarioDao {
	
	@Override
	public void salvar(Usuario usuario) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public List<Usuario> listarUsuarios() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Query consulta = entityManager.createQuery("SELECT u FROM Usuario u");
		List<Usuario> listaDeUsuariosDoBancoDeDados = consulta.getResultList();
		entityManager.close();
		return listaDeUsuariosDoBancoDeDados;
	}

	@Override
	public void remover(Long idUsuario) {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Usuario usuario = entityManager.find(Usuario.class, idUsuario);
		entityManager.remove(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public Usuario buscarUsuario(String login) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Query consulta = entityManager.createQuery("SELECT u FROM Usuario u where u.login = \'" + login +"\'");
		Usuario usuario = (Usuario) consulta.getSingleResult();
		entityManager.close();
		return usuario;
	}



}
