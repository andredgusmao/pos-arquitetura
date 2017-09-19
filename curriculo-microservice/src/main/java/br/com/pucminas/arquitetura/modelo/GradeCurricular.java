package br.com.pucminas.arquitetura.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "grade_curricular")
public class GradeCurricular {

	@Id
	private String curso;
	
	@Temporal(TemporalType.DATE)
	private Date inicio;
	
	@Temporal(TemporalType.DATE)
	private Date fim;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "curriculo_modulos", joinColumns = {
			@JoinColumn(name = "curriculo_id")
		}, inverseJoinColumns =  {
			@JoinColumn(name = "modulo_id")
		})
	private List<Modulo> modulos;
	
	public GradeCurricular() {
		this.modulos = new ArrayList<>();
	}
	
	public GradeCurricular(String curso, Date inicio, Date fim) {
		this();
		this.curso = curso;
		this.inicio = inicio;
		this.fim = fim;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
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

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}	
	
}
