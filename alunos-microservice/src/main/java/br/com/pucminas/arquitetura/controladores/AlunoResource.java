package br.com.pucminas.arquitetura.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.pucminas.arquitetura.modelo.Aluno;
import br.com.pucminas.arquitetura.persistencia.AlunosDao;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResource {

	@Inject
	private AlunosDao dao;
	
	@GET
	public List<Aluno> todos() {
		return dao.todos();
	}
}
