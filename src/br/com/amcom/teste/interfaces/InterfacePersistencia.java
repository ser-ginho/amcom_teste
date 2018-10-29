package br.com.amcom.teste.interfaces;

import java.util.List;

public interface InterfacePersistencia<E> {
	
	public E salvar(E entidade) throws Exception;
	
	public void atualizar(E entidade) throws Exception;
	
	public void remover(int id) throws Exception;
	
	public List<E> listar();
	
	public E buscar(int id);

}
