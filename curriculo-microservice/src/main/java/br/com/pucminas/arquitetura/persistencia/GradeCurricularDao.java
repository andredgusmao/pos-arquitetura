package br.com.pucminas.arquitetura.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.pucminas.arquitetura.modelo.Dia;
import br.com.pucminas.arquitetura.modelo.Disciplina;

public class GradeCurricularDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Disciplina> disciplinasDo(Dia dia, int periodo) {
		TypedQuery<Disciplina> query = manager.createQuery(
				"SELECT d FROM Disciplina d WHERE d.dia = :dia AND d.modulo.periodo = :periodo ORDER BY d.dia, d.inicio",
				Disciplina.class);
		query.setParameter("dia", dia);
		query.setParameter("periodo", periodo);
		return query.getResultList();
	}

	public List<Disciplina> disciplinasDoProfessor(String id) {
		TypedQuery<Disciplina> query = manager.createQuery(
				"SELECT d FROM Disciplina d WHERE d.professor.id = :id ORDER BY d.dia, d.inicio",
				Disciplina.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public List<Disciplina> disciplinasDoAluno(String matricula) {
		TypedQuery<Disciplina> query = manager.createQuery(
				"SELECT d FROM Disciplina d join fetch d.alunos a WHERE a.matricula = :matricula ORDER BY d.dia, d.inicio",
				Disciplina.class);
		query.setParameter("matricula", matricula);
		return query.getResultList();
	}
}
