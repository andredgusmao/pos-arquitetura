package br.com.pucminas.arquitetura.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Disciplina {

	@Id
	private String id;
	
	private String nome;
	
	@Temporal(TemporalType.TIME)
	private Date inicio;
	
	@Temporal(TemporalType.TIME)
	private Date fim;
	
	@Enumerated(EnumType.STRING)
	private Dia dia;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Aluno> alunos;

	public Disciplina(String id, String nome, Date inicio, Date fim, Dia dia) {
		this.id = id;
		this.nome = nome;
		this.inicio = inicio;
		this.fim = fim;
		this.dia = dia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}

