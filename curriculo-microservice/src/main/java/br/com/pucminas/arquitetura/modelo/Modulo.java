package br.com.pucminas.arquitetura.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Modulo {
	
	@Id
	private String id;
	
	private Integer periodo;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "modulos_disciplinas", joinColumns = {
		@JoinColumn(name = "modulo_id")
	}, inverseJoinColumns =  {
		@JoinColumn(name = "disciplina_id")
	})
	private List<Disciplina> disciplinas;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculo_id")
	private GradeCurricular curriculo;

	public Modulo() {
		this.disciplinas = new ArrayList<>();
	}
	
	public Modulo(String id, Integer periodo) {
		this.id = id;
		this.periodo = periodo;
		this.disciplinas = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	@XmlTransient
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@XmlTransient
	public GradeCurricular getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(GradeCurricular curriculo) {
		this.curriculo = curriculo;
	}
	
}
