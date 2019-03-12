package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fiap.dao.FilmeDAO;
import br.com.fiap.dao.impl.FilmeDAOImpl;
import br.com.fiap.entity.Filme;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/filme")
public class FilmeResource {

	private FilmeDAO dao;
	
	public FilmeResource() {
		dao = new FilmeDAOImpl(
			EntityManagerFactorySingleton.getInstance()
			.createEntityManager());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Filme> buscar() {
		return dao.listar();
	}
	
}





