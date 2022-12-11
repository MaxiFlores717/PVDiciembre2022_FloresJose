package ar.edu.unju.edm.dao;

import java.util.List;

import ar.edu.unju.edm.models.Usuario;

public interface IUsuarioDao {

	public List<Usuario> findAll();
	public void save(Usuario usuario);
}
