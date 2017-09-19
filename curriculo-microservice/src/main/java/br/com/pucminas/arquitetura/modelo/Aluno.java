package br.com.pucminas.arquitetura.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {

	@Id
	private String id;
	private String matricula;
	private String nome;
	
	public Aluno() {
	}
	
	public Aluno(String id, String matricula, String nome) {
		this();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	}