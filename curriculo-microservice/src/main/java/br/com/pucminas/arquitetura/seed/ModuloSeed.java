package br.com.pucminas.arquitetura.seed;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.github.javafaker.Faker;

import br.com.pucminas.arquitetura.modelo.Aluno;
import br.com.pucminas.arquitetura.modelo.Dia;
import br.com.pucminas.arquitetura.modelo.Disciplina;
import br.com.pucminas.arquitetura.modelo.GradeCurricular;
import br.com.pucminas.arquitetura.modelo.Modulo;
import br.com.pucminas.arquitetura.modelo.Professor;

public class ModuloSeed {

	@Inject
	private Faker faker;

	@PersistenceContext
	private EntityManager manager;

	private List<Aluno> alunos;
	private List<Professor> professores;
	private List<String> disciplinas;
	
	@Transactional
	public void seed() {
		this.carregaPessoas();
		manager.persist(grade());
	}	
	
	private GradeCurricular grade() {
		Calendar data = Calendar.getInstance();
		data.set(Calendar.MONTH, Calendar.JANUARY);
		data.set(Calendar.DAY_OF_MONTH, 10);
		
		String curso = UUID.randomUUID().toString();
		Date inicio = data.getTime();
		
		data.set(Calendar.MONTH, Calendar.JULY);
		data.set(Calendar.DAY_OF_MONTH, 10);
		
		Date fim = data.getTime();
		GradeCurricular grade = new GradeCurricular(curso, inicio, fim);
		IntStream.rangeClosed(1, 8).forEach(i -> {
			Modulo modulo = modulo(i);
			modulo.setCurriculo(grade);
			grade.getModulos().add(modulo);
		});
		
		return grade;
	}
	
	private Modulo modulo(int periodo) {
		this.disciplinas = this.nomeDisciplinas();
		String id = UUID.randomUUID().toString();
		Modulo modulo = new Modulo(id, periodo);
		for (Dia dia : Dia.values()) {
			Calendar horario = Calendar.getInstance();
			horario.set(Calendar.HOUR_OF_DAY, 8);
			horario.set(Calendar.MINUTE, 0);
			horario.set(Calendar.SECOND, 0);
			IntStream.rangeClosed(1, 6).forEach(i -> {
				Disciplina disciplina = disciplina(dia, horario);
				horario.setTime(disciplina.getFim());
				disciplina.setModulo(modulo);
				
				modulo.getDisciplinas().add(disciplina);
			});
		}
		
		return modulo;
	}
	
	private Disciplina disciplina(Dia dia, Calendar horario) {
		String id = UUID.randomUUID().toString();
		int index = this.faker.number().numberBetween(0, this.disciplinas.size()-1);
		String nome = this.disciplinas.get(index);
		Date inicio = horario.getTime();
		Date fim = this.adicionaHora(inicio);;
		Disciplina disciplina = new Disciplina(id, nome, inicio, fim, dia);
		
		disciplina.setProfessor(this.professor());
		
		return disciplina;
	}
	
	private List<String> nomeDisciplinas() {
		int numDisciplinas = this.faker.number().numberBetween(5, 8);
		ArrayList<String> disciplinas = new ArrayList<>();
		IntStream.rangeClosed(1, numDisciplinas).forEach(i -> {
			disciplinas.add(this.faker.app().name());
		});
		
		return disciplinas;
	}
	
	private Date adicionaHora(Date hora) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(hora);
		calendar.add(Calendar.HOUR, 1);
		
		return calendar.getTime();
	}

	private Professor professor() {
		int index = this.faker.number().numberBetween(0, professores.size()-1);
		return this.professores.get(index);
	}

	private Aluno aluno() {
		int index = this.faker.number().numberBetween(0, alunos.size()-1);
		return this.alunos.get(index);
	}
	
	@SuppressWarnings("unused")
	private ArrayList<Aluno> alunos(int quantidade) {
		ArrayList<Aluno> als = new ArrayList<>();
		IntStream.rangeClosed(1, quantidade).forEach(i -> {
			als.add(this.aluno());
		});
		return als;
	}
	
	private void carregaPessoas() {
		this.alunos = manager.createQuery("from Aluno", Aluno.class).getResultList();
		this.professores = manager.createQuery("from Professor", Professor.class).getResultList();
	}
}
