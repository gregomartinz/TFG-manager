package es.dit.upm.isst.t4.dao;

import java.util.List;

import es.upm.dit.isst.t4.model.TFG;

public interface TFGDAO {

	public void create(String autor, String titulo, String resumen, String tutor, String secretario, String fichero, Boolean estado);
	
	public void update(TFG tfg);
	
	public void delete(TFG tfg);
	
	public List<TFG> listTFGAll();
	
	public List<TFG> listTFGTutor(String tutor);
	
	public List<TFG> listTFGSecretario(String secretario);
	
	public List<TFG> listTFGEstado(Boolean estado);

	public List<TFG> listTFGAutor(String autor);
}
