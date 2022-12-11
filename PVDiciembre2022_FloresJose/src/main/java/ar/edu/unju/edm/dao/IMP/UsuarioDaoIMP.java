package ar.edu.unju.edm.dao.IMP;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.edm.dao.IUsuarioDao;
import ar.edu.unju.edm.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioDaoIMP implements IUsuarioDao{

	@PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		
		return em.createQuery("from Usuario").getResultList();
	}
	@Override
	@Transactional
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		em.persist(usuario);
		
	}

}
