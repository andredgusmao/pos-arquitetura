package br.com.pucminas.arquitetura.seed;

import java.util.UUID;
import java.util.stream.IntStream;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import com.github.javafaker.Faker;

import br.com.pucminas.arquitetura.modelo.Curso;
import br.com.pucminas.arquitetura.modelo.Disciplina;
import br.com.pucminas.arquitetura.modelo.Modulo;
import br.com.pucminas.arquitetura.modelo.Turno;

public class CursosSeed {

	@Inject
	private Faker faker;

	@PersistenceContext
	private EntityManager manager;

	public CursosSeed() {
	}

	@Transactional
	public void seed() {
		try {
			System.out.println("Seed Cursos...");
			IntStream.rangeClosed(1, 20).forEach(i -> {
				System.out.println("Inserindo Curso " + i);
				int numModulos = this.faker.number().numberBetween(7, 13);
				Curso curso = this.curso(numModulos);
				manager.persist(curso);
			});
			manager.flush();
		} catch(PersistenceException e) {
			e.printStackTrace();
		}
	}

	public Disciplina disciplina() {
		String id = UUID.randomUUID().toString();
		String nome = this.faker.educator().course();
		String descricao = this.faker.lorem().sentence(8);
		return new Disciplina(id, nome, descricao);
	}

	public Modulo modulo(int periodo, int numDisciplinas) {
		String id = UUID.randomUUID().toString();
		Modulo modulo = new Modulo(id, periodo);

		IntStream.rangeClosed(1, numDisciplinas).forEach(i -> {
			Disciplina disciplina = this.disciplina();
			disciplina.setModulo(modulo);
			modulo.getDisciplinas().add(disciplina);
		});

		return modulo;
	}

	public Curso curso(int numModulos) {
		String id = UUID.randomUUID().toString();
		String nome = this.faker.educator().course();
		Turno turno = this.faker.options().option(Turno.class);
		Curso curso = new Curso(id, nome, turno);

		IntStream.rangeClosed(1, numModulos).forEach(periodo -> {
			Modulo modulo = modulo(periodo, this.faker.number().numberBetween(4, 6));
			modulo.setCurso(curso);
			curso.getModulos().add(modulo);
		});

		return curso;
	}

	public Faker faker() {
		return this.faker;
	}
}
