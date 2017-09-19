package br.com.pucminas.arquitetura.seed;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.github.javafaker.Faker;

import br.com.pucminas.arquitetura.modelo.Aluno;

public class AlunoSeed {

	@Inject
	private Faker faker;

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void seed() {
		IntStream.rangeClosed(1, 120).forEach(i -> {
			manager.persist(aluno());
		});		
	}	
	
	private Aluno aluno() {
		String id = UUID.randomUUID().toString();
		String nome = this.faker.name().fullName();		
		String matricula = matricula();
		Aluno aluno = new Aluno(id, matricula, nome);
		return aluno;
	}

	@SuppressWarnings("deprecation")
	private String matricula() {
		Calendar referencia = Calendar.getInstance();
		referencia.roll(Calendar.YEAR, 2);
		Date data = this.faker.date().past(3640, TimeUnit.DAYS, referencia.getTime());
		
		return String.format("%s%s", data.getYear(), this.faker.number().digits(8));
	}
}
