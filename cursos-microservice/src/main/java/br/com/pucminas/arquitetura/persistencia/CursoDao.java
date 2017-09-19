package br.com.pucminas.arquitetura.persistencia;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.pucminas.arquitetura.modelo.Curso;

public class CursoDao {

	@PersistenceContext
	private EntityManager manager;
	
	public Optional<Curso> peloId(String id) {
		TypedQuery<Curso> query = manager.createQuery("from Curso c where c.id = :id", Curso.class);
		query.setParameter("id", id);
		List<Curso> lista = query.getResultList();
		Optional<Curso> curso = (lista.isEmpty()) ? Optional.empty() : Optional.of(lista.get(0)); 
		return curso;
	}
	
	public List<Curso> todos() {
		return manager.createQuery(
			"from Curso c",
			Curso.class).getResultList();
	}
	
}
