package br.com.pucminas.arquitetura.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProfessorDao {

	@PersistenceContext
	private EntityManager manager;
}
