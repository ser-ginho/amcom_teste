package br.com.amcom.teste.dao;

import java.util.List;

import br.com.amcom.teste.interfaces.InterfacePersistencia;
import br.com.amcom.teste.model.Item;

public class ItemDAO implements InterfacePersistencia<Item> {

	DAO<Item> itemDao = new DAO<>();
	
	@Override
	public Item salvar(Item entidade) throws Exception {
		return itemDao.salvar(entidade);
	}
	
	@Override
	public Item buscar(int id) {
		return itemDao.buscar(new Item(), id);
	}

	@Override
	public void atualizar(Item entidade) throws Exception {
		itemDao.atualizar(entidade);
	}

	@Override
	public void remover(int id) throws Exception {
		itemDao.remover(new Item(), id);
	}

	@Override
	public List<Item> listar() {
		return itemDao.listar(new Item());
	}

}
