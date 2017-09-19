package br.com.pucminas.arquitetura.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.pucminas.arquitetura.modelo.Dia;
import br.com.pucminas.arquitetura.modelo.Disciplina;
import br.com.pucminas.arquitetura.persistencia.GradeCurricularDao;
import br.com.pucminas.arquitetura.seed.AlunoSeed;
import br.com.pucminas.arquitetura.seed.ModuloSeed;
import br.com.pucminas.arquitetura.seed.ProfessorSeed;

@Path("grade")
@Produces(MediaType.APPLICATION_JSON)
public class GradeResource {
	
	@Inject
	private ModuloSeed seed;
	
	@Inject
	private AlunoSeed aSeed;
	
	@Inject
	private ProfessorSeed pSeed;
	
	@Inject
	private GradeCurricularDao dao;	
	
//	@GET
	public Response seed() {
		seed.seed();
		return Response.ok().build();
	}
	
//	@GET @Path("a/seed")
	public Response aSeed() {
		aSeed.seed();
		return Response.ok().build();
	}

//	@GET @Path("p/seed")
	public Response pSeed() {
		pSeed.seed();
		return Response.ok().build();
	}
	
	@GET
	public Response status() {
		
		return Response.ok("{ \"status\": \"ok\" }").build();
	}
	
	@GET @Path("disciplinas/{periodo}")
	public Response disciplinas(@PathParam("periodo") String periodo) {		
		List<Disciplina> disciplinas = dao.disciplinasDo(Dia.SEGUNDA, Integer.valueOf(periodo));
		return Response.ok(disciplinas).build();
	}
	
	@GET @Path("disciplinas/professor/{id}")
	public Response disciplinasDoProfessor(@PathParam("id") String id) {		
		List<Disciplina> disciplinas = dao.disciplinasDoProfessor(id);
		return Response.ok(disciplinas).build();
	}
	
	@GET @Path("disciplinas/aluno/{matricula}")
	public Response disciplinasDoAluno(@PathParam("matricula") String matricula) {		
		List<Disciplina> disciplinas = dao.disciplinasDoAluno(matricula);
		return Response.ok(disciplinas).build();
	}
}
