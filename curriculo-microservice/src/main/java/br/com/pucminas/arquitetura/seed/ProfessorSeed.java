package br.com.pucminas.arquitetura.seed;

import java.util.UUID;
import java.util.stream.IntStream;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.github.javafaker.Faker;

import br.com.pucminas.arquitetura.modelo.Professor;

public class ProfessorSeed {

	@Inject
	private Faker faker;

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void seed() {
		IntStream.rangeClosed(1, 30).forEach(i -> {
			manager.persist(this.professor());
		});
	}
	
	private Professor professor() {
		String id = UUID.randomUUID().toString();
		String nome = this.faker.name().fullName();
		Professor professor = new Professor(id, nome);
		return professor;
	}
}
