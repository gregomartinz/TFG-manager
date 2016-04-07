package es.dit.upm.isst.t4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.dit.isst.t4.model.TFG;

public class TFGDAOImpl implements TFGDAO {
	
	private static TFGDAOImpl instance;

	public TFGDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static TFGDAOImpl getInstance() {
		if (instance == null) {
			instance = new TFGDAOImpl();
		}
		return instance;
	}

	//Función que crea un TFG con los valores que se le pasen
	@Override
	public void create(String autor, String titulo, String resumen,
			String tutor, String secretario, String fichero, Boolean estado) {
		
		EntityManager em = EMFService.get().createEntityManager();
		TFG tfg = new TFG(autor, titulo, resumen, tutor, secretario, fichero, estado);
		
		try {
			em.persist(tfg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Crear");
		}
		em.close();
	}
	
	//Función que cambia algún parámetro de un TFG
	@Override
	public void update(TFG tfg) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		try {
			em.merge(tfg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		em.close();

	}

	//Función que borra el TFG que le pasemos cómo objeto
	@Override
	public void delete(TFG tfg) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		try {
			em.persist(tfg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		em.close();

	}

	//Función que lista los TFGs que pertenezcan a un autor
	@Override
	public List<TFG> listTFGAutor(String autor) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from TFG m where m.autor =:autor");
		q.setParameter("autor", autor);
		List<TFG> t = q.getResultList();
		em.close();
		return t;
	}

	//Función que lista todos los TFGs
	@Override
	public List<TFG> listTFGAll() {

		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from TFG m");
		List<TFG> t = q.getResultList();
		em.close();
		return t;
	}

	//Función que lista los TFGs de un tutor
	@Override
	public List<TFG> listTFGTutor(String tutor) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from TFG m where m.tutor =:tutor");
		q.setParameter("tutor", tutor);
		List<TFG> t = q.getResultList();
		em.close();
		return t;
	}

	//Función que lista los TFGs de un secretario
	@Override
	public List<TFG> listTFGSecretario(String secretario) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from TFG m where m.secretario =:secretario");
		q.setParameter("secretario", secretario);
		List<TFG> t = q.getResultList();
		em.close();
		return t;
	}

	//Función que lista los TFGs en un estado
	@Override
	public List<TFG> listTFGEstado(Boolean estado) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from TFG m where m.estado =:estado");
		q.setParameter("estado", estado);
		List<TFG> t = q.getResultList();
		em.close();
		return t;
	}

}
