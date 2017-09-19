package br.com.pucminas.arquitetura.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pucminas.arquitetura.modelo.Aluno;

public class AlunosDao {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Aluno> todos() {
		return manager.createQuery("from Aluno a", Aluno.class).getResultList();
	}
}
