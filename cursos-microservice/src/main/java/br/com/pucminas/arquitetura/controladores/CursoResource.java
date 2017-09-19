package br.com.pucminas.arquitetura.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.pucminas.arquitetura.modelo.Curso;
import br.com.pucminas.arquitetura.persistencia.CursoDao;
import br.com.pucminas.arquitetura.seed.CursosSeed;

@Path("cursos")
@Produces(MediaType.APPLICATION_JSON)
public class CursoResource {
	
	@Inject
	private CursoDao dao;
	
	@Inject
	private CursosSeed seed;
	
	@GET @Path("{id}")
	public Curso porId(@PathParam("id") String id) {
		return dao.peloId(id).get();
	}
	
	@GET
	public List<Curso> todos() {
		return dao.todos();
	}
	
	@GET @Path("adm/seed")
	public Response seed() {		
		this.seed.seed();
		System.out.println("Método de seed completo.");
		return Response.ok().build();
	}
}
